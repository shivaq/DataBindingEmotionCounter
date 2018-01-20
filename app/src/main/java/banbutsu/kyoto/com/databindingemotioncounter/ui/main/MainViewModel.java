package banbutsu.kyoto.com.databindingemotioncounter.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import banbutsu.kyoto.com.databindingemotioncounter.data.Repository;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;
import javax.inject.Inject;

/**
 * Created by Yasuaki on 2018/01/14.
 * ViewModels survive configuration changes.
 * While this is true, ViewModels do not survive resource constraint related process death.
 * This is different than onSaveInstanceState, which does survive process death.
 *
 * ★ ★ ViewModel を Factory 経由で生成する理由 ★ ★
 * ViewModel は Activity や Fragment、 View などの context を取得する事を避ける必要がある。
 * それらの OBJ は ViewModel より lifespan が短いため、抱え込むと GC を妨げて
 * メモリーリークにつながってしまうから。
 */
public class MainViewModel extends ViewModel {

  //  setValue(T) 及び postValue(T) を使う用 LiveData


  private final Repository repository;
  private int currentCharacterId;
  private Context appContext;

  @Inject
  public MainViewModel(Repository repository, Context appContext) {
    remark = new MutableLiveData<>();
    this.repository = repository;
    this.appContext = appContext;
  }

//  public LiveData<CharacterEntry> getCharacter() {
//    return repository.getCharacterById(currentCharacterId);
//  }

  private final LiveData<RemarkEntry> remark;
  public LiveData<RemarkEntry> getRemark() {
    return remark;
  }


  public void firstLaunchCheck() {
    repository.firstLaunchCheck();
    tomorrowCheck();
  }

  public boolean tomorrowCheck() {
    boolean isDateChanged = false;
    long now = System.currentTimeMillis();
    long tomorrow = repository.retrieveTomorrow();

    if (tomorrow == 0L) {// 初ローンチ
      repository.putTomorrow();
      // Emission を新規作成
      // 新しい Emission を取得させる


    } else if (now >= tomorrow) {// 日付が変わった
      // Emission を新規作成
      // 新しい Emission を取得させる
      transform();
      repository.putTomorrow();
      isDateChanged = true;



    }else{// 同じ日の2回め以降
//      getEmission();



    }
    return isDateChanged;
  }

//  public MonologueEntry getEmission() {
//    return repository.getEmission();
//  }

  // TODO: 人物アイコンを変える
  private void transform() {

  }
}
