package gdg.devfest.passwordmanager.model;

import io.realm.Realm;
import io.realm.RealmResults;
import java.util.List;

public class PasswordInteractor {
  private final Realm realm;

  public PasswordInteractor(Realm realm) {
    this.realm = realm;
  }

  public RealmResults<Password> readPasswords() {
    return realm.where(Password.class).findAll();
  }

  public void createPassword(String icon, String name, String userName, String password,
      List<CustomField> customFields) {
    Password passwordEntity = new Password(id(), icon, name, userName, password, customFields);
    realm.executeTransaction(realm1 -> realm1.copyToRealm(passwordEntity));
  }

  public Password readPassword(int id) {
    return realm.where(Password.class).equalTo("id", id).findFirst();
  }

  public void updatePassword(Password realmPassword, String icon, String name, String userName,
      String password, List<CustomField> customFields) {
    realm.executeTransaction(realm1 -> {
      realmPassword.setIcon(icon);
      realmPassword.setName(name);
      realmPassword.setUserName(userName);
      realmPassword.setPassword(password);
      realmPassword.getCustomFields().deleteAllFromRealm();
      realmPassword.getCustomFields().addAll(customFields);
    });
  }

  public void deletePassword(Password password) {
    realm.executeTransaction(realm1 -> {
      password.getCustomFields().deleteAllFromRealm();
      password.deleteFromRealm();
    });
  }

  private int id() {
    Number number = realm.where(Password.class).max("id");
    return number != null ? number.intValue() + 1 : 0;
  }
}
