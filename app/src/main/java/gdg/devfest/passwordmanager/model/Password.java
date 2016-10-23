package gdg.devfest.passwordmanager.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import java.util.List;

public class Password extends RealmObject {
  @PrimaryKey private int id;
  private String icon;
  private String name;
  private String userName;
  private String password;
  private RealmList<CustomField> customFields;

  public Password() {
  }

  public Password(int id, String icon, String name, String userName, String password,
      List<CustomField> customFields) {
    this.id = id;
    this.icon = icon;
    this.name = name;
    this.userName = userName;
    this.password = password;
    this.customFields = new RealmList<>();
    this.customFields.addAll(customFields);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public RealmList<CustomField> getCustomFields() {
    return customFields;
  }

  public void setCustomFields(RealmList<CustomField> customFields) {
    this.customFields = customFields;
  }

  //Custom equals is necessary since Realm returns proxy objects
  @Override public boolean equals(Object obj) {
    if (!(obj instanceof Password)) return false;

    Password password = (Password) obj;

    //TODO: verify equality of CustomFields

    return this.getId() == password.getId() && this.getIcon().equals(password.getIcon())
        && this.getName().equals(password.getName()) && this.getUserName()
        .equals(password.getUserName()) && this.getPassword().equals(password.getPassword());
  }

  //TODO: hashCode
}
