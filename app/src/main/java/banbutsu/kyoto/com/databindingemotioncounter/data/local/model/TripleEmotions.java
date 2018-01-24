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

  private static TripleEmotions sInstance;

  private TripleEmotions(String rawEmotion1, String rawEmotion2, String rawEmotion3,
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

  public static synchronized TripleEmotions getInstance(
      String rawEmotion1, String rawEmotion2, String rawEmotion3,
      String emotion1, String emotion2, String emotion3,
      String mixedEmotion1, String mixedEmotion2,
      String remark1, String remark2, String remark3) {
    if (sInstance == null) {
      sInstance = new TripleEmotions(rawEmotion1, rawEmotion2, rawEmotion3,
          emotion1, emotion2, emotion3, mixedEmotion1, mixedEmotion2, remark1, remark2, remark3);
    }
    return sInstance
        .setRawEmotion1(rawEmotion1).setRawEmotion2(rawEmotion2).setRawEmotion3(rawEmotion3)
        .setEmotion1(emotion1).setEmotion2(emotion2).setEmotion3(emotion3)
        .setMixedEmotion1(mixedEmotion1).setMixedEmotion2(mixedEmotion2).
            setRemark1(remark1).setRemark2(remark2).setRemark3(remark3);
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

  private TripleEmotions setRawEmotion1(String rawEmotion1) {
    this.rawEmotion1 = rawEmotion1;
    return this;
  }

  private TripleEmotions setRawEmotion2(String rawEmotion2) {
    this.rawEmotion2 = rawEmotion2;
    return this;
  }

  private TripleEmotions setRawEmotion3(String rawEmotion3) {
    this.rawEmotion3 = rawEmotion3;
    return this;
  }

  private TripleEmotions setEmotion1(String emotion1) {
    this.emotion1 = emotion1;
    return this;
  }

  private TripleEmotions setEmotion2(String emotion2) {
    this.emotion2 = emotion2;
    return this;
  }

  private TripleEmotions setEmotion3(String emotion3) {
    this.emotion3 = emotion3;
    return this;
  }

  private TripleEmotions setMixedEmotion1(String mixedEmotion1) {
    this.mixedEmotion1 = mixedEmotion1;
    return this;
  }

  private TripleEmotions setMixedEmotion2(String mixedEmotion2) {
    this.mixedEmotion2 = mixedEmotion2;
    return this;
  }

  private TripleEmotions setRemark1(String remark1) {
    this.remark1 = remark1;
    return this;
  }

  private TripleEmotions setRemark2(String remark2) {
    this.remark2 = remark2;
    return this;
  }

  private TripleEmotions setRemark3(String remark3) {
    this.remark3 = remark3;
    return this;
  }
}
