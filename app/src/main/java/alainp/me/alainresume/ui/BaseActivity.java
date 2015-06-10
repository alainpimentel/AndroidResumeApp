package alainp.me.alainresume.ui;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by alain on 6/9/2015.
 */
public class BaseActivity extends AppCompatActivity {
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG);
    }
}
