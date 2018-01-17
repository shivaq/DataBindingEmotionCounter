package banbutsu.kyoto.com.databindingemotioncounter.data.local.model;

import static android.arch.persistence.room.ForeignKey.CASCADE;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Yasuaki on 2018/01/17.
 */
@Entity(tableName = "emissions",
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
public class EmissionEntry {

  @PrimaryKey(autoGenerate = true)
  public int id;
  public long date;
  public int characterId;
  public int emotionId;

}
