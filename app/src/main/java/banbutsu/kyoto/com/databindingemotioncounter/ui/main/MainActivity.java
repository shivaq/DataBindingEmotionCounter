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
import banbutsu.kyoto.com.databindingemotioncounter.databinding.ActivityMainBinding;
import banbutsu.kyoto.com.databindingemotioncounter.ui.base.BaseActivity;
import banbutsu.kyoto.com.databindingemotioncounter.ui.remarks.RemarksActivity;
import banbutsu.kyoto.com.databindingemotioncounter.utils.Utility;
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
    viewModel.getRemarksByEmotion(Utility.JOY_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.JOY_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.TRUST_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.TRUST_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.FEAR_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.FEAR_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.ANTICIPATION_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.ANTICIPATION_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.SADNESS_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.SADNESS_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.DISGUST_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.DISGUST_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.ANGER_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.ANGER_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.SURPRISE_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.SURPRISE_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.OPTIMISM_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.OPTIMISM_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.DISAPPOINTMENT_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.DISAPPOINTMENT_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.LOVE_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.LOVE_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.REMORSE_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.REMORSE_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.SUBMISSION_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.SUBMISSION_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.CONTEMPT_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.CONTEMPT_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.AGGRESSIVENESS_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.AGGRESSIVENESS_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.AWE_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.AWE_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.LIBIDO_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.LIBIDO_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.SHAME_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.SHAME_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.SELF_RESPECT_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.SELF_RESPECT_E, remarkList);
      }
    });
    viewModel.getRemarksByEmotion(Utility.NOTHING_E).observe(this, remarkList -> {
      if (remarkList != null) {
        viewModel.putLiveToRawArrayList(Utility.NOTHING_E, remarkList);
      }
    });
  }

  private void subscribeToEmotions() {
    viewModel.getTripleEmotions().observe(this, emotions -> {
      if (emotions != null) {

        // 感情文字セット
        binding.tvEmotion1.setText(emotions.getEmotion1());
        binding.tvEmotion2.setText(emotions.getEmotion2());
        binding.tvEmotion3.setText(emotions.getEmotion3());

        // 複合感情組み合わせの表示非表示分岐
        String mixedEmotion1 =
            (emotions.getMixedEmotion1()).equals("") ? "" : "(" + emotions.getMixedEmotion1() + ")";
        String mixedEmotion2 =
            (emotions.getMixedEmotion2()).equals("") ? "" : "(" + emotions.getMixedEmotion2() + ")";
        binding.tvMixedEmotion1.setText(mixedEmotion1);
        binding.tvMixedEmotion2.setText(mixedEmotion2);

        // 二度目、三度目のボタン押下有無 Boolean
        boolean isEmotionPressed2 = emotions.getRawEmotion2().equals("");
        boolean isEmotionPressed3 = emotions.getRawEmotion3().equals("");

        // 感情アイコン表示
        binding.imgEmotion1.setImageDrawable(
            getResources().getDrawable(Utility.getEmotionDrawable(emotions.getRawEmotion1())));
        if (!isEmotionPressed2) {
          binding.imgEmotion2.setImageDrawable(
              getResources().getDrawable(Utility.getEmotionDrawable(emotions.getRawEmotion2())));
        }
        if (!isEmotionPressed3) {
          binding.imgEmotion3.setImageDrawable(
              getResources().getDrawable(Utility.getEmotionDrawable(emotions.getRawEmotion3())));
        }
        // プラスマーク表示判定
        binding.tvPlus1
            .setVisibility(isEmotionPressed2 ? View.INVISIBLE : View.VISIBLE);
        binding.tvPlus2
            .setVisibility(isEmotionPressed3 ? View.INVISIBLE : View.VISIBLE);


        // 吹き出しの色を分岐
        int drawableInt1 = emotions.getMixedEmotion1().equals("") ?
            R.drawable.shape_balloon : R.drawable.shape_balloon_colored;
        int drawableInt2 = emotions.getMixedEmotion2().equals("") ?
            R.drawable.shape_balloon : R.drawable.shape_balloon_colored;
        int balloonColorInt = emotions.getMixedEmotion1().equals("") ?
            R.color.white : R.color.yellow04;
        binding.frameBalloon1.setBackground(getResources().getDrawable(drawableInt1));
        binding.balloonTriangle.setColorFilter(ContextCompat.getColor(context, balloonColorInt));
        binding.frameBalloon2.setBackground(getResources().getDrawable(drawableInt2));

        // セリフを表示
        String remark1 = emotions.getRemark1();
        String remark2 = emotions.getRemark2();
        String remark3 = emotions.getRemark3();
        binding.frameBalloon1.setVisibility(!remark1.equals("") ? View.VISIBLE : View.INVISIBLE);
        binding.frameBalloon2.setVisibility(!remark2.equals("") ? View.VISIBLE : View.INVISIBLE);
        binding.frameBalloon3.setVisibility(!remark3.equals("") ? View.VISIBLE : View.INVISIBLE);
        binding.balloonTriangle.setVisibility(!remark1.equals("") ? View.VISIBLE : View.INVISIBLE);
                binding.tvBalloon1.setText(remark1);
        binding.tvBalloon2.setText(remark2);
        binding.tvBalloon3.setText(remark3);
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
