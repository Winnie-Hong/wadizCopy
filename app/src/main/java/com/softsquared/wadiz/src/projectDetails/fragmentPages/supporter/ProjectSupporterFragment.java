package com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.ProjectRewardAdapter;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.reward.models.ProjectRewardData;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.interfaces.SupporterFragmentView;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.models.SupportResultData;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.models.SupporterData;

import java.util.ArrayList;

public class ProjectSupporterFragment extends BaseFragment implements SupporterFragmentView {

    int mProjectIdx;
    TextView mSupporterCnt;
    SupporterAdapter mSupportAdapter;
    private ArrayList<SupportResultData> mSupportResultData = new ArrayList<>();

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        {
            final View view = inflater.inflate(R.layout.fragment_project_details_supporter, container, false);

            Intent intent = getActivity().getIntent();
            mProjectIdx = intent.getExtras().getInt("projectIdx");
            getSupporter(mProjectIdx);

            //서포터 수 조회
            mSupporterCnt = view.findViewById(R.id.supporter_number);

            //리사이클러뷰
            RecyclerView recyclerView = view.findViewById(R.id.supporter_rv);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mSupportAdapter = new SupporterAdapter(getActivity(), mSupportResultData);
            recyclerView.setAdapter(mSupportAdapter);

            return view;
        }
    }

    private void getSupporter(int projectIdx) {
        hideProgressDialog();
        final SupporterService supporterService = new SupporterService(this);
        supporterService.getSupporter(projectIdx);
    }

    @Override
    public void validateFailure(String message) {
        hideProgressDialog();
        Log.d("supporter", message);
    }

    @Override
    public void getSupporterSuccess(SupporterData supporterData) {
        hideProgressDialog();
        String SupporterNum = supporterData.getCnt() + "명";
        mSupporterCnt.setText(SupporterNum);
        Log.d("supporter", "인원 조회 성공");

        //클리어
        mSupportResultData.clear();
        mSupportResultData.addAll(supporterData.getSupportResult());
        mSupportAdapter.notifyDataSetChanged();
    }

//    @Override
//    public void getSupportResultSuccess(ArrayList<SupportResultData> supportResultData) {
//        hideProgressDialog();
//        Log.d("supporter", "상세데이터 조회 성공");
//        mSupportResultData.addAll(supportResultData);
//        mSupportAdapter.notifyDataSetChanged();
//    }
}
