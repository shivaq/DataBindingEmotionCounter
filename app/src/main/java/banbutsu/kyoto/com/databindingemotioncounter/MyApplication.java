package banbutsu.kyoto.com.databindingemotioncounter;

import android.app.Application;
import android.content.Context;
import banbutsu.kyoto.com.databindingemotioncounter.di.component.ApplicationComponent;
import banbutsu.kyoto.com.databindingemotioncounter.di.component.DaggerApplicationComponent;
import banbutsu.kyoto.com.databindingemotioncounter.di.module.ApplicationModule;
import com.facebook.stetho.Stetho;
import timber.log.Timber;

/**
 * Created by Yasuaki on 2018/01/11.
 */

public class MyApplication extends Application {

  private ApplicationComponent mApplicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    mApplicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();

    mApplicationComponent.inject(this);

    if (BuildConfig.DEBUG) {
      Timber.uprootAll();
      Timber.plant(new Timber.DebugTree());
    }

    // setup stetho
    Stetho.InitializerBuilder initializerBuilder =
        Stetho.newInitializerBuilder(this);

    initializerBuilder.enableWebKitInspector(
        Stetho.defaultInspectorModulesProvider(this));

    initializerBuilder.enableDumpapp(
        Stetho.defaultDumperPluginsProvider(this)
    );

    Stetho.Initializer initializer = initializerBuilder.build();
    Stetho.initialize(initializer);
  }

  public ApplicationComponent getApplicationComponent() {
    return mApplicationComponent;
  }

  // Needed to replace the component with a test specific one
  public void setComponent(ApplicationComponent applicationComponent) {
    mApplicationComponent = applicationComponent;
  }

  public static MyApplication get(Context context) {
    return (MyApplication) context.getApplicationContext();
  }

}
