package banbutsu.kyoto.com.databindingemotioncounter.ui.main;

import android.content.Context;
import banbutsu.kyoto.com.databindingemotioncounter.di.ApplicationContext;
import banbutsu.kyoto.com.databindingemotioncounter.di.PerActivity;
import banbutsu.kyoto.com.databindingemotioncounter.ui.base.BasePresenter;
import io.reactivex.disposables.CompositeDisposable;
import javax.inject.Inject;

/**
 * Created by Yasuaki on 2018/01/11.
 */

@PerActivity//Use this scope annotation to make presenter configure persistent
public class MainPresenter implements BasePresenter<MainMvpView> {

  private MainMvpView mainMvpView;
  private final CompositeDisposable compositeDisposable;

  /******************************** Inject ****************************************/
  @Inject
  @ApplicationContext
  Context context;

  @Inject
  MainPresenter() {
    compositeDisposable = new CompositeDisposable();
  }

  @Override
  public void onAttachMvpView(MainMvpView mvpView) {
    mainMvpView = mvpView;
  }

  @Override
  public void onDetachMvpView() {
    mainMvpView = null;
    compositeDisposable.dispose();
  }
}
