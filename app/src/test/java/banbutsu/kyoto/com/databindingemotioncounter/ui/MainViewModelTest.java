package banbutsu.kyoto.com.databindingemotioncounter.ui;

import static org.mockito.Mockito.mock;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.Observer;
import banbutsu.kyoto.com.databindingemotioncounter.data.Repository;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;
import banbutsu.kyoto.com.databindingemotioncounter.ui.main.MainViewModel;
import banbutsu.kyoto.com.databindingemotioncounter.ui.util.TestUtility;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Yasuaki on 2018/01/23.
 */
@RunWith(JUnit4.class)
public class MainViewModelTest {

  @Rule
  // Architecture Components が使うバックグラウンドの Executor を、
  // 各タスクを synchronously に行う Executor に スワップする
  public InstantTaskExecutorRule taskExecutorRule = new InstantTaskExecutorRule();

  private Repository repository;
  private MainViewModel mainViewModel;

  @Before
  public void setup() {
    repository = mock(Repository.class);
    mainViewModel = new MainViewModel(repository);
  }

  @Test
  public void basic() {

    // Given
    // View が LiveData をObserve している状態で
    Observer<List<RemarkEntry>> result = mock(Observer.class);

    // when
    // 感情文字が送られた時
    mainViewModel.getRemarksByEmotion(TestUtility.getEmotionArray()[0]);

    // then

    // その感情のセリフのリストが渡される



  }
}
