package gdg.devfest.passwordmanager.framework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import gdg.devfest.passwordmanager.viewmodel.ViewModel;

abstract class ViewModelActivity<VM extends ViewModel> extends InjectionActivity {
  protected VM viewModel;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    viewModel = createViewModel();
  }

  protected abstract VM createViewModel();
}
