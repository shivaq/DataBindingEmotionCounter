package banbutsu.kyoto.com.databindingemotioncounter.ui.main;

import android.content.Context;
import android.os.Bundle;
import banbutsu.kyoto.com.databindingemotioncounter.R;
import banbutsu.kyoto.com.databindingemotioncounter.di.ApplicationContext;
import banbutsu.kyoto.com.databindingemotioncounter.ui.base.BaseActivity;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView{

  /******************************** Inject ****************************************/
  // Inject Presenter from an object graph
  @Inject
  MainPresenter mainPresenter;
  @Inject
  @ApplicationContext
  Context context;

  /**************************** Life cycle ********************************************/
  public MainActivity() {
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getActivityComponent().inject(this);
    mainPresenter.onAttachMvpView(this);
      }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mainPresenter.onDetachMvpView();
  }
}
