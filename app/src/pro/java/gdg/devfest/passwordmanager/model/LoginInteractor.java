package gdg.devfest.passwordmanager.model;

import android.support.annotation.NonNull;
import gdg.devfest.passwordmanager.BuildConfig;
import io.realm.Credentials;
import io.realm.Realm;
import io.realm.SyncConfiguration;
import io.realm.User;
import rx.Single;

public class LoginInteractor {
  private static final String AUTH_URL = "http://" + BuildConfig.REALM + "/auth";
  private static final String SERVER_URL = "realm://" + BuildConfig.REALM + "/~/default";

  public Single<User> signIn(String userName, String password) {
    return login(userName, password, false);
  }

  public Single<User> signUp(String userName, String password) {
    return login(userName, password, true);
  }

  public void setRealmSyncConfiguration(User user) {
    SyncConfiguration configuration = new SyncConfiguration.Builder(user, SERVER_URL).build();
    Realm.setDefaultConfiguration(configuration);
  }

  @NonNull private Single<User> login(String userName, String password, boolean createUser) {
    return Single.create(singleSubscriber -> {
      try {
        Credentials credentials = Credentials.usernamePassword(userName, password, createUser);
        User user = User.login(credentials, AUTH_URL);
        singleSubscriber.onSuccess(user);
      } catch (Exception e) {
        singleSubscriber.onError(e);
      }
    });
  }
}
