package alainp.me.alainresume.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import alainp.me.alainresume.R;
import alainp.me.alainresume.classes.Project;
import alainp.me.alainresume.ui.activities.ProjectDetailActivity;

/**
 * Created by alain on 6/10/2015.
 */
public class ProjectsRecyclerViewAdapter
        extends RecyclerView.Adapter<ProjectsRecyclerViewAdapter.ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private List<Project> mProjects;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public String mBoundString;
        public final View mView;
        public final ImageView mImageView;
        public final TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.iv_avatar);
            mTextView = (TextView) view.findViewById(R.id.tv_project_title);
        }

        @Override
        public String toString() {
            return super.toString() + " ' " + mTextView.getText();
        }
    }

    public ProjectsRecyclerViewAdapter(Context context, List<Project> items) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        mProjects = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ArrayList<String> projectInfo = mProjects.get(position).getProjectArray();
        final HashMap<String, Integer> projectPictures = mProjects.get(position).getPicturesMap();
        holder.mTextView.setText(mProjects.get(position).getTitle());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("NIGGAAAA", "YOU CLIKED THE DUCKING SHIT");
                Context context = v.getContext();
                Intent intent = new Intent(context, ProjectDetailActivity.class);
                intent.putExtra(ProjectDetailActivity.EXTRA_DETAILS, projectInfo);
                intent.putExtra(ProjectDetailActivity.EXTRA_PICTURES, projectPictures);
                context.startActivity(intent);
            }
        });

        int drawable = getDrawable(mProjects.get(position).getLanguage());
        Glide.with(holder.mImageView.getContext())
                .load(drawable)
                .fitCenter()
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mProjects.size();
    }

    private int getDrawable(String name) {
        if(name.equals("Android")) {
            return R.drawable.lang_android;
        }
        else if(name.equals("PHP")) {
            return R.drawable.lang_php;
        }
        else if(name.equals("CPP")) {
            return R.drawable.lang_cpp;
        }
        else if(name.equals("Python")) {
            return R.drawable.lang_python;
        }
        else {
            return R.drawable.ic_public_black_48dp;
        }
    }
}
