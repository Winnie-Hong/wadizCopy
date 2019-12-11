package com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;

public class ProjectSupporterFragment extends BaseFragment{


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        {
            final View view = inflater.inflate(R.layout.fragment_project_details_supporter, container, false);

            return view;
        }

    }

}
