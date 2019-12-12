package com.softsquared.wadiz.src.main.FragmentPages.MyPage;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.FragmentPages.MoreInfo.MoreInfoAdapter;
import com.softsquared.wadiz.src.main.MainActivity;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.softsquared.wadiz.src.ApplicationClass.X_ACCESS_TOKEN;
import static com.softsquared.wadiz.src.ApplicationClass.sSharedPreferences;

public class MainMyPageFragment extends BaseFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.fragment_main_mypage, container, false);

        TextView logoutBtn = view.findViewById(R.id.mypage_logout_btn);

        //menu recyclerview 설정
        ArrayList<String> mypageList = new ArrayList<>();
        mypageList.add("쿠폰 0장");
        mypageList.add("포인트 0P");
        mypageList.add("나의 지지서명");
        mypageList.add("메시지");
        mypageList.add("설정");

        RecyclerView recyclerViewNotice = view.findViewById(R.id.mypage_menu_rv);
        recyclerViewNotice.setLayoutManager(new LinearLayoutManager(getActivity()));
        MoreInfoAdapter myPageAdapter = new MoreInfoAdapter(mypageList);
        recyclerViewNotice.setAdapter(myPageAdapter);

        //로그아웃 하기
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDlg_logout = new AlertDialog.Builder(getActivity());
                alertDlg_logout.setTitle("로그아웃");
                alertDlg_logout.setMessage("정말 로그아웃 하시겠어요?");

                alertDlg_logout.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showCustomToast(getActivity(), "로그아웃 되었습니다.");

                        //토큰 삭제하기
                        SharedPreferences.Editor editor = sSharedPreferences.edit();
                        editor.remove(X_ACCESS_TOKEN);
                        editor.apply();

                        final String jwtToken = sSharedPreferences.getString(X_ACCESS_TOKEN, null);
                        dialog.dismiss();
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
                alertDlg_logout.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDlg_logout.show();
            }
        });


        return view;

    }
}
