package banbutsu.kyoto.com.databindingemotioncounter.ui.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import banbutsu.kyoto.com.databindingemotioncounter.data.Repository;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Yasuaki on 2018/01/19.
 */

public class RemarkViewModel extends ViewModel {

  private final LiveData<List<RemarkEntry>> joyList;
  private final LiveData<List<RemarkEntry>> trustList;
  private final LiveData<List<RemarkEntry>> fearList;
  private final LiveData<List<RemarkEntry>> anticipationList;
  private final LiveData<List<RemarkEntry>> sadnessList;
  private final LiveData<List<RemarkEntry>> disgustList;
  private final LiveData<List<RemarkEntry>> angerList;
  private final LiveData<List<RemarkEntry>> surpriseList;
  private final LiveData<List<RemarkEntry>> optimismList;
  private final LiveData<List<RemarkEntry>> disappointmentList;
  private final LiveData<List<RemarkEntry>> loveList;
  private final LiveData<List<RemarkEntry>> remorseList;
  private final LiveData<List<RemarkEntry>> submissionList;
  private final LiveData<List<RemarkEntry>> contemptList;
  private final LiveData<List<RemarkEntry>> aggressivenessList;
  private final LiveData<List<RemarkEntry>> aweList;
  private final LiveData<List<RemarkEntry>> libidoList;
  private final LiveData<List<RemarkEntry>> shameList;
  private final LiveData<List<RemarkEntry>> selfRespectList;

  // コンストラクタで LiveData を ViewModel に取り込む
  @Inject
  public RemarkViewModel(Repository repository) {
    joyList = repository.getRemarkByEmotion("joy");
    trustList = repository.getRemarkByEmotion("trust");
    fearList = repository.getRemarkByEmotion("fear");
    anticipationList = repository.getRemarkByEmotion("anticipation");
    sadnessList = repository.getRemarkByEmotion("sadness");
    disgustList = repository.getRemarkByEmotion("disgust");
    angerList = repository.getRemarkByEmotion("anger");
    surpriseList = repository.getRemarkByEmotion("surprise");
    optimismList = repository.getRemarkByEmotion("optimism");
    disappointmentList = repository.getRemarkByEmotion("disappointment");
    loveList = repository.getRemarkByEmotion("love");
    remorseList = repository.getRemarkByEmotion("remorse");
    submissionList = repository.getRemarkByEmotion("submission");
    contemptList = repository.getRemarkByEmotion("contempt");
    aggressivenessList = repository.getRemarkByEmotion("aggressiveness");
    aweList = repository.getRemarkByEmotion("awe");
    libidoList = repository.getRemarkByEmotion("libido");
    shameList = repository.getRemarkByEmotion("shame");
    selfRespectList = repository.getRemarkByEmotion("self_respect");
  }

  public LiveData<List<RemarkEntry>> getRemark(String emotion) {
    LiveData<List<RemarkEntry>> remarkList;
    switch (emotion) {
      case "joy":
        remarkList = joyList;
        break;
      case "trust":
        remarkList = trustList;
        break;
      case "fear":
        remarkList = fearList;
        break;
      case "anticipation":
        remarkList = anticipationList;
        break;
      case "sadness":
        remarkList = sadnessList;
        break;
      case "disgust":
        remarkList = disgustList;
        break;
      case "anger":
        remarkList = angerList;
        break;
      case "surprise":
        remarkList = surpriseList;
        break;
      case "optimism":
        remarkList = optimismList;
        break;
      case "disappointment":
        remarkList = disappointmentList;
        break;
      case "love":
        remarkList = loveList;
        break;
      case "remorse":
        remarkList = remorseList;
        break;
      case "submission":
        remarkList = submissionList;
        break;
      case "contempt":
        remarkList = contemptList;
        break;
      case "aggressiveness":
        remarkList = aggressivenessList;
        break;
      case "awe":
        remarkList = aweList;
        break;
      case "libido":
        remarkList = libidoList;
        break;
      case "shame":
        remarkList = shameList;
        break;
      case "self_respect":
      default:
        remarkList = selfRespectList;
        break;
    }
    return remarkList;
  }

}
