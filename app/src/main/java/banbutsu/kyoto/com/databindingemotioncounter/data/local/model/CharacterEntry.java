package banbutsu.kyoto.com.databindingemotioncounter.data.local.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Yasuaki on 2018/01/12.
 */

@Entity(tableName = "characters", indices = {@Index(value = {"name", "type"}, unique = true)})
public class CharacterEntry {

  @PrimaryKey(autoGenerate = true)
  public int id;
  public String name;
  public int type;

}
