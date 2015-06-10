package alainp.me.alainresume.classes;

import android.content.Context;
import android.provider.Telephony;

import alainp.me.alainresume.R;

/**
 * Created by alain on 6/5/2015.
 */
public class Alain {
    private String firstName;
    private String lastName;
    private Address address;
    private String phone;
    private String email;
    private String introduction;

    public Alain(Context context) {
        firstName = context.getResources().getString(R.string.first_name);
        lastName = context.getResources().getString(R.string.last_name);
        phone = context.getResources().getString(R.string.phone_number);
        email = context.getResources().getString(R.string.email);

        address = new Address(context);
    }

    public Address getAddress() {
        return address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }


}
