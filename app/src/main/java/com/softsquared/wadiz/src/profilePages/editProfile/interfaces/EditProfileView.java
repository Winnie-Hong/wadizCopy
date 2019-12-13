package com.softsquared.wadiz.src.profilePages.editProfile.interfaces;

public interface EditProfileView {

    void validateFailure(String message);

    void patchProfileImgSuccess(String result, String jwt);
}
