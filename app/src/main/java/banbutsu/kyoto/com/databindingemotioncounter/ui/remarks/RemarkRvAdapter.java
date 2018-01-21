package banbutsu.kyoto.com.databindingemotioncounter.ui.remarks;

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

  /**
   * ・アイテムのレイアウトから ViewBinding を生成させ、
   * アイテム内の 各View にクリックListener等をセット。
   *
   * ・返り値 の ViewBinding を RvAdapter の抽象クラスを経由させる
   *
   * ・ViewHolder のコンストラクタの引数に ViewBinding が渡される
   * @param parent
   * @return
   */
  @Override
  protected RvItemRemarkListBinding createBinding(ViewGroup parent) {

    // RecyclerView のアイテムの ViewBinding を取得
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
  protected void bindObjToItem(RvItemRemarkListBinding binding, RemarkEntry remark) {
    // RvItem から <data> 内のアイテムにアクセスできるようにするため、
    // ViewDataBinding に OBJ を渡す
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
