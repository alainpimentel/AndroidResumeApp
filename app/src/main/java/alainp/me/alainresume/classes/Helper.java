package alainp.me.alainresume.classes;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by alain on 6/9/2015.
 */
public class Helper {

//    public static void openPlayStore(Activity activity, String appName) {
//        Intent intent = new Intent(
//                Intent.ACTION_VIEW,
//                Uri.parse(appName));
//        if (intent.resolveActivity(activity.getPackageManager()) != null) {
//            activity.startActivity(intent);
//        }
//        else {
//            // GooglePlay is not installed, then open browser
//            String playStoreUrl =
//        }
//    }

    /**
     * Opens the device's browser to the passed url
     * @param activity the calling activity
     * @param url the url to view
     */
    public static void openBrowser(Activity activity, String url) {
        final Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(Intent.createChooser(browserIntent, null));
    }

    public static void openPhoneDialer(Activity activity, String phoneNumber) {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse("tel:" + phoneNumber));
        activity.startActivity(phoneIntent);
    }

    public static String geStringByResId(Activity activity, int id) {
        return activity.getString(id);
    }
}
