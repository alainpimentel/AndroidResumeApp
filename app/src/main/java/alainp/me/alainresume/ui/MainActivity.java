package alainp.me.alainresume.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;

import alainp.me.alainresume.R;
import alainp.me.alainresume.classes.Helper;

/** TODO
 * - Add resume to links, and also to my blog for download
 * - Add functionality to plus button: add my contact to the device's contact
 * - Add skills
 * - Add projects
 * - Add education
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    private Helper mHelper;
    private RelativeLayout mRelativeLayoutPhone;
    private RelativeLayout mRelativeLayoutEmail;
    private RelativeLayout mRelativeLayoutAddress;
    private RelativeLayout mRelativeLayoutGithub;
    private RelativeLayout mRelativeLayoutLinkedin;
    private RelativeLayout mRelativeLayoutBlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getResources().getString(R.string.my_name));

        loadBackImage();

        mHelper = new Helper();

        // Layouts and other xml elements
        mRelativeLayoutAddress = (RelativeLayout) findViewById(R.id.relativelayout_address);
        mRelativeLayoutAddress.setOnClickListener(this);
        MaterialRippleLayout.
                on(mRelativeLayoutAddress).rippleColor(Color.BLUE).rippleAlpha(0.2f).create();
        mRelativeLayoutPhone = (RelativeLayout) findViewById(R.id.relativelayout_phone);
        mRelativeLayoutPhone.setOnClickListener(this);
        MaterialRippleLayout.
                on(mRelativeLayoutPhone).rippleColor(Color.BLUE).rippleAlpha(0.2f).create();
        mRelativeLayoutEmail = (RelativeLayout) findViewById(R.id.relativelayout_email);
        mRelativeLayoutEmail.setOnClickListener(this);
        MaterialRippleLayout.
                on(mRelativeLayoutEmail).rippleColor(Color.BLUE).rippleAlpha(0.2f).create();
        mRelativeLayoutGithub = (RelativeLayout) findViewById(R.id.relativelayout_github);
        mRelativeLayoutGithub.setOnClickListener(this);
        MaterialRippleLayout.
                on(mRelativeLayoutGithub).rippleColor(Color.BLUE).rippleAlpha(0.2f).create();
        mRelativeLayoutLinkedin = (RelativeLayout) findViewById(R.id.relativelayout_linkedin);
        mRelativeLayoutLinkedin.setOnClickListener(this);
        MaterialRippleLayout.
                on(mRelativeLayoutLinkedin).rippleColor(Color.BLUE).rippleAlpha(0.2f).create();
        mRelativeLayoutBlog = (RelativeLayout) findViewById(R.id.relativelayout_blog);
        mRelativeLayoutBlog.setOnClickListener(this);
        MaterialRippleLayout.
                on(mRelativeLayoutBlog).rippleColor(Color.BLUE).rippleAlpha(0.2f).create();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.relativelayout_phone:
               mHelper.openPhoneDialer(this, getString(R.string.phone_number_uri));
                break;
            case R.id.relativelayout_email:
                mHelper.openEmail(this);
                break;
            case R.id.relativelayout_address:
                mHelper.openMaps(this);
                break;
            case R.id.relativelayout_github:
                mHelper.openBrowser(this, getString(R.string.link_github_url));
                break;
            case R.id.relativelayout_linkedin:
                mHelper.openBrowser(this, getString(R.string.link_linkedin_url));
                break;
            case R.id.relativelayout_blog:
                mHelper.openBrowser(this, getString(R.string.link_blog_url));
                break;
            default:
                break;
        }
    }

    private void loadBackImage() {
        final ImageView  iv_my_pic = (ImageView) findViewById(R.id.iv_profile_pic);
        Glide.with(this).load(R.drawable.profile_pic).centerCrop().into(iv_my_pic);
    }
}
