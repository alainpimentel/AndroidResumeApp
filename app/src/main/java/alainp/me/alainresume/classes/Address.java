package alainp.me.alainresume.classes;

import android.content.Context;

import alainp.me.alainresume.R;

/**
 * Created by alain on 6/5/2015.
 */
public class Address {

    private String street;
    private String street2;
    private String city;
    private String state;
    private String zip;

    public Address(Context context) {
        street = context.getResources().getString(R.string.ad_street);
        street2 = context.getResources().getString(R.string.ad_street2);
        city = context.getResources().getString(R.string.ad_city);
        state = context.getResources().getString(R.string.ad_state);
        zip = context.getResources().getString(R.string.ad_zip);
    }

    public String getStreet() {
        return street;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getAddressString() {
        return street + " \n" + street2 + "\n" + city + ", " + state + zip;
    }

}
