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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CharacterEntry)) {
      return false;
    }

    CharacterEntry that = (CharacterEntry) o;

    if (id != that.id) {
      return false;
    }
    if (type != that.type) {
      return false;
    }
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + name.hashCode();
    result = 31 * result + type;
    return result;
  }

  @Override
  public String toString() {
    return "CharacterEntry{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", type=" + type +
        '}';
  }

  public CharacterEntry(String name, int type) {
    this.name = name;
    this.type = type;
  }
}
