package alainp.me.alainresume.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alainp.me.alainresume.R;

/**
 * Created by alain on 6/11/2015.
 */
public class ExperienceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        NestedScrollView nsv = (NestedScrollView) inflater.inflate(
                R.layout.fragment_experience, container, false);
        return nsv;
    }

}
