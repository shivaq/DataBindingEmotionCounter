package banbutsu.kyoto.com.databindingemotioncounter.ui.main;

import android.content.Context;
import android.os.Bundle;
import banbutsu.kyoto.com.databindingemotioncounter.R;
import banbutsu.kyoto.com.databindingemotioncounter.ui.base.BaseActivity;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  /******************************** Inject ****************************************/
  // Inject Presenter from an object graph
  @Inject
  Context context;


  /**************************** Life cycle ********************************************/
  public MainActivity() {
  }

//    private ActivityMainBinding binding;
//  MainActivityViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
//    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//    viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
//
//    viewModel.getCharacter().observe(this, characterEntry -> {
//      if (characterEntry != null) {
//        binding.tvBalloon1.setText(characterEntry.name);
//      }
//    });
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }
}
