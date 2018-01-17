package banbutsu.kyoto.com.databindingemotioncounter.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import banbutsu.kyoto.com.databindingemotioncounter.di.qualifier.PreferenceInfo;
import javax.inject.Inject;

/**
 * Created by Yasuaki on 2018/01/14.
 */
public class PreferencesHelper {

  private final SharedPreferences sharedPreferences;

  @Inject
  PreferencesHelper(Context context, @PreferenceInfo String preferenceFileName) {
    sharedPreferences =
        context.getSharedPreferences(preferenceFileName, Context.MODE_PRIVATE);
  }
}
