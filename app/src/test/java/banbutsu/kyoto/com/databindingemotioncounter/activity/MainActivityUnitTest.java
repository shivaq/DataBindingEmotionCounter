package banbutsu.kyoto.com.databindingemotioncounter.activity;

import android.app.Activity;
import android.os.Build;
import banbutsu.kyoto.com.databindingemotioncounter.BuildConfig;
import banbutsu.kyoto.com.databindingemotioncounter.ui.main.MainActivity;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by Yasuaki on 2018/01/22.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP_MR1)
@RunWith(RobolectricTestRunner.class)
public class MainActivityUnitTest {

  private Activity activity;

  @Before
  public void setUp() throws Exception{
    if(activity == null){
      activity = Robolectric.setupActivity(MainActivity.class);
    }
  }

  @After
  public void tearDown() throws Exception {

  }

}
