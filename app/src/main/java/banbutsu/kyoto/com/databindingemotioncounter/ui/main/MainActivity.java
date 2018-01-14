package banbutsu.kyoto.com.databindingemotioncounter.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import banbutsu.kyoto.com.databindingemotioncounter.R;
import banbutsu.kyoto.com.databindingemotioncounter.databinding.ActivityMainBinding;
import banbutsu.kyoto.com.databindingemotioncounter.di.ApplicationContext;
import banbutsu.kyoto.com.databindingemotioncounter.ui.base.BaseActivity;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  /******************************** Inject ****************************************/
  // Inject Presenter from an object graph
  @Inject
  @ApplicationContext
  Context context;


  /**************************** Life cycle ********************************************/
  public MainActivity() {
  }

  private ActivityMainBinding binding;
  MainActivityViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getActivityComponent().inject(this);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

    viewModel.getCharacter().observe(this, characterEntry -> {
      if (characterEntry != null) {
        binding.tvBalloon1.setText(characterEntry.name);
      }
    });
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }
}
