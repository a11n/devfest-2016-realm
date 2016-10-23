package gdg.devfest.passwordmanager.framework;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import gdg.devfest.passwordmanager.R;
import gdg.devfest.passwordmanager.viewmodel.ViewModel;

abstract class ToolbarActivity<B extends ViewDataBinding, VM extends ViewModel>
    extends DataBindingActivity<B, VM> {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }
}
