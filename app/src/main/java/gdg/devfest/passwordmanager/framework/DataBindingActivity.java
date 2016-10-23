package gdg.devfest.passwordmanager.framework;

import android.app.Activity;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import gdg.devfest.passwordmanager.viewmodel.ViewModel;

abstract class DataBindingActivity<B extends ViewDataBinding, VM extends ViewModel>
    extends ViewModelActivity<VM> {
  protected B binding;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    onLoadBinding();

    onInitBinding();
  }

  protected void onLoadBinding() {
    int layoutId = resolveLayoutIdByActivityName(this);
    binding = DataBindingUtil.setContentView(this, layoutId);
  }

  protected abstract void onInitBinding();

  private int resolveLayoutIdByActivityName(Activity activity) {
    Resources resources = activity.getResources();

    String layoutName = convertCamelCaseToUnderscore(activity.getClass().getSimpleName());
    String packageName = activity.getPackageName();

    return resources.getIdentifier(layoutName, "layout", packageName);
  }

  private String convertCamelCaseToUnderscore(String camelCase) {
    return camelCase.replaceAll("(.)(\\p{Upper})", "$1_$2").toLowerCase();
  }
}
