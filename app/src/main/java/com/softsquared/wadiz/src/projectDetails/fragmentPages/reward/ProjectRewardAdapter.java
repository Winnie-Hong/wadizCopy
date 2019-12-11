package com.softsquared.wadiz.src.projectDetails.fragmentPages.reward;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.models.ProjectRewardData;

import java.util.ArrayList;

public class ProjectRewardAdapter extends RecyclerView.Adapter<ProjectRewardAdapter.ProjectRewardViewHolder> {

    Context mContext;
    private ArrayList<ProjectRewardData> mProjectRewardData = null ;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public ProjectRewardAdapter(Context mContext, ArrayList<ProjectRewardData> projectRewardData) {
        mContext = mContext;
        mProjectRewardData = projectRewardData ;
    }



    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public ProjectRewardAdapter.ProjectRewardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.recyclerview_reward_details_reward, parent, false) ;
        ProjectRewardAdapter.ProjectRewardViewHolder vh = new ProjectRewardAdapter.ProjectRewardViewHolder(view) ;

        return vh ;
    }


    @Override
    public void onBindViewHolder(ProjectRewardViewHolder projectRewardViewHolder, int position) {

        ProjectRewardData projectRewardData = mProjectRewardData.get(position);

        projectRewardViewHolder.rewardPrice.setText(projectRewardData.getRewardPrice());
        projectRewardViewHolder.rewardName.setText(projectRewardData.getRewardName());
        projectRewardViewHolder.rewardInfo.setText(projectRewardData.getRewardInfo());
        projectRewardViewHolder.rewardShipping.setText(projectRewardData.getShipping());
        projectRewardViewHolder.rewardQuantity.setText(projectRewardData.getQuantity());
        projectRewardViewHolder.rewardRemaining.setText(projectRewardData.getRemaining());
        projectRewardViewHolder.rewardCompletion.setText(projectRewardData.getCompletion());
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mProjectRewardData.size() ;
    }

    class ProjectRewardViewHolder extends RecyclerView.ViewHolder {

        TextView rewardPrice;
        TextView rewardName;
        TextView rewardInfo;
        TextView rewardShipping;
        TextView rewardQuantity;
        TextView rewardRemaining;
        TextView rewardCompletion;

        ProjectRewardViewHolder(View itemView) {
            super(itemView);

            rewardPrice = itemView.findViewById(R.id.project_details_reward_price);
            rewardName = itemView.findViewById(R.id.project_details_reward_name);
            rewardInfo = itemView.findViewById(R.id.project_details_reward_info);
            rewardShipping = itemView.findViewById(R.id.project_details_reward_shipping);
            rewardQuantity = itemView.findViewById(R.id.project_details_reward_quantity);
            rewardRemaining = itemView.findViewById(R.id.project_details_reward_remaining);
            rewardCompletion = itemView.findViewById(R.id.project_details_reward_completion);


        }
    }
}