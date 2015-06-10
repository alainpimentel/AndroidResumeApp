package alainp.me.alainresume.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import alainp.me.alainresume.R;

public class SkillsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skills, container, false);
        return view;
//        RecyclerView rv = (RecyclerView) inflater.inflate(
//                R.layout.fragment_projects, container, false);
//        //setupRecyclerView(rv);
//        return rv;
    }

}
