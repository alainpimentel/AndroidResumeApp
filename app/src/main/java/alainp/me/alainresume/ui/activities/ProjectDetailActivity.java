package alainp.me.alainresume.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import alainp.me.alainresume.R;
import alainp.me.alainresume.classes.Helper;

/**
 * Created by alain on 6/10/2015.
 */
public class ProjectDetailActivity extends BaseActivity implements  View.OnClickListener {
    public static final String EXTRA_NAME = "project_detail";

    private String mTitle;
    private String mInfo;
    private String mLanguage;
    private String mTechnologies;
    private String mDescription;
    private String mOwner;
    private String mLink;
    private TextView mTextViewInfo;
    private TextView mTextViewDescription;
    private TextView mTextViewTechnologies;
    private FloatingActionButton mFloatingButtonLink;
    private Helper mHelper;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_project_detail);

        Intent intent = getIntent();
        final ArrayList<String> projectInfo = intent.getStringArrayListExtra(EXTRA_NAME);
        mTitle = projectInfo.get(0);
        mInfo = projectInfo.get(1);
        mLanguage = projectInfo.get(2);
        mTechnologies = projectInfo.get(3);
        mDescription = projectInfo.get(4);
        mOwner = projectInfo.get(5);
        mLink = projectInfo.get(6);

        mHelper = new Helper();

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(mTitle);

        loadBackImage(R.id.iv_project_pic, R.drawable.project_rss);

        mTextViewDescription = (TextView) findViewById(R.id.tv_project_description);
        mTextViewDescription.setText(mDescription);

        mTextViewTechnologies = (TextView) findViewById(R.id.tv_project_technologies);
        mTextViewTechnologies.setText(mTechnologies);

        mTextViewInfo = (TextView) findViewById(R.id.tv_project_info);
        mTextViewInfo.setText(mInfo);

        mFloatingButtonLink = (FloatingActionButton) findViewById(R.id.floatingbutton_link);
        if(mLink.equals("")) {
            mFloatingButtonLink.setVisibility(View.INVISIBLE);
        }
        else {
            mFloatingButtonLink.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.floatingbutton_link:
                mHelper.openBrowser(this, mLink);
                break;
            default:
                break;
        }
    }
}
