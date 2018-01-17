package banbutsu.kyoto.com.databindingemotioncounter.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import banbutsu.kyoto.com.databindingemotioncounter.di.qualifier.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Yasuaki on 2018/01/14.
 */
@Singleton
public class PreferencesHelper {
  private static final String PREF_FILE_NAME = "zibada.kyoto.com.ruten.PREF_FILE_NAME";
  private final SharedPreferences sharedPreferences;

  @Inject
  PreferencesHelper(@ApplicationContext Context context) {
    sharedPreferences =
        context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
  }
}
