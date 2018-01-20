package banbutsu.kyoto.com.databindingemotioncounter.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import banbutsu.kyoto.com.databindingemotioncounter.R;
import banbutsu.kyoto.com.databindingemotioncounter.databinding.ActivityMainBinding;
import banbutsu.kyoto.com.databindingemotioncounter.ui.base.BaseActivity;
import banbutsu.kyoto.com.databindingemotioncounter.ui.list.RemarksActivity;
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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    binding.setMain(this);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
    viewModel.firstLaunchCheck();

    viewModel.getTripleEmotions().observe(this, emotions -> {
      if (emotions != null) {
        binding.imgEmotion1.setImageDrawable(emotions.getDrawable1());
        binding.tvEmotion1.setText(emotions.getEmotion1());
        binding.imgEmotion2.setImageDrawable(emotions.getDrawable2());
        binding.tvEmotion2.setText(emotions.getEmotion2());
        binding.imgEmotion3.setImageDrawable(emotions.getDrawable3());
        binding.tvEmotion3.setText(emotions.getEmotion3());
        String mixedEmotion1 =
            (emotions.getMixedEmotion1()).equals("") ? "" : "(" + emotions.getMixedEmotion1() + ")";
        String mixedEmotion2 =
            (emotions.getMixedEmotion2()).equals("") ? "" : "(" + emotions.getMixedEmotion2() + ")";

        binding.tvMixedEmotion1.setText(mixedEmotion1);
        binding.tvMixedEmotion2.setText(mixedEmotion2);
        binding.tvPlus1
            .setVisibility(emotions.getEmotion2().equals("") ? View.INVISIBLE : View.VISIBLE);
        binding.tvPlus2
            .setVisibility(emotions.getEmotion3().equals("") ? View.INVISIBLE : View.VISIBLE);
      }
    });
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

  public void putRemark(String emotion) {

  }

  public void speak(String emotion) {
    viewModel.setEmotions(emotion);
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
