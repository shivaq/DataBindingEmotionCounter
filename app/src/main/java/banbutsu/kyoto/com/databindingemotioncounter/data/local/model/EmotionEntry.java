package banbutsu.kyoto.com.databindingemotioncounter.data.local.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Yasuaki on 2018/01/17.
 */
@Entity(tableName = "emotions")
public class EmotionEntry {

  @PrimaryKey(autoGenerate = true)  public int id;
  public int joy;
  public int trust;
  public int fear;
  public int anticipation;

  public int sadness;
  public int disgust;
  public int anger;
  public int surprise;

  public int optimism;
  public int love;
  public int submission;
  public int awe;
  public int disappointment;
  public int remorse;
  public int contempt;
  public int aggressiveness;

  public int libido;
  public int shame;
  public int self_respect;

  public int reserve1;
  public int reserve2;
  public int reserve3;
  public int reserve4;
  public int reserve5;
  public int reserve6;
  public int reserve7;

  public EmotionEntry(int joy, int trust, int fear, int anticipation, int sadness, int disgust,
      int anger, int surprise, int optimism, int love, int submission, int awe, int disappointment,
      int remorse, int contempt, int aggressiveness, int libido, int shame, int self_respect,
      int reserve1, int reserve2, int reserve3, int reserve4, int reserve5, int reserve6,
      int reserve7) {
    this.joy = joy;
    this.trust = trust;
    this.fear = fear;
    this.anticipation = anticipation;
    this.sadness = sadness;
    this.disgust = disgust;
    this.anger = anger;
    this.surprise = surprise;
    this.optimism = optimism;
    this.love = love;
    this.submission = submission;
    this.awe = awe;
    this.disappointment = disappointment;
    this.remorse = remorse;
    this.contempt = contempt;
    this.aggressiveness = aggressiveness;
    this.libido = libido;
    this.shame = shame;
    this.self_respect = self_respect;
    this.reserve1 = reserve1;
    this.reserve2 = reserve2;
    this.reserve3 = reserve3;
    this.reserve4 = reserve4;
    this.reserve5 = reserve5;
    this.reserve6 = reserve6;
    this.reserve7 = reserve7;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EmotionEntry)) {
      return false;
    }

    EmotionEntry that = (EmotionEntry) o;

    if (id != that.id) {
      return false;
    }
    if (joy != that.joy) {
      return false;
    }
    if (trust != that.trust) {
      return false;
    }
    if (fear != that.fear) {
      return false;
    }
    if (anticipation != that.anticipation) {
      return false;
    }
    if (sadness != that.sadness) {
      return false;
    }
    if (disgust != that.disgust) {
      return false;
    }
    if (anger != that.anger) {
      return false;
    }
    if (surprise != that.surprise) {
      return false;
    }
    if (optimism != that.optimism) {
      return false;
    }
    if (love != that.love) {
      return false;
    }
    if (submission != that.submission) {
      return false;
    }
    if (awe != that.awe) {
      return false;
    }
    if (disappointment != that.disappointment) {
      return false;
    }
    if (remorse != that.remorse) {
      return false;
    }
    if (contempt != that.contempt) {
      return false;
    }
    if (aggressiveness != that.aggressiveness) {
      return false;
    }
    if (libido != that.libido) {
      return false;
    }
    if (shame != that.shame) {
      return false;
    }
    if (self_respect != that.self_respect) {
      return false;
    }
    if (reserve1 != that.reserve1) {
      return false;
    }
    if (reserve2 != that.reserve2) {
      return false;
    }
    if (reserve3 != that.reserve3) {
      return false;
    }
    if (reserve4 != that.reserve4) {
      return false;
    }
    if (reserve5 != that.reserve5) {
      return false;
    }
    if (reserve6 != that.reserve6) {
      return false;
    }
    return reserve7 == that.reserve7;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + joy;
    result = 31 * result + trust;
    result = 31 * result + fear;
    result = 31 * result + anticipation;
    result = 31 * result + sadness;
    result = 31 * result + disgust;
    result = 31 * result + anger;
    result = 31 * result + surprise;
    result = 31 * result + optimism;
    result = 31 * result + love;
    result = 31 * result + submission;
    result = 31 * result + awe;
    result = 31 * result + disappointment;
    result = 31 * result + remorse;
    result = 31 * result + contempt;
    result = 31 * result + aggressiveness;
    result = 31 * result + libido;
    result = 31 * result + shame;
    result = 31 * result + self_respect;
    result = 31 * result + reserve1;
    result = 31 * result + reserve2;
    result = 31 * result + reserve3;
    result = 31 * result + reserve4;
    result = 31 * result + reserve5;
    result = 31 * result + reserve6;
    result = 31 * result + reserve7;
    return result;
  }

  @Override
  public String toString() {
    return "EmotionEntry{" +
        "id=" + id +
        ", joy=" + joy +
        ", trust=" + trust +
        ", fear=" + fear +
        ", anticipation=" + anticipation +
        ", sadness=" + sadness +
        ", disgust=" + disgust +
        ", anger=" + anger +
        ", surprise=" + surprise +
        ", optimism=" + optimism +
        ", love=" + love +
        ", submission=" + submission +
        ", awe=" + awe +
        ", disappointment=" + disappointment +
        ", remorse=" + remorse +
        ", contempt=" + contempt +
        ", aggressiveness=" + aggressiveness +
        ", libido=" + libido +
        ", shame=" + shame +
        ", self_respect=" + self_respect +
        ", reserve1=" + reserve1 +
        ", reserve2=" + reserve2 +
        ", reserve3=" + reserve3 +
        ", reserve4=" + reserve4 +
        ", reserve5=" + reserve5 +
        ", reserve6=" + reserve6 +
        ", reserve7=" + reserve7 +
        '}';
  }
}
