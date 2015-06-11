package alainp.me.alainresume.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import alainp.me.alainresume.R;

/**
 * Created by alain on 6/9/2015.
 */
public class BaseActivity extends AppCompatActivity {
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG);
    }

    protected void loadBackImage(int imageId) {
        final ImageView iv_my_pic = (ImageView) findViewById(imageId);
        Glide.with(this).load(R.drawable.profile_pic).centerCrop().into(iv_my_pic);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
