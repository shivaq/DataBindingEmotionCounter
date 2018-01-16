package banbutsu.kyoto.com.databindingemotioncounter.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import banbutsu.kyoto.com.databindingemotioncounter.data.model.RemarkEntry;
import java.util.List;

/**
 * Created by Yasuaki on 2018/01/13.
 */
@Dao
public interface RemarksDao {

  @Insert
  void insert(RemarkEntry remarkEntry);

  @Query("SELECT * FROM remarks WHERE emotion = :emotion")
  List<RemarkEntry> findRemarksByEmotion(String emotion);
}
