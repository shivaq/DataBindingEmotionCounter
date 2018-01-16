package banbutsu.kyoto.com.databindingemotioncounter.data.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Yasuaki on 2018/01/12.
 */

@Entity(tableName = "remarks")
public class RemarkEntry {

  @PrimaryKey(autoGenerate = true)
  public int id;
  public String emotion;
  public String speech;

}
