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
  void insert(Character character);

  @Query("SELECT * FROM character")
  List<Character> getAllCharacters();

  @Query("SELECT * FROM character WHERE id = :characterId")
  Character findById(int characterId);
}
