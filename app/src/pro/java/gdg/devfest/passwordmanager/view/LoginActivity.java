package gdg.devfest.passwordmanager.view;

import gdg.devfest.passwordmanager.databinding.LoginActivityBinding;
import gdg.devfest.passwordmanager.framework.PasswordManagerActivity;
import gdg.devfest.passwordmanager.framework.ProNavigator;
import gdg.devfest.passwordmanager.model.LoginInteractor;
import gdg.devfest.passwordmanager.viewmodel.LoginViewModel;

public class LoginActivity extends PasswordManagerActivity<LoginActivityBinding, LoginViewModel> {
  @Override protected LoginViewModel createViewModel() {
    return new LoginViewModel(new LoginInteractor(), new ProNavigator(this));
  }
}
