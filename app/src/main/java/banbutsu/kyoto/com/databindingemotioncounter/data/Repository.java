package banbutsu.kyoto.com.databindingemotioncounter.data;

import android.arch.lifecycle.LiveData;
import banbutsu.kyoto.com.databindingemotioncounter.MyExecutor;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.CharacterDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.RemarksDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.model.CharacterEntry;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Yasuaki on 2018/01/14.
 */
@Singleton
public class Repository {

  private final CharacterDao characterDao;
  private final RemarksDao remarksDao;
  private final MyExecutor executor;

  @Inject
  public Repository(CharacterDao characterDao,
      RemarksDao remarksDao, MyExecutor executor) {
    this.characterDao = characterDao;
    this.remarksDao = remarksDao;
    this.executor = executor;
  }

  public LiveData<CharacterEntry> getCharacterById(int characterId) {
    return characterDao.getCharacterById(characterId);
  }
}
