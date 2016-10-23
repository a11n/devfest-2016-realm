package gdg.devfest.passwordmanager.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import gdg.devfest.passwordmanager.framework.ProNavigator;
import gdg.devfest.passwordmanager.model.LoginInteractor;
import io.realm.User;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginViewModel implements ViewModel {
  private final LoginInteractor interactor;
  private final ProNavigator navigator;

  public final ObservableField<String> email;
  public final ObservableField<String> password;
  public final ObservableField<String> passwordRepeat;
  public final ObservableBoolean inProgress;

  public LoginViewModel(LoginInteractor interactor, ProNavigator navigator) {
    this.interactor = interactor;
    this.navigator = navigator;

    email = new ObservableField<>();
    password = new ObservableField<>();
    passwordRepeat = new ObservableField<>();
    inProgress = new ObservableBoolean();
  }

  public void signIn() {
    inProgress.set(true);

    interactor.signIn(email.get(), password.get())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::onAuthenticated);
  }

  public void signUp() {
    inProgress.set(true);

    interactor.signUp(email.get(), password.get())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::onAuthenticated);
  }

  private void onAuthenticated(User user){
    inProgress.set(false);

    interactor.setRealmSyncConfiguration(user);

    navigator.startPasswordList();
    navigator.finish();
  }
}
