package banbutsu.kyoto.com.databindingemotioncounter.ui.list;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import banbutsu.kyoto.com.databindingemotioncounter.R;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;
import banbutsu.kyoto.com.databindingemotioncounter.databinding.RvItemRemarkListBinding;
import banbutsu.kyoto.com.databindingemotioncounter.ui.common.DataBoundRvAdapter;
import banbutsu.kyoto.com.databindingemotioncounter.utils.ObjEqualCheck;

/**
 * Created by Yasuaki on 2018/01/18.
 */

public class RemarkRvAdapter extends DataBoundRvAdapter<RemarkEntry, RvItemRemarkListBinding> {

  private RemarkRvCallback remarkRvCallback;

  public RemarkRvAdapter(RemarkRvCallback remarkRvCallback) {
    this.remarkRvCallback = remarkRvCallback;
  }

  @Override
  protected RvItemRemarkListBinding createBinding(ViewGroup parent) {
    RvItemRemarkListBinding binding =
        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
            R.layout.rv_item_remark_list, parent, false);

    binding.getRoot().setOnClickListener(v -> {
      RemarkEntry remark = binding.getRemark();
      if (remark != null && remarkRvCallback != null) {
        remarkRvCallback.onClick(remark);
      }
    });
    return binding;
  }

  @Override
  protected void bind(RvItemRemarkListBinding binding, RemarkEntry remark) {
    binding.setRemark(remark);
  }

  @Override
  protected boolean areItemsTheSame(RemarkEntry oldItem, RemarkEntry newItem) {
    return ObjEqualCheck.equals(oldItem.id, newItem.id);
  }

  @Override
  protected boolean areContentsTheSame(RemarkEntry oldItem, RemarkEntry newItem) {
    return ObjEqualCheck.equals(oldItem.say, newItem.say)
        && ObjEqualCheck.equals(oldItem.emotion, newItem.emotion);
  }

  /***************************** Callback *********************************/
  interface RemarkRvCallback {

    void onClick(RemarkEntry remark);
  }
}
