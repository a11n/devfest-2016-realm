package gdg.devfest.passwordmanager.framework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import gdg.devfest.passwordmanager.view.PasswordListActivity;

public class ProNavigator extends Navigator {
  public ProNavigator(AppCompatActivity activity) {
    super(activity);
  }

  public void startPasswordList() {
    activity.startActivity(new Intent(activity, PasswordListActivity.class));
  }
}
