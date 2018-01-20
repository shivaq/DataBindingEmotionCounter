package banbutsu.kyoto.com.databindingemotioncounter.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.graphics.drawable.Drawable;
import banbutsu.kyoto.com.databindingemotioncounter.data.Repository;
import banbutsu.kyoto.com.databindingemotioncounter.ui.view_model.TripleEmotions;
import banbutsu.kyoto.com.databindingemotioncounter.utils.Utility;
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
  private Context appContext;

  @Inject
  public MainViewModel(Repository repository, Context appContext) {
    tripleEmotions = new MutableLiveData<>();
    this.repository = repository;
    this.appContext = appContext;
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


    } else {// 同じ日の2回め以降
//      getEmission();

    }
    return isDateChanged;
  }

  // TODO: 人物アイコンを変える
  private void transform() {

  }

  private final MutableLiveData<TripleEmotions> tripleEmotions;

  LiveData<TripleEmotions> getTripleEmotions() {
    return tripleEmotions;
  }

  private String emStr1 = "";
  private String emStr2 = "";
  private String remark1 = "";
  private String remark2 = "";
  private Drawable drawable1 = null;
  private Drawable drawable2 = null;
  private String mixedEmotion1 = "";

  void setEmotions(String emotion) {
    String emStr3 = emStr2;
    emStr2 = emStr1;
    emStr1 = Utility.getEmotionString(emotion);

    String mixedEmotion2 = mixedEmotion1;
    mixedEmotion1 = Utility.getMixedEmotionString(emStr1,emStr2);

    String remark3 = remark2;
    remark2 = remark1;
    remark1 = "";

    Drawable drawable3 = drawable2;
    drawable2 = drawable1;
    drawable1 = appContext.getResources().getDrawable(Utility.getEmotionDrawable(emotion));
    TripleEmotions tm = new TripleEmotions(emStr1, emStr2, emStr3, remark1, remark2, remark3,
        drawable1, drawable2, drawable3, mixedEmotion1, mixedEmotion2);
    tripleEmotions.setValue(tm);
  }
}
