package com.softsquared.wadiz.src.projectDetails.rewardPolicy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.projectDetails.rewardPolicy.interfaces.FundPolicyView;
import com.softsquared.wadiz.src.projectDetails.rewardPolicy.models.FundPolicyData;

public class FundPolicyActivity extends BaseActivity implements FundPolicyView {

    CheckBox mChkB1;
    CheckBox mChkB2;
    CheckBox mChkB3;
    TextView mContinueFunding;

    TextView mMakerNamePolicy;
    TextView mDatePolicy1;
    TextView mMakerNamePolicy2;

    String mMakerName;
    String mMakerNameTv1;
    String mMakerNameTv2;
    String mRewardDate;
    String mDelieveryDate;
    String mDateTv1;
    String mDateTv2;
    String mDateTv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        int projectIdx = getIntent().getExtras().getInt("projectIdx");
        Log.d("projectIdx", projectIdx + " : 번 fund policy");
        getFundPolicy(projectIdx);

        //textview 초기화
        mMakerNamePolicy = findViewById(R.id.project_policy_of_maker_name1);
        mDatePolicy1 = findViewById(R.id.project_details_reward_policy_text2);
        mMakerNamePolicy2 = findViewById(R.id.project_policy_of_maker_name2);

        //글자 쪼개기
        mMakerNameTv1 = getString(R.string.policy_of_maker_name_text1);
        mMakerNameTv2 = getString(R.string.policy_of_maker_name_text2);
        mDateTv1 = getString(R.string.policy_reward_date_text1);
        mDateTv2 = getString(R.string.policy_reward_date_text2);
        mDateTv3 = getString(R.string.policy_reward_date_text3);

        //체크박스 연결
        mChkB1 = findViewById(R.id.project_details_reward_policy_cb1);
        mChkB2 = findViewById(R.id.project_details_reward_policy_cb2);
        mChkB3 = findViewById(R.id.project_details_reward_policy_cb3);
        mContinueFunding = findViewById(R.id.policy_continue_funding_btn);

        mChkB1.setOnClickListener(onCheckBoxClickListener);
        mChkB2.setOnClickListener(onCheckBoxClickListener);
        mChkB3.setOnClickListener(onCheckBoxClickListener);

        mContinueFunding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ActivityFundPolicy.this, ActivityFund.class);
            }
        });
        mChkB1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mChkB1.setTextColor(Color.parseColor("#808080"));
                } else {
                    mChkB1.setTextColor(Color.parseColor("#cfcfcf"));
                }
            }
        });
        mChkB2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mChkB2.setTextColor(Color.parseColor("#808080"));
                } else {
                    mChkB2.setTextColor(Color.parseColor("#cfcfcf"));
                }
            }
        });
        mChkB3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mChkB3.setTextColor(Color.parseColor("#808080"));
                } else {
                    mChkB3.setTextColor(Color.parseColor("#cfcfcf"));
                }
            }
        });


    }

    private void getFundPolicy(int projectIdx) {
        showProgressDialog();
        final FundPolicyService fundPolicyService = new FundPolicyService(this);
        fundPolicyService.getFundPolicy(projectIdx);
    }

    private View.OnClickListener onCheckBoxClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isAllChecked()) {
                mContinueFunding.setClickable(true);
                mContinueFunding.setBackgroundColor(getResources().getColor(R.color.mainColor));
            } else {
                mContinueFunding.setClickable(false);
                mContinueFunding.setBackgroundColor(getResources().getColor(R.color.lineColor));
            }
        }
    };

    private boolean isAllChecked() {
        return (mChkB1.isChecked() && mChkB2.isChecked() && mChkB3.isChecked());
    }


    @Override
    public void getFundPolicySuccess(FundPolicyData fundPolicyData) {
        hideProgressDialog();

        mMakerName = fundPolicyData.getMakerName();
        mDelieveryDate = fundPolicyData.getDeliveryDate();
        mRewardDate = fundPolicyData.getRewardDate();

        String sentence1 = mMakerName + mMakerNameTv1;
        String sentence2 = mDateTv1 + " " + mRewardDate + mDateTv2 + " " + mDelieveryDate + " " + mDateTv3;
        String sentence3 = mMakerName + " " + mMakerNameTv2;

        mMakerNamePolicy.setText(sentence1);
        mDatePolicy1.setText(sentence2);
        mMakerNamePolicy2.setText(sentence3);
    }

    @Override
    public void validateFailure(String message) {
        hideProgressDialog();
    }
}
