package banbutsu.kyoto.com.databindingemotioncounter.data.local.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

/**
 * Created by Yasuaki on 2018/01/17.
 */
@Dao
public interface EmotionDao {

  @Insert
  void insert(EmotionEntry emotionEntry);

  @Update
  void update(EmotionEntry emotionEntry);
}
