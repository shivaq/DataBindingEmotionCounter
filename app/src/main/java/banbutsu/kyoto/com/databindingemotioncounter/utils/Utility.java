package banbutsu.kyoto.com.databindingemotioncounter.utils;

import java.util.Calendar;

/**
 * Created by Yasuaki on 2018/01/19.
 */

public class Utility {

  public static long getTomorrowMidnight(){
    Calendar calendar = Calendar.getInstance();

    // 明日の 0 時にセット
    calendar.add(Calendar.DAY_OF_YEAR, 1);
    calendar.set(Calendar.HOUR, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);

    return calendar.getTimeInMillis();
  }
}
