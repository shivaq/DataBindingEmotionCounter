package banbutsu.kyoto.com.databindingemotioncounter.di.module;

import android.app.Activity;
import android.content.Context;
import banbutsu.kyoto.com.databindingemotioncounter.di.ActivityContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Yasuaki on 2018/01/11.
 */

@Module
public class ActivityModule {

  private Activity mActivity;

  public ActivityModule(Activity activity) {
    mActivity = activity;
  }

  @Provides
  @ActivityContext
  Context provideContext() {
    return mActivity;
  }

  @Provides
  Activity provideActivity() {
    return mActivity;
  }

}