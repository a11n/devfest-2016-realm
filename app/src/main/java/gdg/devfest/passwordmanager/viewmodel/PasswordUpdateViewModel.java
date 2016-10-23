package gdg.devfest.passwordmanager.viewmodel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.util.Base64;
import gdg.devfest.passwordmanager.framework.Navigator;
import gdg.devfest.passwordmanager.model.Password;
import gdg.devfest.passwordmanager.model.PasswordInteractor;
import java.security.SecureRandom;
import pl.coreorb.selectiondialogs.data.SelectableIcon;

public class PasswordUpdateViewModel implements ViewModel {
  private final Navigator navigator;
  private final PasswordInteractor interactor;
  private final CustomFieldViewModel.OnUpdateListener customFieldUpdateListener;

  private final Password realmPassword;

  public ObservableField<String> icon;
  public ObservableField<String> name;
  public ObservableField<String> userName;
  public ObservableField<String> password;
  public final ObservableList<CustomFieldViewModel> customFields;

  public PasswordUpdateViewModel(Navigator navigator, PasswordInteractor interactor, int id) {
    this.navigator = navigator;
    this.interactor = interactor;
    this.customFieldUpdateListener = buildCustomFieldUpdateListener();

    realmPassword = interactor.readPassword(id);

    icon = new ObservableField<>(realmPassword.getIcon());
    name = new ObservableField<>(realmPassword.getName());
    userName = new ObservableField<>(realmPassword.getUserName());
    password = new ObservableField<>(realmPassword.getPassword());
    customFields = new ObservableArrayList<>();
    customFields.addAll(CustomFieldViewModel.toViewModels(realmPassword.getCustomFields(),
        customFieldUpdateListener));
  }

  public void chooseIcon() {
    navigator.startChooseIcon(this::onIconSelected);
  }

  private void onIconSelected(SelectableIcon selectableIcon) {
    icon.set(selectableIcon.getId());
  }

  public void generatePassword() {
    byte[] pw = new byte[8];
    new SecureRandom().nextBytes(pw);

    password.set(new String(Base64.encode(pw,Base64.NO_WRAP)));
  }

  public void addCustomField() {
    navigator.startCreateCustomField((name, value) -> customFields.add(
        new CustomFieldViewModel(name, value, customFieldUpdateListener)));
  }

  public void updatePassword() {
    interactor.updatePassword(realmPassword, icon.get(), name.get(), userName.get(), password.get(),
        CustomFieldViewModel.toEntities(customFields));

    navigator.finish();
  }

  private CustomFieldViewModel.OnUpdateListener buildCustomFieldUpdateListener() {
    return new CustomFieldViewModel.OnUpdateListener() {
      @Override public void update(CustomFieldViewModel customFieldViewModel) {
        navigator.startUpdateCustomField(customFieldViewModel.name.get(),
            customFieldViewModel.value.get(),
            (name, value) -> handleSubmit(customFieldViewModel, name, value),
            () -> handleDelete(customFieldViewModel));
      }

      private void handleSubmit(CustomFieldViewModel customFieldViewModel, String name,
          String value) {
        customFieldViewModel.name.set(name);
        customFieldViewModel.value.set(value);
      }

      private void handleDelete(CustomFieldViewModel customFieldViewModel) {
        customFields.remove(customFieldViewModel);
      }
    };
  }
}
