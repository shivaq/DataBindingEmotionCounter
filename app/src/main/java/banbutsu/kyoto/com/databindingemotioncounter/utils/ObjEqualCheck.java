package banbutsu.kyoto.com.databindingemotioncounter.utils;

/**
 * Created by Yasuaki on 2018/01/19.
 */

public class ObjEqualCheck {

  public static boolean equals(Object o1, Object o2) {
    if (o1 == null) {
      return o2 == null;
    }
    if (o2 == null) {
      return false;
    }
    return o1.equals(o2);
  }
}
