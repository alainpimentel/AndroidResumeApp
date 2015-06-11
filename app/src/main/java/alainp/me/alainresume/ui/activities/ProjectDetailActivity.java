package alainp.me.alainresume.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import alainp.me.alainresume.R;

/**
 * Created by alain on 6/10/2015.
 */
public class ProjectDetailActivity extends BaseActivity {
    public static final String EXTRA_NAME = "project_detail";

    private String mTitle;
    private String mLanguage;
    private String mTechnologies;
    private String mDescription;
    private String mOwner;
    private TextView mTextViewDescription;
    private TextView mTextViewTechnologies;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_project_detail);

        Intent intent = getIntent();
        final ArrayList<String> projectInfo = intent.getStringArrayListExtra(EXTRA_NAME);
        mTitle = projectInfo.get(0);
        mLanguage = projectInfo.get(1);
        mTechnologies = projectInfo.get(2);
        mDescription = projectInfo.get(3);
        mOwner = projectInfo.get(4);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(mTitle);

        loadBackImage(R.id.iv_profile_pic);

        mTextViewDescription = (TextView) findViewById(R.id.tv_project_description);
        mTextViewDescription.setText(mDescription);

        mTextViewTechnologies = (TextView) findViewById(R.id.tv_project_technologies);
        mTextViewTechnologies.setText(mTechnologies);
    }
}
