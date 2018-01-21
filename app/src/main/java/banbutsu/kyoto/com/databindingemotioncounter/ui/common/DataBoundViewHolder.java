package banbutsu.kyoto.com.databindingemotioncounter.ui.common;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * A generic ViewHolder that works with a {@link ViewDataBinding}.
 * @param <T> The type of the ViewDataBinding.
 *
 * アダプタ でレイアウトファイル等から ViewDataBinding を実装してから、
 * コンストラクタに渡されてくる
 */
public class DataBoundViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

  public final T binding;

  public DataBoundViewHolder(T binding) {
    super(binding.getRoot());
    this.binding = binding;
  }
}

//// 抽象クラスを経由させずないパターンの DataBinding 対応 ViewHolder
//public static class ItemViewHolder extends RecyclerView.ViewHolder {
//  private ViewDataBinding mBinding;
//
//  public ItemViewHolder(View v) {
//    super(v);
//    // Bind処理
//    mBinding = DataBindingUtil.bindObjToItem(v);
//  }
//
//  public ViewDataBinding getBinding() {
//    return mBinding;
//  }
//}