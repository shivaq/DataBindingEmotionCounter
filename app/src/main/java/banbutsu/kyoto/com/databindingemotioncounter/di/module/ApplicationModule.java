package banbutsu.kyoto.com.databindingemotioncounter.di.module;

import android.app.Application;
import android.content.Context;
import banbutsu.kyoto.com.databindingemotioncounter.di.ApplicationContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Yasuaki on 2018/01/11.
 */

@Module
public class ApplicationModule {

  private final Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides
  @ApplicationContext
  Context provideContext() {
    return mApplication;
  }

  @Provides
  Application provideApplication() {
    return mApplication;
  }


}