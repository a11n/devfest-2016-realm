package gdg.devfest.passwordmanager.view;

import android.os.Bundle;
import gdg.devfest.passwordmanager.databinding.PasswordReadActivityBinding;
import gdg.devfest.passwordmanager.framework.Navigator;
import gdg.devfest.passwordmanager.framework.PasswordManagerActivity;
import gdg.devfest.passwordmanager.model.PasswordInteractor;
import gdg.devfest.passwordmanager.viewmodel.PasswordReadViewModel;

public class PasswordReadActivity
    extends PasswordManagerActivity<PasswordReadActivityBinding, PasswordReadViewModel> {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override protected PasswordReadViewModel createViewModel() {
    int id = getIntent().getIntExtra("id", 0);
    return new PasswordReadViewModel(new Navigator(this), new PasswordInteractor(realm), id);
  }
}
