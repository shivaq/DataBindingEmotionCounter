package banbutsu.kyoto.com.databindingemotioncounter.ui.common;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * A generic ViewHolder that works with a {@link ViewDataBinding}.
 * @param <T> The type of the ViewDataBinding.
 *
 * ViewDataBinding は、View クラス が DataBinding と紐付いたもの。
 * Activity の onCreate に DataBindingUtil.inflate で作られるのも ViewDataBinding クラス
 */
public class DataBoundViewHolder_specific<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

  public final T binding;

  public DataBoundViewHolder_specific(T binding) {
    super(binding.getRoot());
    this.binding = binding;
  }
}
