package banbutsu.kyoto.com.databindingemotioncounter.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.EmotionDatabase;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.CharacterDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.EmissionDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.EmotionDao;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkDao;
import banbutsu.kyoto.com.databindingemotioncounter.di.qualifier.DatabaseInfo;
import banbutsu.kyoto.com.databindingemotioncounter.di.qualifier.PreferenceInfo;
import banbutsu.kyoto.com.databindingemotioncounter.utils.Constants;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Yasuaki on 2018/01/11.
 */

@Module(includes = ViewModelModule.class)// includes で ViewModelModule も 組み込まれた
public class ApplicationModule {

  @Provides
  @Singleton
  Context provideContext(Application application) {
    return application;
  }

  /************************** PreferencesHelper ****************************/
  @Provides
  @PreferenceInfo
  String providePreferenceName() {
    return Constants.PREF_FILE_NAME;
  }

  /************************** DataBase **************************************/
  @Provides
  @DatabaseInfo
  String provideDatabaseName() {
    return Constants.DB_NAME;
  }

  @Provides
  @Singleton
  public EmotionDatabase provideDatabase(@DatabaseInfo String dbName, Application application) {
    return Room.databaseBuilder(application, EmotionDatabase.class, dbName).build();
  }

  @Singleton
  @Provides
  public CharacterDao provideCharacterDao(EmotionDatabase db) {
    return db.characterDao();
  }

  @Singleton
  @Provides
  public EmissionDao provideEmissionDao(EmotionDatabase db) {
    return db.emissionDao();
  }

  @Singleton
  @Provides
  public EmotionDao provideEmotionDao(EmotionDatabase db) {
    return db.emotionDao();
  }

  @Singleton
  @Provides
  public RemarkDao provideRemarkDao(EmotionDatabase db) {
    return db.remarkDao();
  }
}