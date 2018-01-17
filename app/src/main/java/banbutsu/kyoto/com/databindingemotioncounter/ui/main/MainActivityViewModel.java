//package banbutsu.kyoto.com.databindingemotioncounter.ui.main;
//
//import android.arch.lifecycle.LiveData;
//import android.arch.lifecycle.MutableLiveData;
//import android.arch.lifecycle.ViewModel;
//import banbutsu.kyoto.com.databindingemotioncounter.data.Repository;
//import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.CharacterEntry;
//import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;
//
///**
// * Created by Yasuaki on 2018/01/14.
// * ViewModels survive configuration changes.
// * While this is true, ViewModels do not survive resource constraint related process death.
// * This is different than onSaveInstanceState, which does survive process death.
// *
// * ★ ★ ViewModel を Factory 経由で生成する理由 ★ ★
// * ViewModel は Activity や Fragment、 View などの context を取得する事を避ける必要がある。
// * それらの OBJ は ViewModel より lifespan が短いため、抱え込むと GC を妨げて
// * メモリーリークにつながってしまうから。
// */
//public class MainActivityViewModel extends ViewModel {
//
//  //  setValue(T) 及び postValue(T) を使う用 LiveData
//  private MutableLiveData<RemarkEntry> remark;
//  private Repository repository;
//  private int currentCharacterId;
//
//  public MainActivityViewModel(Repository repository, int currentCharacterId) {
//    remark = new MutableLiveData<>();
//    this.repository = repository;
//    this.currentCharacterId = currentCharacterId;
//  }
//
//  public LiveData<CharacterEntry> getCharacter() {
//    return repository.getCharacterById(currentCharacterId);
//  }
//
//  public MutableLiveData<RemarkEntry> getRemark() {
//    return remark;
//  }
//
//  public void setRemark(RemarkEntry remarkEntry) {
//    // setValue() は メインスレッドが使う。他のスレッドを使う場合は postValue()
//    this.remark.postValue(remarkEntry);
//  }
//}
