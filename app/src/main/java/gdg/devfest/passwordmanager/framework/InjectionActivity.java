package gdg.devfest.passwordmanager.framework;

import android.os.Bundle;
import android.support.annotation.Nullable;

class InjectionActivity extends RealmActivity {
  private Injector injector;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    injector = (Injector) getApplication();

    super.onCreate(savedInstanceState);
  }

  protected Injector inject() {
    return injector;
  }
}
