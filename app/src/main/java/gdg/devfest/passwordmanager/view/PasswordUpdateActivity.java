package gdg.devfest.passwordmanager.view;

import android.os.Bundle;
import gdg.devfest.passwordmanager.databinding.PasswordUpdateActivityBinding;
import gdg.devfest.passwordmanager.framework.Navigator;
import gdg.devfest.passwordmanager.framework.PasswordManagerActivity;
import gdg.devfest.passwordmanager.model.PasswordInteractor;
import gdg.devfest.passwordmanager.viewmodel.PasswordUpdateViewModel;

public class PasswordUpdateActivity
    extends PasswordManagerActivity<PasswordUpdateActivityBinding, PasswordUpdateViewModel> {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override protected void onInitBinding() {
    super.onInitBinding();

    setTitle(viewModel.name.get());
  }

  @Override protected PasswordUpdateViewModel createViewModel() {
    int id = getIntent().getIntExtra("id", 0);
    return new PasswordUpdateViewModel(new Navigator(this), new PasswordInteractor(realm),
        id);
  }
}
