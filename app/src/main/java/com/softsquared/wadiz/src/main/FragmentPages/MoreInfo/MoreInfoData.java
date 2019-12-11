package com.softsquared.wadiz.src.main.FragmentPages.MoreInfo;

import android.widget.ImageView;

public class MoreInfoData {

    private String moreInfo;
    private ImageView nextBtn;

    public MoreInfoData(String moreInfo, ImageView nextBtn) {
        this.moreInfo = moreInfo;
        this.nextBtn = nextBtn;
    }


    public String getMoreInfo() {
        return this.moreInfo;
    }

    public ImageView getNextBtn() {
        return this.nextBtn;
    }
}

