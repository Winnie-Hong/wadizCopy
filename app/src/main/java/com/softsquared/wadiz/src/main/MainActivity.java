package com.softsquared.wadiz.src.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.main.interfaces.MainActivityView;

import static com.softsquared.wadiz.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.wadiz.src.ApplicationClass.sSharedPreferences;

public class MainActivity extends BaseActivity implements MainActivityView {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    ImageView mSearchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tablayout);
        mSearchBtn = findViewById(R.id.icon_search);

        //자동 로그인 체크
        final String jwtToken = sSharedPreferences.getString(X_ACCESS_TOKEN, null);
        if (jwtToken == null){
            showCustomToast("로그인 해주세요.");
        }

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.pager);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        //뷰페이저 설정
        mTabLayout.setupWithViewPager(mViewPager);

        //탭 아이콘 설정
        mTabLayout.getTabAt(0).setIcon(R.drawable.icon_main_reward);
        mTabLayout.getTabAt(1).setIcon(R.drawable.icon_main_invest);
        mTabLayout.getTabAt(2).setIcon(R.drawable.icon_main_home);
        mTabLayout.getTabAt(3).setIcon(R.drawable.icon_main_my);
        mTabLayout.getTabAt(4).setIcon(R.drawable.icon_main_more_info);

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
    }


    private void tryGetTest() {
        showProgressDialog();

        final MainService mainService = new MainService(this);
        mainService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();

    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }


}
