package gdg.devfest.passwordmanager.model;

import io.realm.RealmObject;

public class CustomField extends RealmObject {
  private String name;
  private String value;

  public CustomField() {}

  public CustomField(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
