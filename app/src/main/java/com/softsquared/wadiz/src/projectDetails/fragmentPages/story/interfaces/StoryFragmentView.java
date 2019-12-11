package com.softsquared.wadiz.src.projectDetails.fragmentPages.story.interfaces;

import com.softsquared.wadiz.src.projectDetails.fragmentPages.story.models.ProjectStoryData;

public interface StoryFragmentView {

    void validateFailure(String message);
    void getProjectDetailsSuccess(ProjectStoryData projectStoryData);
}
