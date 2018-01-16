package banbutsu.kyoto.com.databindingemotioncounter.ui.main;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import banbutsu.kyoto.com.databindingemotioncounter.data.Repository;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Yasuaki on 2018/01/14.
 */
@Singleton
public class MainVMFactory extends ViewModelProvider.NewInstanceFactory {

  private final Repository repository;
  private final int currentCharacterId;

  @Inject
  public MainVMFactory(
      Repository repository, int currentCharacterId) {
    this.repository = repository;
    this.currentCharacterId = currentCharacterId;
  }

  @NonNull
  @Override
  public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
    //noinspection unchecked
    return (T) new MainActivityViewModel(repository,currentCharacterId);
  }
}
