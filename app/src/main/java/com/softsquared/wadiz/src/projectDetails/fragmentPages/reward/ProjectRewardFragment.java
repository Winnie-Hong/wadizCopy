package com.softsquared.wadiz.src.projectDetails.fragmentPages.reward;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.login.LoginActivity;
import com.softsquared.wadiz.src.projectDetails.ProjectDetailsActivity;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.interfaces.RewardFragmentView;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.models.ProjectRewardData;
import com.softsquared.wadiz.src.projectDetails.rewardPolicy.FundPolicyActivity;

import java.util.ArrayList;

import static com.softsquared.wadiz.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.wadiz.src.ApplicationClass.sSharedPreferences;

public class ProjectRewardFragment extends BaseFragment implements RewardFragmentView{

    int projectIdx;
    private ArrayList<ProjectRewardData> mProjectRewardData = new ArrayList<>();
    private ProjectRewardAdapter mProjectRewardAdapter;
    final String jwtToken = sSharedPreferences.getString(X_ACCESS_TOKEN, null);

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        {
            final View view = inflater.inflate(R.layout.fragment_project_details_reward, container, false);

            //projectIdx 받기
            Intent intent = getActivity().getIntent();
            projectIdx = intent.getExtras().getInt("projectIdx");
            getProjectReward(projectIdx);

//            rewardList.add();

            RecyclerView recyclerView = view.findViewById(R.id.project_details_recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mProjectRewardAdapter = new ProjectRewardAdapter(getContext(), mProjectRewardData);
//            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(mProjectRewardAdapter);



            return view;

        }

    }

    private void getProjectReward(int projectIdx) {
        showProgressDialog(getActivity());
        final ProjectRewardService projectRewardService = new ProjectRewardService(this);
        projectRewardService.getProjectReward(projectIdx);
    }

    @Override
    public void validateFailure(String message) {
        hideProgressDialog();
        Log.d("tag", "project reward validate failure");
    }

    @Override
    public void getProjectRewardSuccess(ArrayList<ProjectRewardData> projectRewardData) {
        hideProgressDialog();
        mProjectRewardData.addAll(projectRewardData);
        mProjectRewardAdapter.notifyDataSetChanged();
    }
}
