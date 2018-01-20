package banbutsu.kyoto.com.databindingemotioncounter.data.local.model;

import static android.arch.persistence.room.ForeignKey.CASCADE;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Yasuaki on 2018/01/17.
 */
@Entity(tableName = "monologues",
    indices={@Index("characterId"),@Index("emotionId")},
    foreignKeys = {
        @ForeignKey(
            entity = CharacterEntry.class,
            parentColumns = "id",
            childColumns = "characterId",
            onDelete = CASCADE),
        @ForeignKey(
            entity = EmotionEntry.class,
            parentColumns = "id",
            childColumns = "emotionId",
            onDelete = CASCADE)})
public class MonologueEntry {

  @PrimaryKey(autoGenerate = true)
  public int id;
  public long date;
  public int characterId;
  public int emotionId;

  public MonologueEntry(long date, int characterId, int emotionId) {
    this.date = date;
    this.characterId = characterId;
    this.emotionId = emotionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MonologueEntry)) {
      return false;
    }

    MonologueEntry that = (MonologueEntry) o;

    if (id != that.id) {
      return false;
    }
    if (date != that.date) {
      return false;
    }
    if (characterId != that.characterId) {
      return false;
    }
    return emotionId == that.emotionId;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (int) (date ^ (date >>> 32));
    result = 31 * result + characterId;
    result = 31 * result + emotionId;
    return result;
  }

  @Override
  public String toString() {
    return "MonologueEntry{" +
        "id=" + id +
        ", date=" + date +
        ", characterId=" + characterId +
        ", emotionId=" + emotionId +
        '}';
  }
}
