package com.softsquared.wadiz.src.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.tabs.TabLayout;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;


public class SearchActivity extends BaseActivity {

    private TabLayout tabLayout;
    private LinearLayout container;
    private ImageView mGoBack;
    private ImageView mGoHome;
    EditText mSearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        tabLayout = findViewById(R.id.activity_search_tab_layout);
//        container = findViewById(R.id.fragment_container);
        mGoBack = findViewById(R.id.activity_search_icon_go_back);
        mGoHome = findViewById(R.id.activity_search_icon_go_home);
        mSearchBar = findViewById(R.id.activity_search_et);

        tabLayout.addTab(tabLayout.newTab().setText("최근"));
        tabLayout.addTab(tabLayout.newTab().setText("인기"));

//        //replace default fragment
//        replaceFragment(new RecentFragment());
//
//        //handling tab click event
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                if (tab.getPosition() == 0) {
//                    replaceFragment(new RecentFragment());
//                } else if (tab.getPosition() == 1) {
//                    replaceFragment(new PopularFragment());
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//    }
//
//    private void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.fragment_container, fragment);
//
//        transaction.commit();

        mGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //search
        mSearchBar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_SEARCH:
                        String word = v.getText().toString();
//                        showCustomToast(getActivity(), word);
                        getSearchProject(word);
                        break;
                    default:
                        return false;
                }
                return true;
            }

            private void getSearchProject(String word) {
                    showProgressDialog();
//                    final RewardHomeService rewardHomeService = new RewardHomeService(this);
//                    rewardHomeService.getSearchProject(word);
            }
        });

    }
}
