package alainp.me.alainresume.ui.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
 * - Add skills
 * - Add projects: Add language pic and project pic. Add all projects
 * - Add experience tab
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
    private RelativeLayout mRelativeLayoutResume;
    private RelativeLayout mRelativeLayoutProjects;
//    private RelativeLayout mRelativeLayoutSkills;
    private FloatingActionButton mFloatingButtonAddContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getResources().getString(R.string.my_name));

        loadBackImage(R.id.iv_profile_pic);

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
        mRelativeLayoutResume = (RelativeLayout) findViewById(R.id.relativelayout_resume);
        mRelativeLayoutResume.setOnClickListener(this);
        MaterialRippleLayout.
                on(mRelativeLayoutResume).rippleColor(Color.BLUE).rippleAlpha(0.2f).create();
        mRelativeLayoutProjects = (RelativeLayout) findViewById(R.id.relativelayout_projects);
        mRelativeLayoutProjects.setOnClickListener(this);
        MaterialRippleLayout.
                on(mRelativeLayoutProjects).rippleColor(Color.BLUE).rippleAlpha(0.2f).create();
//        mRelativeLayoutSkills = (RelativeLayout) findViewById(R.id.relativelayout_skills);
//        mRelativeLayoutSkills.setOnClickListener(this);
//        MaterialRippleLayout.
//                on(mRelativeLayoutSkills).rippleColor(Color.BLUE).rippleAlpha(0.2f).create();
        // Floating Action Button
        mFloatingButtonAddContact =
                (FloatingActionButton) findViewById(R.id.floatingbutton_add_contact);
        mFloatingButtonAddContact.setOnClickListener(this);
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
            case R.id.relativelayout_resume:
                mHelper.openBrowser(this, getString(R.string.link_resume_url));
                break;
            case R.id.floatingbutton_add_contact:
                if(!mHelper.contactExists(this, getString(R.string.phone_number_uri))) {
                    showAlertDialog(
                            getString(R.string.add_contact_title),
                            getString(R.string.add_contact_message),
                            getString(R.string.add_contact_positive),
                            getString(R.string.add_contact_negative));
                }
                else {
                    Snackbar.make(view, getString(R.string.add_contact_exists_title), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                break;
            case R.id.relativelayout_projects:
                startActivity(new Intent(this, ProjectsSkillsActivity.class));
                break;
            default:
                break;
        }
    }

//    public void fabClicked(View v) {
//        switch(v.getId()) {
//            case R.id.floatingbutton_add_contact:
//                showAlertDialog("Suck Dick", "Do you really wanna suck dick, Hai?", "yes", "no");
//                break;
//        }
//    }

    private void showAlertDialog(String title, String message, String posButton, String negButton) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this, R.style. AppCompatAlertDialogStyle);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(posButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, "nigga here");
                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.EMAIL, getString(R.string.email))
                        .putExtra(
                                ContactsContract.Intents.Insert.EMAIL_TYPE,
                                ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                        .putExtra(
                                ContactsContract.Intents.Insert.PHONE,
                                getString(R.string.phone_number_uri))
                        .putExtra(
                                ContactsContract.Intents.Insert.PHONE_TYPE,
                                ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                        .putExtra(
                                ContactsContract.Intents.Insert.NAME,
                                getString(R.string.my_name));

                startActivity(intent);
            }
        });
        builder.setNegativeButton(negButton, null);
        builder.show();
    }



}
