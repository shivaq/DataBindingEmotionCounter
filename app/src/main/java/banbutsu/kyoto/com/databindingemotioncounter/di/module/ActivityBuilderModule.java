package banbutsu.kyoto.com.databindingemotioncounter.di.module;

import banbutsu.kyoto.com.databindingemotioncounter.ui.list.RemarksActivity;
import banbutsu.kyoto.com.databindingemotioncounter.ui.main.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Yasuaki on 2018/01/16.
 */
@Module
public abstract class ActivityBuilderModule {

  @ContributesAndroidInjector
  public abstract MainActivity contributeMainActivity();

  @ContributesAndroidInjector
  public abstract RemarksActivity contributeListActivity();
}
