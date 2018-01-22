package banbutsu.kyoto.com.databindingemotioncounter.ui.remarks;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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
  private android.support.v7.app.ActionBar actionBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(RemarkViewModel.class);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
    binding.setRemark(this);

    adapter = new RemarkRvAdapter(this);
    binding.rvRemarkList.setAdapter(adapter);
    displayRemarks(selectedEmotion);

    actionBar = getSupportActionBar();
    subscribeToViewModel();
  }

  private void subscribeToViewModel() {
    viewModel.isDeleteMode().observe(this, isDelete -> {
      if (isDelete != null) {
        isDeleteMode = isDelete;
        actionBar.setTitle(Html.fromHtml(isDelete ?
            "<font color='#F1372C'>セリフ削除モード </font>" :
            "<font color='#FFFFFF'>セリフ編集モード </font>"));
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_remark, menu);
    return true;
  }

  public boolean isDeleteMode = false;

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int itemId = item.getItemId();
    switch (itemId) {
      case R.id.edit_remarks:
        viewModel.setIsDeleteMode(false);
        return true;
      case R.id.delete_remarks:
        viewModel.setIsDeleteMode(true);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }


  @Override
  public void onClick(RemarkEntry remark) {
    displayEditDialog(remark.emotion, remark.say, remark.id);
  }

  private void displayEditDialog(String emotion, String say, long remarkId) {

    EditDialogBinding binding = DataBindingUtil
        .inflate(LayoutInflater.from(this), R.layout.edit_dialog, null, false);
    AlertDialog.Builder builder = new Builder(this);
    builder.setView(binding.getRoot());

    String emotionStr;
    if (isDeleteMode && remarkId != 0L) {
      binding.editDialog.setVisibility(View.GONE);
      emotionStr = say + "\nを削除しますか？";
      builder.setMessage(emotionStr);
    } else {
      binding.editDialog.setVisibility(View.VISIBLE);
      String emotionPostFix = remarkId == 0L ? "のセリフを入力" : "のセリフを編集";
      emotionStr = Utility.getEmotionString(emotion) + emotionPostFix;

      binding.editDialog.setText(say);
      builder.setTitle(emotionStr);
    }

    builder.setPositiveButton("OK", (dialog, which) -> {
      if (isDeleteMode) {
        viewModel.deleteRemark(remarkId);
      } else {
        // 入力内容に変化があるかどうか
        String newSay = binding.editDialog.getText().toString();
        if (!newSay.equals(say)) {
          // 新規作成
          if (remarkId == 0L) {
            viewModel.insertRemark(emotion, newSay);
          } else {// 既存のセリフを更新
            viewModel.updateRemark(emotion, newSay, remarkId);
          }
        }
      }
    });
    builder.setNegativeButton("キャンセル", (dialog, which) -> {
    });

    AlertDialog dialog = builder.create();
    dialog.show();
  }

  public void displayRemarks(String emotion) {
    // セリフ追加ボタンを切替
    selectedEmotion = emotion;
    String btnText = Utility.getEmotionString(emotion) + "のセリフを追加する";
    binding.btnAddRemark.setText(btnText);

    // 表示するセリフリストを切替
    viewModel.getRemarksByEmotion(emotion).observe(this, remarkList -> {
      if (remarkList != null) {
        adapter.replaceWithDiffUtil(remarkList);
      } else {
        adapter.replaceWithDiffUtil(Collections.emptyList());
      }
    });
  }

  private String selectedEmotion = "JOY";

  public void addRemark() {
    displayEditDialog(selectedEmotion, "", 0L);
  }
}
