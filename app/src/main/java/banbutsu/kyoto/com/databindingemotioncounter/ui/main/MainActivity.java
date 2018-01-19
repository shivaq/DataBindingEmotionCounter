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
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);

    viewModel.firstLaunchCheck();

//
//    viewModel.getCharacter().observe(this, characterEntry -> {
//      if (characterEntry != null) {
//        binding.tvBalloon1.setText(characterEntry.name);
//      }
//    });
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
}
