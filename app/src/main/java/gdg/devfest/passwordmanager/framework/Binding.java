package gdg.devfest.passwordmanager.framework;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import java.util.List;

public class Binding {
  @BindingAdapter({ "data", "itemLayout" })
  public static void adapt(RecyclerView recyclerView, List<?> data, int layoutResourceId) {
    recyclerView.setAdapter(new DataBindingAdapter(data, layoutResourceId));
  }

  @BindingAdapter("setup") public static void setup(RecyclerView recyclerView, String options) {
    String[] opts = options.split("\\|");

    for (String option : opts) {
      switch (option) {
        case "fixed":
          recyclerView.setHasFixedSize(true);
          break;
        case "linear":
          recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
          break;
        case "divider":
          recyclerView.addItemDecoration(new Divider(recyclerView.getContext()));
          break;
        default:
          throw new IllegalArgumentException(String.format("Option '%s' is unknown", option));
      }
    }
  }

  @BindingAdapter({"android:src"})
  public static void setImageViewResource(ImageView imageView, int resId) {
    imageView.setImageResource(resId);
  }

  @BindingConversion
  public static int booleanToVisibility(boolean visible) {
    return visible ? View.VISIBLE : View.GONE;
  }
}
