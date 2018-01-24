package banbutsu.kyoto.com.databindingemotioncounter.ui.common;

import android.annotation.SuppressLint;
import android.databinding.ViewDataBinding;
import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.DiffUtil.Callback;
import android.support.v7.util.DiffUtil.DiffResult;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.List;
import timber.log.Timber;

/**
 * A generic RecyclerView adapter that uses Data Binding & DiffUtil.
 *
 * @param <T> Type of the list in the list
 * @param <V> Type of the ViewDataBinding
 */
public abstract class DataBoundRvAdapter<T, V extends ViewDataBinding>
    extends RecyclerView.Adapter<DataBoundViewHolder<V>> {

  protected abstract V createBinding(ViewGroup parent);

  @Override
  public DataBoundViewHolder<V> onCreateViewHolder(ViewGroup parent, int viewType) {
    // 具象クラスのほうで ViewDataBinding を実装して受け取る
    V binding = createBinding(parent);
    return new DataBoundViewHolder<>(binding);
  }

  protected abstract void bindObjToItem(V binding, T item);

  @Nullable
  private List<T> list;

  @Override
  public void onBindViewHolder(DataBoundViewHolder<V> holder, int position) {

    // $1: ViewDataBinding $2: xml の <data> 経由でアクセスさせる List
    bindObjToItem(holder.binding, list.get(position));
    // executePendingBindings:View が持つ式に紐付いた変数 が変化した時、View を更新する。
    // スクロール時に Binding がなされているかチェックすることで、挙動を安定させる
    holder.binding.executePendingBindings();
  }

  @Override
  public int getItemCount() {
    if (list != null) {
      Timber.d("DataBoundRvAdapter:getItemCount: list size:%s",list.size());
    }
    return list == null ? 0 : list.size();
  }

  /********************* DiffUtil を AsyncTask で実行 ********************************/
  protected abstract boolean areItemsTheSame(T oldItem, T newItem);

  protected abstract boolean areContentsTheSame(T oldItem, T newItem);

  // each time data is set, we update this variable so that if DiffUtil calculation returns
  // after repetitive updates, we can ignore the old calculation
  private int dataVersion = 0;

  @SuppressLint("StaticFieldLeak")
  @MainThread
  public void replaceWithDiffUtil(List<T> listToUpdate) {
    dataVersion++;
    // 既存のリスト 及び 置換候補リストをnullチェック
    if (list == null) {
      if (listToUpdate == null) {
        return;
      }
      list = listToUpdate;
      notifyDataSetChanged();
    } else if (listToUpdate == null) {
      int oldSize = list.size();
      list = null;
      notifyItemRangeRemoved(0, oldSize);
    } else {// 要置換
      final int startVersion = dataVersion;
      final List<T> oldList = list;
      new AsyncTask<Void, Void, DiffResult>() {

        @Override
        protected DiffResult doInBackground(Void... voids) {
          return DiffUtil.calculateDiff(new Callback() {

            @Override
            public int getOldListSize() {
              return oldList.size();
            }

            @Override
            public int getNewListSize() {
              return listToUpdate.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
              T oldItem = oldList.get(oldItemPosition);
              T newItem = listToUpdate.get(newItemPosition);
              return DataBoundRvAdapter.this.areItemsTheSame(oldItem, newItem);
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
              T oldItem = oldList.get(oldItemPosition);
              T newItem = listToUpdate.get(newItemPosition);
              return DataBoundRvAdapter.this.areContentsTheSame(oldItem, newItem);
            }
          });
        }

        @Override
        protected void onPostExecute(DiffResult diffResult) {
          if (startVersion != dataVersion) {
            // update 不要
            return;
          }
          list = listToUpdate;
          Timber.d("DataBoundRvAdapter:onPostExecute: postExecute list size:%s",list.size());
          diffResult.dispatchUpdatesTo(DataBoundRvAdapter.this);
        }
      }.execute();
    }
  }
}
