package banbutsu.kyoto.com.databindingemotioncounter.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.CharacterDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.CharacterEntry;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.MonologueEntry;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.MonologueDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.EmotionDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.EmotionEntry;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;

/**
 * Created by Yasuaki on 2018/01/13.
 *
 * Database 更新時に、リビルドではなく、マイグレーションをする場合は
 * addMigrations(SOME_MIGRATION_POLICY).build() // build メソッドに左記を追加
 *
 */
@Database(entities = {CharacterEntry.class, MonologueEntry.class, EmotionEntry.class,
    RemarkEntry.class}, version = 3)
public abstract class EmotionDatabase extends RoomDatabase {

  public abstract CharacterDao characterDao();

  public abstract MonologueDao emissionDao();

  public abstract EmotionDao emotionDao();

  public abstract RemarkDao remarkDao();
}
