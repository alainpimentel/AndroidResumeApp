package alainp.me.alainresume.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import alainp.me.alainresume.R;
import alainp.me.alainresume.adapters.ViewPagerAdapter;
import alainp.me.alainresume.ui.fragments.ProjectsFragment;
import alainp.me.alainresume.ui.fragments.SkillsFragment;

/**
 * Created by alain on 6/10/2015.
 */
public class ProjectsSkillsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects_skills);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager viewPager =(ViewPager) findViewById(R.id.viewpager);
        if(viewPager != null) {
            setupViewPager(viewPager);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
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

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new ProjectsFragment(), "Projects");
        viewPagerAdapter.addFragment(new SkillsFragment(), "Skills");
        viewPager.setAdapter(viewPagerAdapter);

    }
}
