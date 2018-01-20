package banbutsu.kyoto.com.databindingemotioncounter.data.local.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

/**
 * Created by Yasuaki on 2018/01/17.
 */
@Dao
public interface MonologueDao {

  @Insert
  long insert(MonologueEntry monologueEntry);

  @Update
  void update(MonologueEntry monologueEntry);

  @Query("SELECT * FROM monologues WHERE characterId = :characterId AND date = :date")
  MonologueEntry findMonologueByCharacterAndDate(int characterId, long date);

  @Query("SELECT * FROM monologues WHERE id = :monologueId")
  MonologueEntry getMonologueById(int monologueId);
}