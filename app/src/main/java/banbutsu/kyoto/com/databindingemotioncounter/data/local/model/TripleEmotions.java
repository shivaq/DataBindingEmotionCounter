package banbutsu.kyoto.com.databindingemotioncounter.data.local.model;

/**
 * Created by Yasuaki on 2018/01/20.
 */

public class TripleEmotions {

  private String rawEmotion1;
  private String rawEmotion2;
  private String rawEmotion3;
  private String emotion1;
  private String emotion2;
  private String emotion3;
  private String mixedEmotion1;
  private String mixedEmotion2;
  private String remark1;
  private String remark2;
  private String remark3;

  public TripleEmotions(String rawEmotion1, String rawEmotion2, String rawEmotion3,
      String emotion1, String emotion2, String emotion3,
      String mixedEmotion1, String mixedEmotion2, String remark1, String remark2,
      String remark3) {
    this.rawEmotion1 = rawEmotion1;
    this.rawEmotion2 = rawEmotion2;
    this.rawEmotion3 = rawEmotion3;
    this.emotion1 = emotion1;
    this.emotion2 = emotion2;
    this.emotion3 = emotion3;
    this.mixedEmotion1 = mixedEmotion1;
    this.mixedEmotion2 = mixedEmotion2;
    this.remark1 = remark1;
    this.remark2 = remark2;
    this.remark3 = remark3;
  }

  public String getRawEmotion1() {
    return rawEmotion1;
  }

  public String getRawEmotion2() {
    return rawEmotion2;
  }

  public String getRawEmotion3() {
    return rawEmotion3;
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

  public String getMixedEmotion1() {
    return mixedEmotion1;
  }

  public String getMixedEmotion2() {
    return mixedEmotion2;
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
}
