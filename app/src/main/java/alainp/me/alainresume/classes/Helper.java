package alainp.me.alainresume.classes;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
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

    private void addContact(Activity activity) {
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, activity.getString(R.string.email))
              .putExtra(
                      ContactsContract.Intents.Insert.EMAIL_TYPE,
                      ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                .putExtra(
                    ContactsContract.Intents.Insert.PHONE,
                    activity.getString(R.string.phone_number_uri))
                .putExtra(
                        ContactsContract.Intents.Insert.PHONE_TYPE,
                        ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                .putExtra(
                        ContactsContract.Intents.Insert.NAME,
                        activity.getString(R.string.my_name));
        activity.startActivity(intent);

    }
}
