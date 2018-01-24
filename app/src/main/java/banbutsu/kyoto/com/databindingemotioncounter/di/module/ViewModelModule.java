package banbutsu.kyoto.com.databindingemotioncounter.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import banbutsu.kyoto.com.databindingemotioncounter.di.qualifier.ViewModelKey;
import banbutsu.kyoto.com.databindingemotioncounter.ui.common.EmotionViewModelFactory;
import banbutsu.kyoto.com.databindingemotioncounter.ui.remarks.RemarkViewModel;
import banbutsu.kyoto.com.databindingemotioncounter.ui.main.MainViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Yasuaki on 2018/01/19.
 */
@Module
public abstract class ViewModelModule {

  @Binds// 返り値の値(抽象クラス)引数の値(具象クラス)とを紐付ける
  @IntoMap// @Provides の返す Value を @MapKey で指定された Key にマップする
  @ViewModelKey(RemarkViewModel.class)// @MapKey
  public abstract ViewModel bindRemarkViewModel(RemarkViewModel remarkViewModel);

  @Binds
  @IntoMap
  @ViewModelKey(MainViewModel.class)
  public abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);

  @Binds
  public abstract ViewModelProvider.Factory bindViewModelFactory(EmotionViewModelFactory factory);
}
