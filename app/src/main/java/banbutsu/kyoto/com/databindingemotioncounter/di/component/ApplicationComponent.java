package banbutsu.kyoto.com.databindingemotioncounter.di.component;

import android.app.Application;
import android.content.Context;
import banbutsu.kyoto.com.databindingemotioncounter.MyApplication;
import banbutsu.kyoto.com.databindingemotioncounter.data.Repository;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.PreferencesHelper;
import banbutsu.kyoto.com.databindingemotioncounter.di.ApplicationContext;
import banbutsu.kyoto.com.databindingemotioncounter.di.module.ApplicationModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Yasuaki on 2018/01/11.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

  // A kind of a list of contractor
  void inject(MyApplication myApplication);

  // ActivityComponent が ApplicationComponent の提供するインスタンスを
  // dependencies にて使えるようにするために、使用対象OBJを下記のように宣言する
  @ApplicationContext
  Context context();

  Application application();
  Repository repository();
  PreferencesHelper preferencesHelper();
}