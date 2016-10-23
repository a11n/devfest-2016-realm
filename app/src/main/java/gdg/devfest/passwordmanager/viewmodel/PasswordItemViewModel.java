package gdg.devfest.passwordmanager.viewmodel;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import gdg.devfest.passwordmanager.framework.Navigator;
import gdg.devfest.passwordmanager.model.Password;
import java.util.ArrayList;
import java.util.List;

public class PasswordItemViewModel implements ViewModel {
  private final Navigator navigator;

  public final ObservableInt id;
  public final ObservableField<String> icon;
  public final ObservableField<String> name;
  public final ObservableField<String> userName;

  PasswordItemViewModel(Navigator navigator, int id, String icon, String name, String username) {
    this.navigator = navigator;
    this.id = new ObservableInt(id);
    this.icon = new ObservableField<>(icon);
    this.name = new ObservableField<>(name);
    this.userName = new ObservableField<>(username);
  }

  public static PasswordItemViewModel of(Password password, Navigator navigator) {
    return new PasswordItemViewModel(navigator, password.getId(), password.getIcon(),
        password.getName(), password.getUserName());
  }

  @NonNull
  static List<PasswordItemViewModel> toViewModels(List<Password> entities, Navigator navigator) {
    List<PasswordItemViewModel> viewModels = new ArrayList<>(entities.size());
    for (Password password : entities) {
      viewModels.add(PasswordItemViewModel.of(password, navigator));
    }
    return viewModels;
  }

  public void navigateToPasswordDetails() {
    navigator.startReadPassword(id.get());
  }
}
