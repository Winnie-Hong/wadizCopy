package com.softsquared.wadiz.src.main.FragmentPages.Reward;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.main.MyPagerAdapter_to_Reward;

public class MainReward extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_main_reward, container, false);

        //viewPager와 tabLayout 연결
        TabLayout tabLayout=(TabLayout)view.findViewById(R.id.tablayout_reward);
        MyPagerAdapter_to_Reward adapter=new MyPagerAdapter_to_Reward(getChildFragmentManager());
        ViewPager viewPager = (ViewPager)view.findViewById(R.id.pager_reward);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
