package banbutsu.kyoto.com.databindingemotioncounter.di.component;

import banbutsu.kyoto.com.databindingemotioncounter.ui.main.MainActivity;
import banbutsu.kyoto.com.databindingemotioncounter.di.PerActivity;
import banbutsu.kyoto.com.databindingemotioncounter.di.module.ActivityModule;
import dagger.Component;

/**
 * Created by Yasuaki on 2018/01/11.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  void inject(MainActivity activity);
}
