package gdg.devfest.passwordmanager.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import gdg.devfest.passwordmanager.framework.Navigator;
import gdg.devfest.passwordmanager.model.Password;
import gdg.devfest.passwordmanager.model.PasswordInteractor;
import io.realm.RealmResults;

public class PasswordListViewModel implements ViewModel {
  private final Navigator navigator;
  private final RealmResults<Password> realmPasswords;

  public ObservableList<PasswordItemViewModel> passwords;

  public PasswordListViewModel(Navigator navigator, PasswordInteractor interactor) {
    this.navigator = navigator;

    passwords = new ObservableArrayList<>();
    realmPasswords = interactor.readPasswords();
    realmPasswords.addChangeListener(this::updateList);

    updateList(realmPasswords);
  }

  public void navigateToCreatePassword() {
    navigator.startCreatePassword();
  }

  private void updateList(RealmResults<Password> realmPasswords) {
    passwords.clear();
    passwords.addAll(PasswordItemViewModel.toViewModels(realmPasswords, navigator));
  }
}
