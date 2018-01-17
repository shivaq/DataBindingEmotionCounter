package banbutsu.kyoto.com.databindingemotioncounter.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.dao.CharacterDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.dao.RemarksDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.CharacterEntry;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;

/**
 * Created by Yasuaki on 2018/01/13.
 */
@Database(entities = {CharacterEntry.class, RemarkEntry.class}, version = 1)
public abstract class EmotionDatabase extends RoomDatabase {

  public abstract CharacterDao characterDao();

  public abstract RemarksDao remarksDao();
}
