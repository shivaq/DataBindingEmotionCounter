感情ぽちぽっち
==========
Architecture Components に慣れるために作ったサンプルアプリ。
感情ボタンを押すと、その感情に応じたセリフをランダムに表示する。
感情ごとにセリフの追加、編集、削除が可能。
![screenshot_20180123-135326_framed](https://user-images.githubusercontent.com/22390344/35258966-4d67bace-0046-11e8-833e-26daba558ebc.png)
![screenshot_20180123-135440_framed](https://user-images.githubusercontent.com/22390344/35258965-4d43fc42-0046-11e8-9507-d932fd9cd2e9.png)

- [Dagger2](#dagger2)
- [Room](#room)
- [Repository](#repository)
- [ViewModel](#viewmodel)
- [View](#view)
- [DataBinding](#databinding)
- [DataBoundRvAdapter](#databoundrvadapter)

## Dagger2
Architecture Components も Dagger2 で依存注入
ViewModel も ViewModelFactory もまとめて ViewModelModule に登録
```java
@Module
public abstract class ViewModelModule {

  @Binds
  @IntoMap
  @ViewModelKey(RemarkViewModel.class)// @MapKey
  public abstract ViewModel bindRemarkViewModel(RemarkViewModel remarkViewModel);

  @Binds
  @IntoMap
  @ViewModelKey(MainViewModel.class)
  public abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);

  @Binds
  public abstract ViewModelProvider.Factory bindViewModelFactory(EmotionViewModelFactory factory);
}
```


ApplicationModule に ViewModelModule を include。
各Dao と Database も登録
```java
@Module(includes = ViewModelModule.class)// includes で ViewModelModule も 組み込まれた
public class ApplicationModule {

  @Provides
  @Singleton
  Context provideContext(Application application) {
    return application;
  }

  @Provides
  @PreferenceInfo
  String providePreferenceName() {
    return Constants.PREF_FILE_NAME;
  }

  @Provides
  @Singleton
  public EmotionDatabase provideDatabase(@DatabaseInfo String dbName, Application application) {
    return Room.databaseBuilder(application, EmotionDatabase.class, dbName).fallbackToDestructiveMigration().build();
  }

  @Singleton
  @Provides
  public CharacterDao provideCharacterDao(EmotionDatabase db) {
    return db.characterDao();
  }
  ...
}
```


Activity は ActivityModuleへ登録
```java
@Module
public abstract class ActivityBuilderModule {

  @ContributesAndroidInjector
  public abstract MainActivity contributeMainActivity();

  @ContributesAndroidInjector
  public abstract RemarksActivity contributeListActivity();
}

```




## Room
Room で データベースを定義
```java
@Database(entities = {CharacterEntry.class, MonologueEntry.class, EmotionEntry.class,
    RemarkEntry.class}, version = 5)
public abstract class EmotionDatabase extends RoomDatabase {

  public abstract CharacterDao characterDao();
  ...
}
```

Boilerplate も消えて、クエリもコンパイル時チェックされている
```java
@Dao
public interface RemarkDao {

  @Insert
  void bulkInsert(List<RemarkEntry> remarkEntries);

  @Insert
  void insert(RemarkEntry remarkEntry);

  @Query("UPDATE remarks SET emotion = :emotion, say = :say WHERE id = :id")
  void update(String emotion, String say, long id);

  @Query("SELECT * FROM remarks WHERE emotion = :emotion")
  LiveData<List<RemarkEntry>> getRemarkByEmotion(String emotion);

  @Query("DELETE FROM remarks WHERE id =:remarkId")
  void delete(long remarkId);
}
```

テーブル定義はこんな感じ
```java
@Entity(tableName = "monologues",
    indices={@Index("characterId"),@Index("emotionId")},
    foreignKeys = {
        @ForeignKey(
            entity = CharacterEntry.class,
            parentColumns = "id",
            childColumns = "characterId",
            onDelete = CASCADE),
        @ForeignKey(
            entity = EmotionEntry.class,
            parentColumns = "id",
            childColumns = "emotionId",
            onDelete = CASCADE)})
public class MonologueEntry {

  @PrimaryKey(autoGenerate = true)
  public int id;
  public long date;
  public int characterId;
  public int emotionId;

  public MonologueEntry(long date, int characterId, int emotionId) {
    this.date = date;
    this.characterId = characterId;
    this.emotionId = emotionId;
  }
  ...
}

```

## Repository
Repository から Dao 経由で Sqlite にアクセス
```java
@Singleton
public class Repository {

  private final PreferencesHelper preferencesHelper;
  private final CharacterDao characterDao;
  private final MonologueDao monologueDao;
  private final EmotionDao emotionDao;

  private final RemarkDao remarkDao;
  private final MyExecutor executor;

  @Inject
  public Repository(
      PreferencesHelper preferencesHelper,
      CharacterDao characterDao,
      MonologueDao monologueDao, EmotionDao emotionDao,
      RemarkDao remarkDao, MyExecutor executor) {
    this.preferencesHelper = preferencesHelper;
    this.characterDao = characterDao;
    this.monologueDao = monologueDao;
    this.emotionDao = emotionDao;
    this.remarkDao = remarkDao;
    this.executor = executor;
  }

  ////////////////////// Remark ///////////////////////////
  public LiveData<List<RemarkEntry>> getRemarkByEmotion(String emotion) {
    return remarkDao.getRemarkByEmotion(emotion);
  }

  public void insertRemark(String emotion, String say) {
    executor.diskIO().execute(() -> remarkDao.insert(new RemarkEntry(emotion, say)));

  }

  public void updateRemark(String emotion, String say, long remarkId) {
    executor.diskIO().execute(() -> remarkDao.update(emotion, say, remarkId));
  }

  public void deleteRemark(long remarkId) {
    executor.diskIO().execute(() -> remarkDao.delete(remarkId));
  }
  ...
}
```

## ViewModel
各  ViewModel は Repository へアクセス

```java
public class MainViewModel extends ViewModel {

  private final Repository repository;

  private final LiveData<List<RemarkEntry>> joyRemarksLive;
    ...
    
  @Inject
  public MainViewModel(Repository repository) {
    tripleEmotions = new MutableLiveData<>();
    joyRemarksLive = repository.getRemarkByEmotion(Utility.JOY_E);
    ...
    this.repository = repository;
  }


  LiveData<List<RemarkEntry>> getRemarksByEmotion(String emotion) {
    switch (emotion) {
      case Utility.JOY_E:
        return joyRemarksLive;
    ...
      case Utility.NOTHING_E:
      default:
        return nothingRemarksLive;
    }
  }
  ...
}
  ...
  private void subscribeToEmotions() {
    viewModel.getTripleEmotions().observe(this, emotions -> {
      if (emotions != null) {

        // 感情文字セット
        binding.tvEmotion1.setText(emotions.getEmotion1());
        binding.tvEmotion2.setText(emotions.getEmotion2());
    ...     
      }
    });
  }
```

## View
MainActivity はコンシューマとして ViewModel の LiveData を Observe。
UI の感情ボタンは、DataBinding を使って ViewModel に感情データを送る。
ViewModel で感情オブジェクト TripleEmotions を更新。

TripleEmotions は、「ViewModel はデータストリームだけではなく、
View の状態も expose すべし」という考えに沿って、
いくつかのフィールドをカプセル化した オブジェクト。

ViewModel にて、押下された感情の組み合わせによって、複合感情をセットするロジックや、
セリフをランダム表示するロジックで更新されている。

TripleEmotions に対する Observe によって、UI の感情セリフが表示される。

```java
public class MainActivity extends BaseActivity {
  ...
  @Inject
  ViewModelProvider.Factory viewModelFactory;
  private MainViewModel viewModel;
  private ActivityMainBinding binding;

  ///////////////////////////  ライフサイクル達   /////////////////////////////////
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    binding.setMain(this);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
    viewModel.firstLaunchCheck();

    subscribeToRemarkLists();
    subscribeToEmotions();
  }

  ///////////////////////////  ViewModel とのやり取り   /////////////////////////////////
  public void speak(String emotion) {
    viewModel.setEmotions(emotion);
  }

  private void subscribeToRemarkLists() {
    viewModel.getRemarksByEmotion(Utility.JOY_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.JOY_E, remarkList);
      }
    });
  

}
```

## DataBinding
感情ボタンから感情情報を送っている

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto"
  xmlns:tools="http://schemas.android.com/tools"
  >
  <data>
    <import type="android.view.View"/>

    <variable
      name="main"
      type="banbutsu.kyoto.com.databindingemotioncounter.ui.main.MainActivity"/>

    <variable
      name="util"
      type="banbutsu.kyoto.com.databindingemotioncounter.utils.Utility"
      />

  </data>
<!-- ImageView をタッチすると、選択した感情が ViewModel まで送られていく -->
      <ImageView
        android:id="@+id/img_self_respect"
        style="@style/emotion_button"
        android:onClick='@{() -> main.speak(@string/self_respect)}'
        app:srcCompat="@drawable/ic_face_self_respect_selected"
        />
</layout>
```
## DataBoundRvAdapter
DataBinding に対応した RecyclerView adapter の抽象クラス

```java
public abstract class DataBoundRvAdapter<T, V extends ViewDataBinding>
    extends RecyclerView.Adapter<DataBoundViewHolder<V>> {

  protected abstract V createBinding(ViewGroup parent);

  @Override
  public DataBoundViewHolder<V> onCreateViewHolder(ViewGroup parent, int viewType) {
    // 具象クラスのほうで ViewDataBinding を実装して受け取る
    V binding = createBinding(parent);
    return new DataBoundViewHolder<>(binding);
  }

  protected abstract void bindObjToItem(V binding, T item);

  @Nullable
  private List<T> list;

  @Override
  public void onBindViewHolder(DataBoundViewHolder<V> holder, int position) {

    // $1: ViewDataBinding $2: xml の <data> 経由でアクセスさせる List
    bindObjToItem(holder.binding, list.get(position));
    // executePendingBindings:View が持つ式に紐付いた変数 が変化した時、View を更新する。
    // スクロール時に Binding がなされているかチェックすることで、挙動を安定させる
    holder.binding.executePendingBindings();
  }

  @Override
  public int getItemCount() {
    if (list != null) {
      Timber.d("DataBoundRvAdapter:getItemCount: list size:%s",list.size());
    }
    return list == null ? 0 : list.size();
  }

  /********************* DiffUtil を AsyncTask で実行 ********************************/
  protected abstract boolean areItemsTheSame(T oldItem, T newItem);

  protected abstract boolean areContentsTheSame(T oldItem, T newItem);

  // each time data is set, we update this variable so that if DiffUtil calculation returns
  // after repetitive updates, we can ignore the old calculation
  private int dataVersion = 0;

  @SuppressLint("StaticFieldLeak")
  @MainThread
  public void replaceWithDiffUtil(List<T> listToUpdate) {
    dataVersion++;
    // 既存のリスト 及び 置換候補リストをnullチェック
    if (list == null) {
      if (listToUpdate == null) {
        return;
      }
      list = listToUpdate;
      notifyDataSetChanged();
    } else if (listToUpdate == null) {
      int oldSize = list.size();
      list = null;
      notifyItemRangeRemoved(0, oldSize);
    } else {// 要置換
      final int startVersion = dataVersion;
      final List<T> oldList = list;
      new AsyncTask<Void, Void, DiffResult>() {

        @Override
        protected DiffResult doInBackground(Void... voids) {
          return DiffUtil.calculateDiff(new Callback() {

            @Override
            public int getOldListSize() {
              return oldList.size();
            }

            @Override
            public int getNewListSize() {
              return listToUpdate.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
              T oldItem = oldList.get(oldItemPosition);
              T newItem = listToUpdate.get(newItemPosition);
              return DataBoundRvAdapter.this.areItemsTheSame(oldItem, newItem);
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
              T oldItem = oldList.get(oldItemPosition);
              T newItem = listToUpdate.get(newItemPosition);
              return DataBoundRvAdapter.this.areContentsTheSame(oldItem, newItem);
            }
          });
        }

        @Override
        protected void onPostExecute(DiffResult diffResult) {
          if (startVersion != dataVersion) {
            // update 不要
            return;
          }
          list = listToUpdate;
          Timber.d("DataBoundRvAdapter:onPostExecute: postExecute list size:%s",list.size());
          diffResult.dispatchUpdatesTo(DataBoundRvAdapter.this);
        }
      }.execute();
    }
  }
}

```

そしてその具象クラス
```java
public class RemarkRvAdapter extends DataBoundRvAdapter<RemarkEntry, RvItemRemarkListBinding> {

  private RemarkRvCallback remarkRvCallback;

  public RemarkRvAdapter(RemarkRvCallback remarkRvCallback) {
    this.remarkRvCallback = remarkRvCallback;
  }

  /**
   * ・アイテムのレイアウトから ViewBinding を生成させ、
   * アイテム内の 各View にクリックListener等をセット。
   *
   * ・返り値 の ViewBinding を RvAdapter の抽象クラスを経由させる
   *
   * ・ViewHolder のコンストラクタの引数に ViewBinding が渡される
   * @param parent
   * @return
   */
  @Override
  protected RvItemRemarkListBinding createBinding(ViewGroup parent) {

    // RecyclerView のアイテムの ViewBinding を取得
    RvItemRemarkListBinding binding =
        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
            R.layout.rv_item_remark_list, parent, false);

    binding.getRoot().setOnClickListener(v -> {
      RemarkEntry remark = binding.getRemark();
      if (remark != null && remarkRvCallback != null) {
        remarkRvCallback.onClick(remark);
      }
    });

    return binding;
  }

  @Override
  protected void bindObjToItem(RvItemRemarkListBinding binding, RemarkEntry remark) {
    // RvItem から <data> 内のアイテムにアクセスできるようにするため、
    // ViewDataBinding に OBJ を渡す
    binding.setRemark(remark);
  }

  @Override
  protected boolean areItemsTheSame(RemarkEntry oldItem, RemarkEntry newItem) {
    return ObjEqualCheck.equals(oldItem.id, newItem.id);
  }

  @Override
  protected boolean areContentsTheSame(RemarkEntry oldItem, RemarkEntry newItem) {
    return ObjEqualCheck.equals(oldItem.say, newItem.say)
        && ObjEqualCheck.equals(oldItem.emotion, newItem.emotion);
  }

  /***************************** Callback *********************************/
  interface RemarkRvCallback {

    void onClick(RemarkEntry remark);
  }
}

```
