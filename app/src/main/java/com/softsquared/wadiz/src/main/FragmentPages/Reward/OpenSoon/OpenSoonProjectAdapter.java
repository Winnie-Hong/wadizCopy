package com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.OpenSoon.models.OpenSoonProjectData;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.RewardProjectData;

import java.util.ArrayList;

public class OpenSoonProjectAdapter extends RecyclerView.Adapter<OpenSoonProjectAdapter.OpenSoonProjectViewHolder> {
    Context mContext;

    private ArrayList<OpenSoonProjectData> openSoonProjectDatas;

    public OpenSoonProjectAdapter(Context mContext, ArrayList<OpenSoonProjectData> openSoonProjectDatas) {
        this.mContext = mContext;
        this.openSoonProjectDatas = openSoonProjectDatas;
    }

    public OpenSoonProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_project_opensoon, parent, false);
        OpenSoonProjectViewHolder openSoonProjectViewHolder = new OpenSoonProjectViewHolder(view);

        return openSoonProjectViewHolder;
    }

    @Override
    public void onBindViewHolder(OpenSoonProjectViewHolder openSoonProjectViewHolder, int position) {
        OpenSoonProjectData openSoonProjectData = openSoonProjectDatas.get(position);

        openSoonProjectViewHolder.title.setText(openSoonProjectData.getTitle());
        openSoonProjectViewHolder.makername.setText(openSoonProjectData.getMakerName());
        openSoonProjectViewHolder.expected.setText(openSoonProjectData.getExpected());
        Glide.with(mContext).load(openSoonProjectData.getThumnail()).centerCrop().into(openSoonProjectViewHolder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return openSoonProjectDatas.size();
    }

    class OpenSoonProjectViewHolder extends RecyclerView.ViewHolder {

         ImageView thumbnail;
         TextView title;
         TextView makername;
         TextView expected;

        OpenSoonProjectViewHolder(View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.icon_category);
            title = itemView.findViewById(R.id.tv_project_title);
            makername = itemView.findViewById(R.id.tv_project_makername);
            expected = itemView.findViewById(R.id.tv_project_expected);
        }
    }
}
