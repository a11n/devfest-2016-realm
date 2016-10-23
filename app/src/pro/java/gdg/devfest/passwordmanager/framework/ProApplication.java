package gdg.devfest.passwordmanager.framework;

import gdg.devfest.passwordmanager.model.LoginInteractor;
import io.realm.Realm;
import io.realm.User;

public class ProApplication extends PasswordManagerApplication {
  @Override protected void initRealm() {
    Realm.init(this);

    User user = User.currentUser();

    if (user != null) new LoginInteractor().setRealmSyncConfiguration(user);
  }
}
