package banbutsu.kyoto.com.databindingemotioncounter.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import banbutsu.kyoto.com.databindingemotioncounter.data.Repository;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.TripleEmotions;
import banbutsu.kyoto.com.databindingemotioncounter.utils.Utility;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

  private final LiveData<List<RemarkEntry>> joyRemarksLive;
  private final LiveData<List<RemarkEntry>> trustRemarksLive;
  private final LiveData<List<RemarkEntry>> fearRemarksLive;
  private final LiveData<List<RemarkEntry>> anticipationRemarksLive;
  private final LiveData<List<RemarkEntry>> sadnessRemarksLive;
  private final LiveData<List<RemarkEntry>> disgustRemarksLive;
  private final LiveData<List<RemarkEntry>> angerRemarksLive;
  private final LiveData<List<RemarkEntry>> surpriseRemarksLive;
  private final LiveData<List<RemarkEntry>> optimismRemarksLive;
  private final LiveData<List<RemarkEntry>> disappointmentRemarksLive;
  private final LiveData<List<RemarkEntry>> loveRemarksLive;
  private final LiveData<List<RemarkEntry>> remorseRemarksLive;
  private final LiveData<List<RemarkEntry>> submissionRemarksLive;
  private final LiveData<List<RemarkEntry>> contemptRemarksLive;
  private final LiveData<List<RemarkEntry>> aggressivenessRemarksLive;
  private final LiveData<List<RemarkEntry>> aweRemarksLive;
  private final LiveData<List<RemarkEntry>> libidoRemarksLive;
  private final LiveData<List<RemarkEntry>> shameRemarksLive;
  private final LiveData<List<RemarkEntry>> self_respectRemarksLive;
  private final LiveData<List<RemarkEntry>> nothingRemarksLive;

  private List<RemarkEntry> joyRemarks = new ArrayList<>();
  private List<RemarkEntry> trustRemarks = new ArrayList<>();
  private List<RemarkEntry> fearRemarks = new ArrayList<>();
  private List<RemarkEntry> anticipationRemarks = new ArrayList<>();
  private List<RemarkEntry> sadnessRemarks = new ArrayList<>();
  private List<RemarkEntry> disgustRemarks = new ArrayList<>();
  private List<RemarkEntry> angerRemarks = new ArrayList<>();
  private List<RemarkEntry> surpriseRemarks = new ArrayList<>();
  private List<RemarkEntry> optimismRemarks = new ArrayList<>();
  private List<RemarkEntry> disappointmentRemarks = new ArrayList<>();
  private List<RemarkEntry> loveRemarks = new ArrayList<>();
  private List<RemarkEntry> remorseRemarks = new ArrayList<>();
  private List<RemarkEntry> submissionRemarks = new ArrayList<>();
  private List<RemarkEntry> contemptRemarks = new ArrayList<>();
  private List<RemarkEntry> aggressivenessRemarks = new ArrayList<>();
  private List<RemarkEntry> aweRemarks = new ArrayList<>();
  private List<RemarkEntry> libidoRemarks = new ArrayList<>();
  private List<RemarkEntry> shameRemarks = new ArrayList<>();
  private List<RemarkEntry> self_respectRemarks = new ArrayList<>();
  private List<RemarkEntry> nothingRemarks = new ArrayList<>();

  @Inject
  public MainViewModel(Repository repository) {
    tripleEmotions = new MutableLiveData<>();
    joyRemarksLive = repository.getRemarkByEmotion(Utility.JOY_E);
    trustRemarksLive = repository.getRemarkByEmotion(Utility.TRUST_E);
    fearRemarksLive = repository.getRemarkByEmotion(Utility.FEAR_E);
    anticipationRemarksLive = repository.getRemarkByEmotion(Utility.ANTICIPATION_E);
    sadnessRemarksLive = repository.getRemarkByEmotion(Utility.SADNESS_E);
    disgustRemarksLive = repository.getRemarkByEmotion(Utility.DISGUST_E);
    angerRemarksLive = repository.getRemarkByEmotion(Utility.ANGER_E);
    surpriseRemarksLive = repository.getRemarkByEmotion(Utility.SURPRISE_E);
    optimismRemarksLive = repository.getRemarkByEmotion(Utility.OPTIMISM_E);
    disappointmentRemarksLive = repository.getRemarkByEmotion(Utility.DISAPPOINTMENT_E);
    loveRemarksLive = repository.getRemarkByEmotion(Utility.LOVE_E);
    remorseRemarksLive = repository.getRemarkByEmotion(Utility.REMORSE_E);
    submissionRemarksLive = repository.getRemarkByEmotion(Utility.SUBMISSION_E);
    contemptRemarksLive = repository.getRemarkByEmotion(Utility.CONTEMPT_E);
    aggressivenessRemarksLive = repository.getRemarkByEmotion(Utility.AGGRESSIVENESS_E);
    aweRemarksLive = repository.getRemarkByEmotion(Utility.AWE_E);
    libidoRemarksLive = repository.getRemarkByEmotion(Utility.LIBIDO_E);
    shameRemarksLive = repository.getRemarkByEmotion(Utility.SHAME_E);
    self_respectRemarksLive = repository.getRemarkByEmotion(Utility.SELF_RESPECT_E);
    nothingRemarksLive = repository.getRemarkByEmotion(Utility.NOTHING_E);

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
        return joyRemarksLive;
      case Utility.TRUST_E:
        return trustRemarksLive;
      case Utility.FEAR_E:
        return fearRemarksLive;
      case Utility.ANTICIPATION_E:
        return anticipationRemarksLive;
      case Utility.SADNESS_E:
        return sadnessRemarksLive;
      case Utility.DISGUST_E:
        return disgustRemarksLive;
      case Utility.ANGER_E:
        return angerRemarksLive;
      case Utility.SURPRISE_E:
        return surpriseRemarksLive;
      case Utility.OPTIMISM_E:
        return optimismRemarksLive;
      case Utility.DISAPPOINTMENT_E:
        return disappointmentRemarksLive;
      case Utility.LOVE_E:
        return loveRemarksLive;
      case Utility.REMORSE_E:
        return remorseRemarksLive;
      case Utility.SUBMISSION_E:
        return submissionRemarksLive;
      case Utility.CONTEMPT_E:
        return contemptRemarksLive;
      case Utility.AGGRESSIVENESS_E:
        return aggressivenessRemarksLive;
      case Utility.AWE_E:
        return aweRemarksLive;
      case Utility.LIBIDO_E:
        return libidoRemarksLive;
      case Utility.SHAME_E:
        return shameRemarksLive;
      case Utility.SELF_RESPECT_E:
        return self_respectRemarksLive;
      case Utility.NOTHING_E:
      default:
        return nothingRemarksLive;
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
  private String remark1 = "";
  private String remark2 = "";

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

    String remark3 = remark2;
    remark2 = remark1;
    remark1 = getRandomSay(mixedEmotion1.equals("")?rawEmotion1:Utility.getMixedEmotionRawStr(mixedEmotion1));

    // ここで MutableLiveData を更新
    TripleEmotions tm = new TripleEmotions(rawEmotion1, rawEmotion2, rawEmotion3,
        emStr1, emStr2, emStr3, mixedEmotion1, mixedEmotion2, remark1, remark2, remark3);
    tripleEmotions.setValue(tm);
  }

  void putLiveToRawArrayList(String emotion, List<RemarkEntry> remarkList) {
    switch (emotion) {
      case Utility.JOY_E:
        joyRemarks.clear();
        joyRemarks.addAll(remarkList);
        break;
      case Utility.TRUST_E:
        trustRemarks.clear();
        trustRemarks.addAll(remarkList);
        break;
      case Utility.FEAR_E:
        fearRemarks.clear();
        fearRemarks.addAll(remarkList);
        break;
      case Utility.ANTICIPATION_E:
        anticipationRemarks.clear();
        anticipationRemarks.addAll(remarkList);
        break;
      case Utility.SADNESS_E:
        sadnessRemarks.clear();
        sadnessRemarks.addAll(remarkList);
        break;
      case Utility.DISGUST_E:
        disgustRemarks.clear();
        disgustRemarks.addAll(remarkList);
        break;
      case Utility.ANGER_E:
        angerRemarks.clear();
        angerRemarks.addAll(remarkList);
        break;
      case Utility.SURPRISE_E:
        surpriseRemarks.clear();
        surpriseRemarks.addAll(remarkList);
        break;
      case Utility.OPTIMISM_E:
        optimismRemarks.clear();
        optimismRemarks.addAll(remarkList);
        break;
      case Utility.DISAPPOINTMENT_E:
        disappointmentRemarks.clear();
        disappointmentRemarks.addAll(remarkList);
        break;
      case Utility.LOVE_E:
        loveRemarks.clear();
        loveRemarks.addAll(remarkList);
        break;
      case Utility.REMORSE_E:
        remorseRemarks.clear();
        remorseRemarks.addAll(remarkList);
        break;
      case Utility.SUBMISSION_E:
        submissionRemarks.clear();
        submissionRemarks.addAll(remarkList);
        break;
      case Utility.CONTEMPT_E:
        contemptRemarks.clear();
        contemptRemarks.addAll(remarkList);
        break;
      case Utility.AGGRESSIVENESS_E:
        aggressivenessRemarks.clear();
        aggressivenessRemarks.addAll(remarkList);
        break;
      case Utility.AWE_E:
        aweRemarks.clear();
        aweRemarks.addAll(remarkList);
        break;
      case Utility.LIBIDO_E:
        libidoRemarks.clear();
        libidoRemarks.addAll(remarkList);
        break;
      case Utility.SHAME_E:
        shameRemarks.clear();
        shameRemarks.addAll(remarkList);
        break;
      case Utility.SELF_RESPECT_E:
        self_respectRemarks.clear();
        self_respectRemarks.addAll(remarkList);
        break;
      case Utility.NOTHING_E:
        nothingRemarks.clear();
        nothingRemarks.addAll(remarkList);
        break;
    }
  }

  private Random random = new Random();

  String getRandomSay(String emotion) {

    String remark = "";
    switch (emotion) {
      case Utility.JOY_E:
        remark = joyRemarks.get(random.nextInt(joyRemarks.size())).say;
        break;
      case Utility.TRUST_E:
        remark = trustRemarks.get(random.nextInt(trustRemarks.size())).say;
        break;
      case Utility.FEAR_E:
        remark = fearRemarks.get(random.nextInt(fearRemarks.size())).say;
        break;
      case Utility.ANTICIPATION_E:
        remark = anticipationRemarks.get(random.nextInt(anticipationRemarks.size())).say;
        break;
      case Utility.SADNESS_E:
        remark = sadnessRemarks.get(random.nextInt(sadnessRemarks.size())).say;
        break;
      case Utility.DISGUST_E:
        remark = disgustRemarks.get(random.nextInt(disgustRemarks.size())).say;
        break;
      case Utility.ANGER_E:
        remark = angerRemarks.get(random.nextInt(angerRemarks.size())).say;
        break;
      case Utility.SURPRISE_E:
        remark = surpriseRemarks.get(random.nextInt(surpriseRemarks.size())).say;
        break;
      case Utility.OPTIMISM_E:
        remark = optimismRemarks.get(random.nextInt(optimismRemarks.size())).say;
        break;
      case Utility.DISAPPOINTMENT_E:
        remark = disappointmentRemarks.get(random.nextInt(disappointmentRemarks.size())).say;
        break;
      case Utility.LOVE_E:
        remark = loveRemarks.get(random.nextInt(loveRemarks.size())).say;
        break;
      case Utility.REMORSE_E:
        remark = remorseRemarks.get(random.nextInt(remorseRemarks.size())).say;
        break;
      case Utility.SUBMISSION_E:
        remark = submissionRemarks.get(random.nextInt(submissionRemarks.size())).say;
        break;
      case Utility.CONTEMPT_E:
        remark = contemptRemarks.get(random.nextInt(contemptRemarks.size())).say;
        break;
      case Utility.AGGRESSIVENESS_E:
        remark = aggressivenessRemarks.get(random.nextInt(aggressivenessRemarks.size())).say;
        break;
      case Utility.AWE_E:
        remark = aweRemarks.get(random.nextInt(aweRemarks.size())).say;
        break;
      case Utility.LIBIDO_E:
        remark = libidoRemarks.get(random.nextInt(libidoRemarks.size())).say;
        break;
      case Utility.SHAME_E:
        remark = shameRemarks.get(random.nextInt(shameRemarks.size())).say;
        break;
      case Utility.SELF_RESPECT_E:
        remark = self_respectRemarks.get(random.nextInt(self_respectRemarks.size())).say;
        break;
      case Utility.NOTHING_E:
        remark = nothingRemarks.get(random.nextInt(nothingRemarks.size())).say;
        break;
    }
    return remark;
  }
}
