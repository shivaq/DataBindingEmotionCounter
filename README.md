EmotionCounter
==========
感情ボタンを押すと、その感情に応じたセリフをランダムに表示

Dagger2
-------
Architecture Components も Dagger2 で依存注入
ViewModel も ViewModelFactory もまとめて ViewModelModule に登録して
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




Room
-------
Room で データベースを定義
```java
@Database(entities = {CharacterEntry.class, MonologueEntry.class, EmotionEntry.class,
    RemarkEntry.class}, version = 5)
public abstract class EmotionDatabase extends RoomDatabase {

  public abstract CharacterDao characterDao();
  ...
}
```
