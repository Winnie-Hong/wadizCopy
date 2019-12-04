package com.softsquared.wadiz.src.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.wadiz.src.main.FragmentPages.Home.MainHome;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.MainInvestment;
import com.softsquared.wadiz.src.main.FragmentPages.MainMoreInfo;
import com.softsquared.wadiz.src.main.FragmentPages.MainMyPage;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.MainReward;

class MyPagerAdapter extends FragmentPagerAdapter {

    int mNumberOfPages;
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
        this.mNumberOfPages = 5;
    }

    @Override
    public Fragment getItem(int position) {
        if(position<0 || position>=mNumberOfPages){
            return null;
        }
        switch (position){
            case 0:
                return new MainReward();
            case 1:
                return new MainInvestment();
            case 2:
                return new MainHome();
            case 3:
                return new MainMyPage();
            case 4:
                return new MainMoreInfo();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumberOfPages;
    }

    private String[] pageTitle={
            "리워드",
            "투자",
            "홈",
            "MY",
            "더보기"
    };
    public CharSequence getPageTitle(int position){
        if(pageTitle[position]!=null){
            return pageTitle[position];
        }
        else
            return null;
    }
}
