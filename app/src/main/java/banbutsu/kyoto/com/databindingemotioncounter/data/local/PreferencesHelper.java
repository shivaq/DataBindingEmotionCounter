package banbutsu.kyoto.com.databindingemotioncounter.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import banbutsu.kyoto.com.databindingemotioncounter.di.qualifier.PreferenceInfo;
import banbutsu.kyoto.com.databindingemotioncounter.utils.Utility;
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

  private static final String IS_FIRST_RUN = "IS_FIRST_RUN";

  public boolean isFirstLaunch() {
    boolean isFirstLaunch = sharedPreferences.getBoolean(IS_FIRST_RUN, true);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putBoolean(IS_FIRST_RUN, false);
    editor.apply();
    return isFirstLaunch;
  }

  private static final String TOMORROW_IN_MILLS = "TOMORROW_IN_MILLS";

  public long retrieveTomorrow() {
    return sharedPreferences.getLong(TOMORROW_IN_MILLS, 0L);
  }

  public void putTomorrow() {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putLong(TOMORROW_IN_MILLS, Utility.getTomorrowMidnight());
    editor.apply();
  }

  private static final String CURRENT_CHARACTER = "CURRENT_CHARACTER";

  public int retrieveCurrentCharacter() {
    return sharedPreferences.getInt(CURRENT_CHARACTER, 1);
  }

  public void putCurrentCharacter(int characterId) {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt(CURRENT_CHARACTER, characterId);
    editor.apply();
  }

  private static final String CURRENT_EMISSION_ID = "CURRENT_EMISSION_ID";

  public int retrieveMonologueId() {
    return sharedPreferences.getInt(CURRENT_EMISSION_ID, 1);
  }
}
