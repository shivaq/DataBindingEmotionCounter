package banbutsu.kyoto.com.databindingemotioncounter.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

/**
 * Created by Yasuaki on 2018/01/13.
 */
@Dao
public interface CharacterDao {

  @Insert
  void insert(CharacterEntry characterEntry);

  @Query("SELECT * FROM character")
  List<CharacterEntry> getAllCharacters();

  @Query("SELECT * FROM character WHERE id = :characterId")
  CharacterEntry findById(int characterId);
}
