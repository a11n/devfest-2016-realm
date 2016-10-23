package gdg.devfest.passwordmanager.model;

import android.support.annotation.NonNull;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PasswordInteractorTest {
  private Realm realm;
  private PasswordInteractor interactor;

  @Before public void setUp() throws Exception {
    RealmConfiguration config =
        new RealmConfiguration.Builder().inMemory().name("test-realm").build();
    realm = Realm.getInstance(config);

    interactor = new PasswordInteractor(realm);
  }

  @After public void tearDown() throws Exception {
    realm.close();
  }

  @Test public void when_readPasswords_should_returnPasswords() throws Exception {
    List<Password> expected = createDummyPasswords();
    realm.executeTransaction(realm1 -> realm1.copyToRealm(expected));

    List<Password> actual = interactor.readPasswords();

    assertThat(actual.get(0), equalTo(expected.get(0)));
  }


  @Test public void when_readPassword_should_returnPassword() throws Exception {
    Password expected = createDummyPassword();
    realm.executeTransaction(realm1 -> realm1.copyToRealm(expected));

    Password actual = interactor.readPassword(1);

    assertThat(actual, equalTo(expected));
  }

  @NonNull private List<Password> createDummyPasswords() {
    Password password = createDummyPassword();

    return Collections.singletonList(password);
  }

  @NonNull private Password createDummyPassword() {
    return new Password(1, "icon", "name", "userName", "password", Collections.EMPTY_LIST);
  }
}
