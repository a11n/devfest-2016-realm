package gdg.devfest.passwordmanager.framework;

import android.databinding.ViewDataBinding;
import android.support.annotation.CallSuper;
import gdg.devfest.passwordmanager.BR;
import gdg.devfest.passwordmanager.viewmodel.ViewModel;

public abstract class PasswordManagerActivity<B extends ViewDataBinding, VM extends ViewModel>
    extends ToolbarActivity<B, VM> {

  @CallSuper @Override protected void onInitBinding() {
    binding.setVariable(BR.viewModel, viewModel);
  }
}
