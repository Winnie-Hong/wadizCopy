package com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.CategoryData;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.RewardProjectData;

import java.util.ArrayList;

public class RewardProjectAdapter extends RecyclerView.Adapter<RewardProjectAdapter.RewardProjectViewHolder> {
    Context mContext;

    private ArrayList<RewardProjectData> rewardProjectDatas;

    public RewardProjectAdapter(Context mContext, ArrayList<RewardProjectData> rewardProjectDatas) {
        this.mContext = mContext;
        this.rewardProjectDatas = rewardProjectDatas;
    }

    public RewardProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_project_rewardhome, parent, false);
        RewardProjectViewHolder rewardProjectViewHolder = new RewardProjectViewHolder(view);

        return rewardProjectViewHolder;
    }

    @Override
    public void onBindViewHolder(RewardProjectViewHolder rewardProjectViewHolder, int position) {
        RewardProjectData rewardProjectData = rewardProjectDatas.get(position);

        rewardProjectViewHolder.title.setText(rewardProjectData.getTitle());
        rewardProjectViewHolder.category.setText(rewardProjectData.getCategory());
        rewardProjectViewHolder.makername.setText(rewardProjectData.getMakerName());
        rewardProjectViewHolder.achievement.setText(rewardProjectData.getAchievement());
        rewardProjectViewHolder.amount.setText(rewardProjectData.getAmount());
        rewardProjectViewHolder.remaining.setText(rewardProjectData.getRemaining());
        Glide.with(mContext).load(rewardProjectData.getThumnail()).centerCrop().into(rewardProjectViewHolder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return rewardProjectDatas.size();
    }

    class RewardProjectViewHolder extends RecyclerView.ViewHolder {

         ImageView thumbnail;
         TextView title;
         TextView category;
         TextView makername;
         TextView achievement;
         TextView amount;
         TextView remaining;

         RewardProjectViewHolder(View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.icon_category);
            title = itemView.findViewById(R.id.tv_project_title);
            category = itemView.findViewById(R.id.tv_project_category);
            makername = itemView.findViewById(R.id.tv_project_makername);
            achievement = itemView.findViewById(R.id.tv_project_achievement);
            amount = itemView.findViewById(R.id.tv_project_amount);
            remaining = itemView.findViewById(R.id.tv_project_remaining);
        }
    }
}
