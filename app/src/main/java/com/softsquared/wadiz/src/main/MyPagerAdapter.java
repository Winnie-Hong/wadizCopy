package com.softsquared.wadiz.src.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.wadiz.src.main.FragmentPages.Home.MainHomeFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Investment.MainInvestmentFragment;
import com.softsquared.wadiz.src.main.FragmentPages.MoreInfo.MainMoreInfoFragment;
import com.softsquared.wadiz.src.main.FragmentPages.MyPage.MainMyPageFragment;
import com.softsquared.wadiz.src.main.FragmentPages.MyPage.MainMyPageLogoutFragment;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.MainRewardFragment;

import static com.softsquared.wadiz.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.wadiz.src.ApplicationClass.sSharedPreferences;

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
                return new MainRewardFragment();
            case 1:
                return new MainInvestmentFragment();
            case 2:
                return new MainHomeFragment();
            case 3:
                final String jwtToken = sSharedPreferences.getString(X_ACCESS_TOKEN, null);
                if (jwtToken == null){
                    return new MainMyPageLogoutFragment();
                }else return new MainMyPageFragment();
            case 4:
                return new MainMoreInfoFragment();
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
