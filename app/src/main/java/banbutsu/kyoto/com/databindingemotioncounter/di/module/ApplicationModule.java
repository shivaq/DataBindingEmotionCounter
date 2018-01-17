package banbutsu.kyoto.com.databindingemotioncounter.di.module;

import android.app.Application;
import android.content.Context;
import banbutsu.kyoto.com.databindingemotioncounter.di.qualifier.ApplicationContext;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Yasuaki on 2018/01/11.
 */

@Module
public class ApplicationModule {

  @Provides
  @Singleton
  @ApplicationContext
  Context provideContext(Application application) {
    return application;
  }

}