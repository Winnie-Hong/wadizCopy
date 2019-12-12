package com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.interfaces;

import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.models.ProjectStoryData;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.models.SupportResultData;
import com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.models.SupporterData;

import java.util.ArrayList;

public interface SupporterFragmentView {

    void validateFailure(String message);
    void getSupporterSuccess(SupporterData supporterData);
}
