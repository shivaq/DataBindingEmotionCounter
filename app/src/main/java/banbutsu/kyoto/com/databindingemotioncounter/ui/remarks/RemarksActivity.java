package banbutsu.kyoto.com.databindingemotioncounter.ui.remarks;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import banbutsu.kyoto.com.databindingemotioncounter.R;
import banbutsu.kyoto.com.databindingemotioncounter.data.local.model.RemarkEntry;
import banbutsu.kyoto.com.databindingemotioncounter.databinding.ActivityListBinding;
import banbutsu.kyoto.com.databindingemotioncounter.ui.base.BaseActivity;
import java.util.Collections;
import javax.inject.Inject;
import timber.log.Timber;

public class RemarksActivity extends BaseActivity implements RemarkRvAdapter.RemarkRvCallback {

  /******************************** Inject ****************************************/
  @Inject
  Context context;


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
  }

  @Override
  public void onClick(RemarkEntry remark) {

  }

  public void displayRemarks(String emotion) {
    Timber.d("RemarksActivity:displayRemarks: ");
    viewModel.getRemarksByEmotion(emotion).observe(this, remarkList -> {
      if (remarkList != null) {
        adapter.replaceWithDiffUtil(remarkList);
      } else {
        adapter.replaceWithDiffUtil(Collections.emptyList());
      }
    });
  }
}
