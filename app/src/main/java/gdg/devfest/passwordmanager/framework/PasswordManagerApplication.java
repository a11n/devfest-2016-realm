package gdg.devfest.passwordmanager.framework;

import android.app.Application;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class PasswordManagerApplication extends Application implements Injector {
  @Override public void onCreate() {
    super.onCreate();

    initRealm();

    initInjections();
  }

  protected void initRealm() {
    Realm.init(this);
    RealmConfiguration config =
        new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
    Realm.setDefaultConfiguration(config);
  }

  private void initInjections() {

  }
}
