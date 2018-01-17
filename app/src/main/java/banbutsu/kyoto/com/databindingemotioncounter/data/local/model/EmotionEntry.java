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
}
