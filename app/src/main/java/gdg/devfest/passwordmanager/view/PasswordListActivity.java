package gdg.devfest.passwordmanager.view;

import gdg.devfest.passwordmanager.databinding.PasswordListActivityBinding;
import gdg.devfest.passwordmanager.framework.Navigator;
import gdg.devfest.passwordmanager.framework.PasswordManagerActivity;
import gdg.devfest.passwordmanager.model.PasswordInteractor;
import gdg.devfest.passwordmanager.viewmodel.PasswordListViewModel;

public class PasswordListActivity
    extends PasswordManagerActivity<PasswordListActivityBinding, PasswordListViewModel> {

  @Override protected PasswordListViewModel createViewModel() {
    return new PasswordListViewModel(new Navigator(this), new PasswordInteractor(realm));
  }
}
