package banbutsu.kyoto.com.databindingemotioncounter.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import banbutsu.kyoto.com.databindingemotioncounter.data.CharacterEntry;
import banbutsu.kyoto.com.databindingemotioncounter.data.RemarkEntry;

/**
 * Created by Yasuaki on 2018/01/14.
 * ViewModels survive configuration changes.
 * While this is true, ViewModels do not survive resource constraint related process death.
 * This is different than onSaveInstanceState, which does survive process death.
 */
public class MainActivityViewModel extends ViewModel {

  private MutableLiveData<CharacterEntry> character;
  private MutableLiveData<RemarkEntry> remark;

  public MainActivityViewModel() {
    character = new MutableLiveData<>();
    remark = new MutableLiveData<>();
  }

  public MutableLiveData<CharacterEntry> getCharacter() {
    return character;
  }

  public MutableLiveData<RemarkEntry> getRemark() {
    return remark;
  }

  public void setCharacter(CharacterEntry characterEntry) {
    // setValue() は メインスレッドが使う。他のスレッドを使う場合は postValue()
    this.character.postValue(characterEntry);
  }

  public void setRemark(RemarkEntry remarkEntry) {
    this.remark.postValue(remarkEntry);
  }
}
