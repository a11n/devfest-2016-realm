package gdg.devfest.passwordmanager.framework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import gdg.devfest.passwordmanager.view.CustomFieldDialog;
import gdg.devfest.passwordmanager.view.PasswordCreateActivity;
import gdg.devfest.passwordmanager.view.PasswordReadActivity;
import gdg.devfest.passwordmanager.view.PasswordUpdateActivity;
import pl.coreorb.selectiondialogs.dialogs.IconSelectDialog;

public class Navigator {
  protected final AppCompatActivity activity;

  public Navigator(AppCompatActivity activity) {
    this.activity = activity;
  }

  public void startCreatePassword() {
    activity.startActivity(new Intent(activity, PasswordCreateActivity.class));
  }

  public void finish() {
    activity.finish();
  }

  public void startReadPassword(int passwordId) {
    activity.startActivity(
        new Intent(activity, PasswordReadActivity.class).putExtra("id", passwordId));
  }

  public void startUpdatePassword(int passwordId) {
    activity.startActivity(
        new Intent(activity, PasswordUpdateActivity.class).putExtra("id", passwordId));
  }

  public void startChooseIcon(IconSelectDialog.OnIconSelectedListener onIconSelectedListener) {
    new IconSelectDialog.Builder(activity).setIcons(Icons.ALL)
        .setTitle("Choose icon")
        .setSortIconsByName(true)
        .setOnIconSelectedListener(onIconSelectedListener)
        .build()
        .show(activity.getSupportFragmentManager(), "icons");
  }

  public void startCreateCustomField(
      CustomFieldDialog.OnCustomFieldSubmitListener customFieldSubmitListener) {
    CustomFieldDialog.newInstance("Create custom field", "", "", customFieldSubmitListener, null)
        .show(activity.getSupportFragmentManager(), "field");
  }

  public void startUpdateCustomField(String name, String value,
      CustomFieldDialog.OnCustomFieldSubmitListener customFieldSubmitListener,
      CustomFieldDialog.OnCustomFieldDeleteListener customFieldDeleteListener) {
    CustomFieldDialog.newInstance("Update custom field", name, value, customFieldSubmitListener,
        customFieldDeleteListener).show(activity.getSupportFragmentManager(), "field");
  }
}
