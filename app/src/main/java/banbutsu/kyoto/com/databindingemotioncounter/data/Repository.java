package banbutsu.kyoto.com.databindingemotioncounter.data;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import banbutsu.kyoto.com.databindingemotioncounter.MyExecutor;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.CharacterDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.CharacterEntry;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.EmissionDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.EmotionDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkDao;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Yasuaki on 2018/01/14.
 */
@Singleton
public class Repository {

  private final Context context;
  private final CharacterDao characterDao;
  private final EmissionDao emissionDao;
  private final EmotionDao eEmotionDao;

  private final RemarkDao remarkDao;
  private final MyExecutor executor;

  @Inject
  public Repository(Context context, CharacterDao characterDao,
      EmissionDao emissionDao, EmotionDao eEmotionDao,
      RemarkDao remarkDao, MyExecutor executor) {
    this.context = context;
    this.characterDao = characterDao;
    this.emissionDao = emissionDao;
    this.eEmotionDao = eEmotionDao;
    this.remarkDao = remarkDao;
    this.executor = executor;
  }

  public LiveData<CharacterEntry> getCharacterById(int characterId) {
    return characterDao.getCharacterById(characterId);
  }
}