package com.softsquared.wadiz.src.projectDetails.fragmentPages.fundGuide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;

public class ProjectFundGuideFragment extends BaseFragment{


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        {
            final View view = inflater.inflate(R.layout.fragment_project_details_fund_guide, container, false);

            return view;
        }

    }

}
