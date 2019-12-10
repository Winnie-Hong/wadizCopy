package com.softsquared.wadiz.src.projectDetails.interfaces;

import com.softsquared.wadiz.src.projectDetails.models.ProjectDetailsData;

import java.util.ArrayList;

public interface ProjectDetailsActivityView {

    void validateFailure(String message);
    void getProjectDetailsSuccess(ProjectDetailsData projectDetailsData);
}
