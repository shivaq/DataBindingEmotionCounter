package banbutsu.kyoto.com.databindingemotioncounter;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Global executor pools for the whole application.
 * <p>
 * Grouping tasks like this avoids the effects of task starvation
 * (e.g. disk reads don't wait behind webservice requests).
 */
@Singleton
public class MyExecutor {

  private final Executor diskIO;
  private final Executor mainThread;
  private final Executor networkIO;

  public MyExecutor(Executor diskIO, Executor mainThread, Executor networkIO) {
    this.diskIO = diskIO;
    this.mainThread = mainThread;
    this.networkIO = networkIO;
  }

  @Inject
  public MyExecutor() {
    this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3),
        new MainThreadExecutor());
  }

  public Executor diskIO() {
    return diskIO;
  }

  public Executor mainThread() {
    return mainThread;
  }

  public Executor networkIO() {
    return networkIO;
  }

  private static class MainThreadExecutor implements Executor {

    private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(@NonNull Runnable runnable) {
      mainThreadHandler.post(runnable);
    }
  }
}
