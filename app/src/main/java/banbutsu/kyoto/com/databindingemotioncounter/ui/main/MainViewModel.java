package banbutsu.kyoto.com.databindingemotioncounter.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import banbutsu.kyoto.com.databindingemotioncounter.data.Repository;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;
import banbutsu.kyoto.com.databindingemotioncounter.ui.view_model.TripleEmotions;
import banbutsu.kyoto.com.databindingemotioncounter.utils.Utility;
import java.util.List;
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

  private final Repository repository;

  private final LiveData<List<RemarkEntry>> joyRemarks;
  private final LiveData<List<RemarkEntry>> trustRemarks;
  private final LiveData<List<RemarkEntry>> fearRemarks;
  private final LiveData<List<RemarkEntry>> anticipationRemarks;
  private final LiveData<List<RemarkEntry>> sadnessRemarks;
  private final LiveData<List<RemarkEntry>> disgustRemarks;
  private final LiveData<List<RemarkEntry>> angerRemarks;
  private final LiveData<List<RemarkEntry>> surpriseRemarks;
  private final LiveData<List<RemarkEntry>> optimismRemarks;
  private final LiveData<List<RemarkEntry>> disappointmentRemarks;
  private final LiveData<List<RemarkEntry>> loveRemarks;
  private final LiveData<List<RemarkEntry>> remorseRemarks;
  private final LiveData<List<RemarkEntry>> submissionRemarks;
  private final LiveData<List<RemarkEntry>> contemptRemarks;
  private final LiveData<List<RemarkEntry>> aggressivenessRemarks;
  private final LiveData<List<RemarkEntry>> aweRemarks;
  private final LiveData<List<RemarkEntry>> libidoRemarks;
  private final LiveData<List<RemarkEntry>> shameRemarks;
  private final LiveData<List<RemarkEntry>> self_respectRemarks;
  private final LiveData<List<RemarkEntry>> nothingRemarks;

  @Inject
  public MainViewModel(Repository repository) {
    tripleEmotions = new MutableLiveData<>();
    joyRemarks = repository.getRemarkByEmotion(Utility.JOY_E);
    trustRemarks = repository.getRemarkByEmotion(Utility.TRUST_E);
    fearRemarks = repository.getRemarkByEmotion(Utility.FEAR_E);
    anticipationRemarks = repository.getRemarkByEmotion(Utility.ANTICIPATION_E);
    sadnessRemarks = repository.getRemarkByEmotion(Utility.SADNESS_E);
    disgustRemarks = repository.getRemarkByEmotion(Utility.DISGUST_E);
    angerRemarks = repository.getRemarkByEmotion(Utility.ANGER_E);
    surpriseRemarks = repository.getRemarkByEmotion(Utility.SURPRISE_E);
    optimismRemarks = repository.getRemarkByEmotion(Utility.OPTIMISM_E);
    disappointmentRemarks = repository.getRemarkByEmotion(Utility.DISAPPOINTMENT_E);
    loveRemarks = repository.getRemarkByEmotion(Utility.LOVE_E);
    remorseRemarks = repository.getRemarkByEmotion(Utility.REMORSE_E);
    submissionRemarks = repository.getRemarkByEmotion(Utility.SUBMISSION_E);
    contemptRemarks = repository.getRemarkByEmotion(Utility.CONTEMPT_E);
    aggressivenessRemarks = repository.getRemarkByEmotion(Utility.AGGRESSIVENESS_E);
    aweRemarks = repository.getRemarkByEmotion(Utility.AWE_E);
    libidoRemarks = repository.getRemarkByEmotion(Utility.LIBIDO_E);
    shameRemarks = repository.getRemarkByEmotion(Utility.SHAME_E);
    self_respectRemarks = repository.getRemarkByEmotion(Utility.SELF_RESPECT_E);
    nothingRemarks = repository.getRemarkByEmotion(Utility.NOTHING_E);

    this.repository = repository;
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


  LiveData<List<RemarkEntry>> getRemarksByEmotion(String emotion) {

    switch (emotion) {
      case Utility.JOY_E:
        return joyRemarks;
      case Utility.TRUST_E:
        return trustRemarks;
      case Utility.FEAR_E:
        return fearRemarks;
      case Utility.ANTICIPATION_E:
        return anticipationRemarks;
      case Utility.SADNESS_E:
        return sadnessRemarks;
      case Utility.DISGUST_E:
        return disgustRemarks;
      case Utility.ANGER_E:
        return angerRemarks;
      case Utility.SURPRISE_E:
        return surpriseRemarks;
      case Utility.OPTIMISM_E:
        return optimismRemarks;
      case Utility.DISAPPOINTMENT_E:
        return disappointmentRemarks;
      case Utility.LOVE_E:
        return loveRemarks;
      case Utility.REMORSE_E:
        return remorseRemarks;
      case Utility.SUBMISSION_E:
        return submissionRemarks;
      case Utility.CONTEMPT_E:
        return contemptRemarks;
      case Utility.AGGRESSIVENESS_E:
        return aggressivenessRemarks;
      case Utility.AWE_E:
        return aweRemarks;
      case Utility.LIBIDO_E:
        return libidoRemarks;
      case Utility.SHAME_E:
        return shameRemarks;
      case Utility.SELF_RESPECT_E:
        return self_respectRemarks;
      case Utility.NOTHING_E:
      default:
        return nothingRemarks;
    }
  }

  private final MutableLiveData<TripleEmotions> tripleEmotions;

  LiveData<TripleEmotions> getTripleEmotions() {
    return tripleEmotions;
  }

  private String rawEmotion1 = "";
  private String rawEmotion2 = "";
  private String emStr1 = "";
  private String emStr2 = "";
  private String mixedEmotion1 = "";

  void setEmotions(String emotion) {

    // 感情名を取得
    String rawEmotion3 = rawEmotion2;
    rawEmotion2 = rawEmotion1;
    rawEmotion1 = emotion;

    String emStr3 = emStr2;
    emStr2 = emStr1;
    emStr1 = Utility.getEmotionString(emotion);

    // 複合感情の組み合わせの有無をチェックして取得
    String mixedEmotion2 = mixedEmotion1;
    mixedEmotion1 = Utility.getMixedEmotionString(emStr1, emStr2);

    // ここで MutableLiveData を更新
    TripleEmotions tm = new TripleEmotions(rawEmotion1, rawEmotion2, rawEmotion3,
        emStr1, emStr2, emStr3, mixedEmotion1, mixedEmotion2);
    tripleEmotions.setValue(tm);
  }
}
