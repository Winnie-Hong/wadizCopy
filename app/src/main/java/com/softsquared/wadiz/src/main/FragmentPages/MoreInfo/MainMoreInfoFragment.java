package com.softsquared.wadiz.src.main.FragmentPages.MoreInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;

import java.util.ArrayList;

public class MainMoreInfoFragment extends Fragment {

    private ArrayList<MoreInfoData> mMoreInfoData = new ArrayList<>();
    private ArrayList<MoreInfoData> mMoreInfoIntroduce = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_main_moreinfo, container, false);


        // 리사이클러뷰에 표시할 데이터 리스트 생성.
        ArrayList<String> shortCutList = new ArrayList<>();
        shortCutList.add("펀딩 오픈 신청하기");
        shortCutList.add("펀딩메이트");
        shortCutList.add("메이커 뉴스레터");
        shortCutList.add("와디즈 스쿨");
        shortCutList.add("캐스트");
        shortCutList.add("이용가이드");

        ArrayList<String> introductionList = new ArrayList<>();
        introductionList.add("와디즈 소개");
        introductionList.add("와디즈 마스터");
        introductionList.add("와디즈 파트너");
        introductionList.add("성공 프로젝트");

        ArrayList<String> noticeList = new ArrayList<>();
        noticeList.add("공지사항");
        noticeList.add("이벤트");
        noticeList.add("채용");


        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = view.findViewById(R.id.more_info_short_cut_rv) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())) ;
        MoreInfoAdapter shortCutAdapter = new MoreInfoAdapter(shortCutList) ;
        recyclerView.setAdapter(shortCutAdapter) ;

        RecyclerView recyclerViewIntroduction = view.findViewById(R.id.more_info_introduction_rv);
        recyclerViewIntroduction.setLayoutManager(new LinearLayoutManager(getActivity()));
        MoreInfoAdapter introductionAdapter = new MoreInfoAdapter(noticeList);
        recyclerViewIntroduction.setAdapter(introductionAdapter);

        RecyclerView recyclerViewNotice = view.findViewById(R.id.more_info_notice_rv);
        recyclerViewNotice.setLayoutManager(new LinearLayoutManager(getActivity()));
        MoreInfoAdapter noticeAdapter = new MoreInfoAdapter(noticeList);
        recyclerViewNotice.setAdapter(noticeAdapter);

        return view;
    }
}
