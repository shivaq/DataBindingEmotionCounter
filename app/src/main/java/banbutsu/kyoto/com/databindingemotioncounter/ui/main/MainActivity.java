package banbutsu.kyoto.com.databindingemotioncounter.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import banbutsu.kyoto.com.databindingemotioncounter.R;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;
import banbutsu.kyoto.com.databindingemotioncounter.databinding.ActivityMainBinding;
import banbutsu.kyoto.com.databindingemotioncounter.ui.base.BaseActivity;
import banbutsu.kyoto.com.databindingemotioncounter.ui.remarks.RemarksActivity;
import banbutsu.kyoto.com.databindingemotioncounter.utils.Utility;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  /******************************** Inject ****************************************/
  @Inject
  Context context;


  /**************************** Life cycle ********************************************/
  public MainActivity() {
  }

  @Inject
  ViewModelProvider.Factory viewModelFactory;
  private MainViewModel viewModel;
  private ActivityMainBinding binding;

  private Random random = new Random();
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

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int itemId = item.getItemId();
    switch (itemId) {
      case R.id.add_remarks:
        Intent intent = new Intent(this, RemarksActivity.class);
        startActivity(intent);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  ///////////////////////////  ViewModel とのやり取り   /////////////////////////////////
  public void speak(String emotion) {
    viewModel.setEmotions(emotion);
  }

  private void subscribeToRemarkLists() {
    viewModel.getRemarksByEmotion(getString(R.string.joy)).observe(this, remarkList -> {
      if (remarkList != null) {
        joyRemarks.clear();
        joyRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.TRUST_E).observe(this, remarkList -> {
      if (remarkList != null) {
        trustRemarks.clear();
        trustRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.FEAR_E).observe(this, remarkList -> {
      if (remarkList != null) {
        fearRemarks.clear();
        fearRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.ANTICIPATION_E).observe(this, remarkList -> {
      if (remarkList != null) {
        anticipationRemarks.clear();
        anticipationRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.SADNESS_E).observe(this, remarkList -> {
      if (remarkList != null) {
        sadnessRemarks.clear();
        sadnessRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.DISGUST_E).observe(this, remarkList -> {
      if (remarkList != null) {
        disgustRemarks.clear();
        disgustRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.ANGER_E).observe(this, remarkList -> {
      if (remarkList != null) {
        angerRemarks.clear();
        angerRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.SURPRISE_E).observe(this, remarkList -> {
      if (remarkList != null) {
        surpriseRemarks.clear();
        surpriseRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.OPTIMISM_E).observe(this, remarkList -> {
      if (remarkList != null) {
        optimismRemarks.clear();
        optimismRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.DISAPPOINTMENT_E).observe(this, remarkList -> {
      if (remarkList != null) {
        disappointmentRemarks.clear();
        disappointmentRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.LOVE_E).observe(this, remarkList -> {
      if (remarkList != null) {
        loveRemarks.clear();
        loveRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.REMORSE_E).observe(this, remarkList -> {
      if (remarkList != null) {
        remorseRemarks.clear();
        remorseRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.SUBMISSION_E).observe(this, remarkList -> {
      if (remarkList != null) {
        submissionRemarks.clear();
        submissionRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.CONTEMPT_E).observe(this, remarkList -> {
      if (remarkList != null) {
        contemptRemarks.clear();
        contemptRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.AGGRESSIVENESS_E).observe(this, remarkList -> {
      if (remarkList != null) {
        aggressivenessRemarks.clear();
        aggressivenessRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.AWE_E).observe(this, remarkList -> {
      if (remarkList != null) {
        aweRemarks.clear();
        aweRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.LIBIDO_E).observe(this, remarkList -> {
      if (remarkList != null) {
        libidoRemarks.clear();
        libidoRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.SHAME_E).observe(this, remarkList -> {
      if (remarkList != null) {
        shameRemarks.clear();
        shameRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.SELF_RESPECT_E).observe(this, remarkList -> {
      if (remarkList != null) {
        self_respectRemarks.clear();
        self_respectRemarks.addAll(remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.NOTHING_E).observe(this, remarkList -> {
      if (remarkList != null) {
        nothingRemarks.clear();
        nothingRemarks.addAll(remarkList);
      }
    });
  }

  private String getRemarkRandomly(String emotion) {
    int random;
    String remark;
    switch (emotion) {
      case Utility.JOY_E:
        random = this.random.nextInt(joyRemarks.size());
        remark = joyRemarks.get(random).say;
        break;
      case Utility.TRUST_E:
        random = this.random.nextInt(trustRemarks.size());
        remark = trustRemarks.get(random).say;
        break;
      case Utility.FEAR_E:
        random = this.random.nextInt(fearRemarks.size());
        remark = fearRemarks.get(random).say;
        break;
      case Utility.ANTICIPATION_E:
        random = this.random.nextInt(anticipationRemarks.size());
        remark = anticipationRemarks.get(random).say;
        break;
      case Utility.SADNESS_E:
        random = this.random.nextInt(sadnessRemarks.size());
        remark = sadnessRemarks.get(random).say;
        break;
      case Utility.DISGUST_E:
        random = this.random.nextInt(disgustRemarks.size());
        remark = disgustRemarks.get(random).say;
        break;
      case Utility.ANGER_E:
        random = this.random.nextInt(angerRemarks.size());
        remark = angerRemarks.get(random).say;
        break;
      case Utility.SURPRISE_E:
        random = this.random.nextInt(surpriseRemarks.size());
        remark = surpriseRemarks.get(random).say;
        break;
      case Utility.OPTIMISM_E:
        random = this.random.nextInt(optimismRemarks.size());
        remark = optimismRemarks.get(random).say;
        break;
      case Utility.DISAPPOINTMENT_E:
        random = this.random.nextInt(disappointmentRemarks.size());
        remark = disappointmentRemarks.get(random).say;
        break;
      case Utility.LOVE_E:
        random = this.random.nextInt(loveRemarks.size());
        remark = loveRemarks.get(random).say;
        break;
      case Utility.REMORSE_E:
        random = this.random.nextInt(remorseRemarks.size());
        remark = remorseRemarks.get(random).say;
        break;
      case Utility.SUBMISSION_E:
        random = this.random.nextInt(submissionRemarks.size());
        remark = submissionRemarks.get(random).say;
        break;
      case Utility.CONTEMPT_E:
        random = this.random.nextInt(contemptRemarks.size());
        remark = contemptRemarks.get(random).say;
        break;
      case Utility.AGGRESSIVENESS_E:
        random = this.random.nextInt(aggressivenessRemarks.size());
        remark = aggressivenessRemarks.get(random).say;
        break;
      case Utility.AWE_E:
        random = this.random.nextInt(aweRemarks.size());
        remark = aweRemarks.get(random).say;
        break;
      case Utility.LIBIDO_E:
        random = this.random.nextInt(libidoRemarks.size());
        remark = libidoRemarks.get(random).say;
        break;
      case Utility.SHAME_E:
        random = this.random.nextInt(shameRemarks.size());
        remark = shameRemarks.get(random).say;
        break;
      case Utility.SELF_RESPECT_E:
        random = this.random.nextInt(self_respectRemarks.size());
        remark = self_respectRemarks.get(random).say;
        break;
      case Utility.NOTHING_E:
        random = this.random.nextInt(nothingRemarks.size());
        remark = nothingRemarks.get(random).say;
        break;
      default:
        remark = "";
        break;
    }
    return remark;
  }

  private void subscribeToEmotions() {
    viewModel.getTripleEmotions().observe(this, emotions -> {
      if (emotions != null) {

        // 感情文字セット
        binding.tvEmotion1.setText(emotions.getEmotion1());
        binding.tvEmotion2.setText(emotions.getEmotion2());
        binding.tvEmotion3.setText(emotions.getEmotion3());

        // 複合感情組み合わせ判定
        String mixedEmotion1 =
            (emotions.getMixedEmotion1()).equals("") ? "" : "(" + emotions.getMixedEmotion1() + ")";
        String mixedEmotion2 =
            (emotions.getMixedEmotion2()).equals("") ? "" : "(" + emotions.getMixedEmotion2() + ")";
        binding.tvMixedEmotion1.setText(mixedEmotion1);
        binding.tvMixedEmotion2.setText(mixedEmotion2);

        // 感情アイコン表示
        binding.imgEmotion1.setImageDrawable(
            getResources().getDrawable(Utility.getEmotionDrawable(emotions.getRawEmotion1())));
        if (!emotions.getRawEmotion2().equals("")) {
          binding.imgEmotion2.setImageDrawable(
              getResources().getDrawable(Utility.getEmotionDrawable(emotions.getRawEmotion2())));
        }
        if (!emotions.getRawEmotion3().equals("")) {
          binding.imgEmotion3.setImageDrawable(
              getResources().getDrawable(Utility.getEmotionDrawable(emotions.getRawEmotion3())));
        }

        // セリフをランダムに表示
        String remark1;
        String remark2;
        String remark3;
        if (!emotions.getMixedEmotion1().equals("")) {
          remark1 = getRemarkRandomly(Utility.getMixedEmotionRawStr(emotions.getMixedEmotion1()));
          remark2 = getRemarkRandomly(emotions.getRawEmotion1());
          remark3 = getRemarkRandomly(emotions.getRawEmotion2());
          binding.frameBalloon1
              .setBackground(getResources().getDrawable(R.drawable.shape_balloon_colored));
          binding.balloonTriangle.setColorFilter(ContextCompat.getColor(context, R.color.yellow04));
          binding.frameBalloon2.setBackground(getResources().getDrawable(R.drawable.shape_balloon));
        } else if (!emotions.getMixedEmotion2().equals("")) {
          remark1 = getRemarkRandomly(emotions.getRawEmotion1());
          remark2 = getRemarkRandomly(Utility.getMixedEmotionRawStr(emotions.getMixedEmotion2()));
          remark3 = getRemarkRandomly(emotions.getRawEmotion2());
          binding.frameBalloon1.setBackground(getResources().getDrawable(R.drawable.shape_balloon));
          binding.balloonTriangle.setColorFilter(ContextCompat.getColor(context, R.color.white));
          binding.frameBalloon2.setBackground(getResources().getDrawable(R.drawable.shape_balloon_colored));
        } else {
          remark1 = getRemarkRandomly(emotions.getRawEmotion1());
          remark2 = getRemarkRandomly(emotions.getRawEmotion2());
          remark3 = getRemarkRandomly(emotions.getRawEmotion3());
          binding.frameBalloon1.setBackground(getResources().getDrawable(R.drawable.shape_balloon));
          binding.balloonTriangle.setColorFilter(ContextCompat.getColor(context, R.color.white));
          binding.frameBalloon2.setBackground(getResources().getDrawable(R.drawable.shape_balloon));
        }
        binding.frameBalloon1.setVisibility(!remark1.equals("") ? View.VISIBLE : View.INVISIBLE);
        binding.frameBalloon2.setVisibility(!remark2.equals("") ? View.VISIBLE : View.INVISIBLE);
        binding.frameBalloon3.setVisibility(!remark3.equals("") ? View.VISIBLE : View.INVISIBLE);
        binding.balloonTriangle.setVisibility(!remark1.equals("") ? View.VISIBLE : View.INVISIBLE);
        binding.tvBalloon1.setText(remark1);
        binding.tvBalloon2.setText(remark2);
        binding.tvBalloon3.setText(remark3);

        // プラスマーク表示判定
        binding.tvPlus1
            .setVisibility(emotions.getEmotion2().equals("") ? View.INVISIBLE : View.VISIBLE);
        binding.tvPlus2
            .setVisibility(emotions.getEmotion3().equals("") ? View.INVISIBLE : View.VISIBLE);
      }
    });
  }

  /************************* others ********************************************/
  private Toast toast;

  public void showToast(String message) {
    if (toast != null) {
      toast.cancel();
    }
    toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
    toast.show();
  }
}
