package gdg.devfest.passwordmanager.view;

import android.os.Bundle;
import gdg.devfest.passwordmanager.databinding.PasswordCreateActivityBinding;
import gdg.devfest.passwordmanager.framework.Navigator;
import gdg.devfest.passwordmanager.framework.PasswordManagerActivity;
import gdg.devfest.passwordmanager.model.PasswordInteractor;
import gdg.devfest.passwordmanager.viewmodel.PasswordCreateViewModel;

public class PasswordCreateActivity
    extends PasswordManagerActivity<PasswordCreateActivityBinding, PasswordCreateViewModel> {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override protected PasswordCreateViewModel createViewModel() {
    return new PasswordCreateViewModel(new Navigator(this), new PasswordInteractor(realm));
  }
}
