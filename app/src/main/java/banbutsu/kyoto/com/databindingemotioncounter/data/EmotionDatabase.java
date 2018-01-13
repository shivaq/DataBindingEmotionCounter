package banbutsu.kyoto.com.databindingemotioncounter.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Yasuaki on 2018/01/13.
 */
@Database(entities = {Character.class, Remark.class}, version = 1)
public abstract class EmotionDatabase extends RoomDatabase {

  private static final String DATABASE_NAME = "emtion_database";

  private static final Object LOCK = new Object();

  // volatile を Synchronized の代わりにロックに使える条件2つ
//  その変数への書き込みが、その変数の現在の値に依存しない。
//  その変数が、他の変数との不変式に使われていない。
  private static volatile EmotionDatabase sInstance;

  public static EmotionDatabase getInstance(Context context) {
    if (sInstance == null) {
      synchronized (LOCK) {
        if (sInstance == null) {
          sInstance = Room.databaseBuilder(context.getApplicationContext(),
              EmotionDatabase.class, DATABASE_NAME).build();
        }
      }
    }
    return sInstance;
  }

  public abstract CharacterDao characterDao();

  public abstract RemarksDao remarksDao();
}
