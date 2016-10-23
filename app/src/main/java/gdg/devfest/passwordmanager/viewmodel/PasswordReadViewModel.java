package gdg.devfest.passwordmanager.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import gdg.devfest.passwordmanager.framework.Navigator;
import gdg.devfest.passwordmanager.model.Password;
import gdg.devfest.passwordmanager.model.PasswordInteractor;

public class PasswordReadViewModel implements ViewModel {
  private final Navigator navigator;
  private final PasswordInteractor interactor;
  private final int id;

  public final ObservableField<String> title;
  public final ObservableField<String> icon;
  public final ObservableField<String> username;
  public final ObservableField<String> password;
  public final ObservableBoolean displayPassword;
  public final ObservableList<CustomFieldViewModel> customFields;

  private Password realmPassword;

  public PasswordReadViewModel(Navigator navigator, PasswordInteractor interactor, int id) {
    this.navigator = navigator;
    this.interactor = interactor;
    this.id = id;

    this.title = new ObservableField<>();
    this.icon = new ObservableField<>();
    this.username = new ObservableField<>();
    this.password = new ObservableField<>();
    this.displayPassword = new ObservableBoolean(false);
    this.customFields = new ObservableArrayList<>();

    realmPassword = interactor.readPassword(id);
    realmPassword.addChangeListener(this::updateView);

    updateView(realmPassword);
  }

  private void updateView(Password password) {
    this.title.set(password.getName());
    this.icon.set(password.getIcon());
    this.username.set(password.getUserName());
    this.password.set(password.getPassword());
    this.customFields.clear();
    this.customFields.addAll(CustomFieldViewModel.toViewModels(password.getCustomFields(), null));
  }

  public void updatePassword() {
    navigator.startUpdatePassword(id);
  }

  public void deletePassword() {
    interactor.deletePassword(realmPassword);
    navigator.finish();
  }
}
