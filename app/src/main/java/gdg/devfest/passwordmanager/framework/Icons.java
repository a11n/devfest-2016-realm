package gdg.devfest.passwordmanager.framework;

import android.support.annotation.DrawableRes;
import gdg.devfest.passwordmanager.R;
import java.util.ArrayList;
import java.util.Arrays;
import pl.coreorb.selectiondialogs.data.SelectableIcon;

public class Icons {
  public final static ArrayList<SelectableIcon> ALL = new ArrayList<>(
      Arrays.asList(new SelectableIcon("amazon", "Amazon", R.drawable.amazon),
          new SelectableIcon("android", "Android", R.drawable.android),
          new SelectableIcon("bing", "Bing", R.drawable.bing),
          new SelectableIcon("box", "Box", R.drawable.box),
          new SelectableIcon("dribble", "Dribble", R.drawable.dribbble),
          new SelectableIcon("dropbox", "Dropbox", R.drawable.dropbox),
          new SelectableIcon("facebox", "Facebox", R.drawable.facebook),
          new SelectableIcon("flickr", "Flickr", R.drawable.flickr),
          new SelectableIcon("linkedin", "LinkedIn", R.drawable.linkedin),
          new SelectableIcon("medium", "Medium", R.drawable.medium),
          new SelectableIcon("paypal", "PayPal", R.drawable.paypal),
          new SelectableIcon("spotify", "Spotify", R.drawable.spotify),
          new SelectableIcon("twitter", "Twitter", R.drawable.twitter),
          new SelectableIcon("youtube", "YouTube", R.drawable.youtube)));

  public static @DrawableRes int resourceOf(String id) {
    for (SelectableIcon icon : ALL) {
      if (id.equals(icon.getId())) return icon.getDrawableResId();
    }

    return R.drawable.android;
  }
}
