package banbutsu.kyoto.com.databindingemotioncounter.data.local.model;

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
  public String say;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RemarkEntry)) {
      return false;
    }

    RemarkEntry that = (RemarkEntry) o;

    if (id != that.id) {
      return false;
    }
    if (!emotion.equals(that.emotion)) {
      return false;
    }
    return say.equals(that.say);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + emotion.hashCode();
    result = 31 * result + say.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "RemarkEntry{" +
        "id=" + id +
        ", emotion='" + emotion + '\'' +
        ", say='" + say + '\'' +
        '}';
  }
}
