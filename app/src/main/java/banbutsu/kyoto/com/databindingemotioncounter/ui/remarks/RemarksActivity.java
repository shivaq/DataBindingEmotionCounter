package banbutsu.kyoto.com.databindingemotioncounter.ui.remarks;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import banbutsu.kyoto.com.databindingemotioncounter.R;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;
import banbutsu.kyoto.com.databindingemotioncounter.databinding.ActivityListBinding;
import banbutsu.kyoto.com.databindingemotioncounter.databinding.EditDialogBinding;
import banbutsu.kyoto.com.databindingemotioncounter.ui.base.BaseActivity;
import banbutsu.kyoto.com.databindingemotioncounter.utils.Utility;
import java.util.Collections;
import javax.inject.Inject;

public class RemarksActivity extends BaseActivity implements RemarkRvAdapter.RemarkRvCallback {
  /**************************** Life cycle ********************************************/

  @Inject
  ViewModelProvider.Factory viewModelFactory;
  private RemarkViewModel viewModel;
  private ActivityListBinding binding;
  private RemarkRvAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
    binding.setRemark(this);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(RemarkViewModel.class);
    adapter = new RemarkRvAdapter(this);
    binding.rvRemarkList.setAdapter(adapter);
    displayRemarks("JOY");
  }

  @Override
  public void onClick(RemarkEntry remark) {
    displayEditDialog(remark.emotion, remark.say, remark.id);
  }

  private void displayEditDialog(String emotion, String say, long remarkId) {
    String emotionStr = Utility.getEmotionString(emotion) + "のセリフを入力";

    EditDialogBinding binding = DataBindingUtil
        .inflate(LayoutInflater.from(this), R.layout.edit_dialog, null, false);

    binding.editDialog.setText(say);

    AlertDialog.Builder builder = new Builder(this);
    builder.setView(binding.getRoot());
    builder.setTitle(emotionStr);
    builder.setPositiveButton("OK", (dialog, which) -> {
      // 入力内容に変化があるかどうか
      if (!binding.editDialog.getText().toString().equals(say)) {
        // 新規作成
        if (remarkId == 0L) {

        }else{// 既存のセリフを更新

        }
      }
    });
    builder.setNegativeButton("キャンセル", (dialog, which) -> {
    });

    AlertDialog dialog = builder.create();
    dialog.show();
  }

  public void displayRemarks(String emotion) {
    selectedEmotion = emotion;
    String btnText = Utility.getEmotionString(emotion) + "のセリフを追加する";
    binding.btnAddRemark.setText(btnText);
    viewModel.getRemarksByEmotion(emotion).observe(this, remarkList -> {
      if (remarkList != null) {
        adapter.replaceWithDiffUtil(remarkList);
      } else {
        adapter.replaceWithDiffUtil(Collections.emptyList());
      }
    });
  }

  private String selectedEmotion = "";

  public void addRemark() {
    displayEditDialog(selectedEmotion, "", 0L);
  }
}
