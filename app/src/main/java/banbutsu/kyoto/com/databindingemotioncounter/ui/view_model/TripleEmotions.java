package banbutsu.kyoto.com.databindingemotioncounter.ui.view_model;

import android.graphics.drawable.Drawable;

/**
 * Created by Yasuaki on 2018/01/20.
 */

public class TripleEmotions {

  private String emotion1;
  private String emotion2;
  private String emotion3;
  private String remark1;
  private String remark2;
  private String remark3;
  private Drawable drawable1;
  private Drawable drawable2;
  private Drawable drawable3;
  private String mixedEmotion1;
  private String mixedEmotion2;

  public TripleEmotions(String emotion1, String emotion2, String emotion3, String remark1,
      String remark2, String remark3, Drawable drawable1,
      Drawable drawable2, Drawable drawable3, String mixedEmotion1, String mixedEmotion2) {
    this.emotion1 = emotion1;
    this.emotion2 = emotion2;
    this.emotion3 = emotion3;
    this.remark1 = remark1;
    this.remark2 = remark2;
    this.remark3 = remark3;
    this.drawable1 = drawable1;
    this.drawable2 = drawable2;
    this.drawable3 = drawable3;
    this.mixedEmotion1 = mixedEmotion1;
    this.mixedEmotion2 = mixedEmotion2;
  }

  public String getEmotion1() {
    return emotion1;
  }

  public String getEmotion2() {
    return emotion2;
  }

  public String getEmotion3() {
    return emotion3;
  }

  public String getRemark1() {
    return remark1;
  }

  public String getRemark2() {
    return remark2;
  }

  public String getRemark3() {
    return remark3;
  }

  public Drawable getDrawable1() {
    return drawable1;
  }

  public Drawable getDrawable2() {
    return drawable2;
  }

  public Drawable getDrawable3() {
    return drawable3;
  }

  public String getMixedEmotion1() {
    return mixedEmotion1;
  }

  public String getMixedEmotion2() {
    return mixedEmotion2;
  }

}
