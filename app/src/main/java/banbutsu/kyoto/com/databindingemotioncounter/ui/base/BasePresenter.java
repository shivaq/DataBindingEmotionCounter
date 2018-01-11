package banbutsu.kyoto.com.databindingemotioncounter.ui.base;

import banbutsu.kyoto.com.databindingemotioncounter.di.PerActivity;

/**
 * Created by Yasuaki on 2018/01/11.
 */

@PerActivity
public interface BasePresenter<V extends BaseMvpView> {

  void onAttachMvpView(V mvpView);

  void onDetachMvpView();

}
