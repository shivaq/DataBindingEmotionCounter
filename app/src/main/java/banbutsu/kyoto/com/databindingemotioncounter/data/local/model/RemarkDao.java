package banbutsu.kyoto.com.databindingemotioncounter.data.local.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

/**
 * Created by Yasuaki on 2018/01/13.
 */
@Dao
public interface RemarkDao {

  @Insert
  void bulkInsert(List<RemarkEntry> remarkEntries);

  @Insert
  void insert(RemarkEntry remarkEntry);

  @Update
  void update(RemarkEntry remarkEntry);

  @Query("SELECT * FROM remarks WHERE emotion = :emotion")
  LiveData<List<RemarkEntry>> getRemarkByEmotion(String emotion);
}
