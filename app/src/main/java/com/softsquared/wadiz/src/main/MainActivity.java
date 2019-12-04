package com.softsquared.wadiz.src.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.main.interfaces.MainActivityView;

public class MainActivity extends BaseActivity implements MainActivityView {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //툴바 만들기
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setLogo(R.drawable.img_barlogo);
//        setSupportActionBar(toolbar);
//        Actionbar actionbar = getSupportActionBar();

        tabLayout = (TabLayout)findViewById(R.id.tablayout);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        tabLayout.setupWithViewPager(viewPager);
        setTabLayoutRes();
    }

    private void setTabLayoutRes() {

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

    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn_hello_world:
                tryGetTest();
                break;
            default:
                break;
        }
    }
}
