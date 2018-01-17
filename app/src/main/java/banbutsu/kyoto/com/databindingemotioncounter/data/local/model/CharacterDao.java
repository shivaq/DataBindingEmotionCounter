package banbutsu.kyoto.com.databindingemotioncounter.data.local.model;

import android.arch.lifecycle.LiveData;
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

  @Query("SELECT * FROM characters")
  List<CharacterEntry> getAllCharacters();

  @Query("SELECT * FROM characters WHERE id = :characterId")
  LiveData<CharacterEntry> getCharacterById(int characterId);
}
