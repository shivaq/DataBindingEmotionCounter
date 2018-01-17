package banbutsu.kyoto.com.databindingemotioncounter.di.component;

import android.app.Application;
import banbutsu.kyoto.com.databindingemotioncounter.MyApplication;
import banbutsu.kyoto.com.databindingemotioncounter.di.module.ActivityBuilderModule;
import banbutsu.kyoto.com.databindingemotioncounter.di.module.ApplicationModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import javax.inject.Singleton;

/**
 * Created by Yasuaki on 2018/01/11.
 *
 * ActivityBuilderModule: 各 AndroidComponent をまとめた Module
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class,
    ApplicationModule.class,
    ActivityBuilderModule.class})
public interface ApplicationComponent {

  // Component に Instance を紐付ける
  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder application(Application application);

    ApplicationComponent build();
  }

  void inject(MyApplication myApplication);
}