package banbutsu.kyoto.com.databindingemotioncounter.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.CharacterDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.CharacterEntry;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.EmissionDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.EmissionEntry;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.EmotionDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.EmotionEntry;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;

/**
 * Created by Yasuaki on 2018/01/13.
 */
@Database(entities = {CharacterEntry.class, EmissionEntry.class, EmotionEntry.class,
    RemarkEntry.class}, version = 1)
public abstract class EmotionDatabase extends RoomDatabase {

  public abstract CharacterDao characterDao();

  public abstract EmissionDao emissionDao();

  public abstract EmotionDao emotionDao();

  public abstract RemarkDao remarkDao();
}
