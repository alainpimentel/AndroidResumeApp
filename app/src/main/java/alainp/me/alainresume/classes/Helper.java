package alainp.me.alainresume.classes;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import alainp.me.alainresume.R;

/**
 * Created by alain on 6/9/2015.
 */
public class Helper {

    /**
     * Opens the device's browser to the passed url
     * @param activity the calling activity
     * @param url the url to view
     */
    public static void openBrowser(Activity activity, String url) {
        final Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        activity.startActivity(Intent.createChooser(browserIntent, null));
    }

    /**
     * Opens the dialer app with my number
     * @param activity the calling activity
     * @param phoneNumber the phone number to call
     */
    public static void openPhoneDialer(Activity activity, String phoneNumber) {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse("tel:" + phoneNumber));
        activity.startActivity(phoneIntent);
    }

    /**
     * Opens the email app with my eamil as the receiver
     * @param activity the calling activity
     */
    public static void openEmail(Activity activity) {
        String email = activity.getString(R.string.email);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:" + email);
        intent.setData(data);
        activity.startActivity(intent);
    }

    /**
     * Opens an installed app, otherwise it opens the browser
     * @param activity the calling activity
     * @param appUrl url of the app
     */
    public static void openInstalledApp(Activity activity, String appUrl) {
        Intent intent = new Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(appUrl));
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(intent);
        }
        else {
            openBrowser(activity, appUrl);
        }
    }

    /**
     * Gets the right url to open Google Maps with directions, calls a function to open it
     * @param activity the calling activity
     */
    public static void openMaps(Activity activity) {
        String addressUrl = "http://maps.google.co.in/maps?q=" +
                activity.getString(R.string.full_address);
        openInstalledApp(activity, addressUrl);
    }

    /**
     * Checks if the given number exists in the contact list
     * Modified from: http://stackoverflow.com/a/15566464/3641665
     * @param activity the calling activity
     * @param number the phone number to check
     * @return boolean indicating if the phone number was found
     */
    public boolean contactExists(Activity activity, String number) {
        Uri lookUpUri = Uri.withAppendedPath(
                ContactsContract.PhoneLookup.CONTENT_FILTER_URI,
                Uri.encode(number));
        String[] mPhoneNumberProjection = {
                ContactsContract.PhoneLookup._ID,
                ContactsContract.PhoneLookup.NUMBER,
                ContactsContract.PhoneLookup.DISPLAY_NAME };
        Cursor cur = activity.getContentResolver().query(
                lookUpUri, mPhoneNumberProjection, null, null, null);
        try {
            if(cur.moveToFirst()) {
                return true;
            }
        } finally {
            if (cur != null) {
                cur.close();
            }
        }
        return false;
    }
}
