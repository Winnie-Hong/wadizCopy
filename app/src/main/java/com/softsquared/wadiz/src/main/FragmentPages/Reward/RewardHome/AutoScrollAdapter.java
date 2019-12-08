package com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RewardHome.models.Banner;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class AutoScrollAdapter extends PagerAdapter {

    Context context;
    ArrayList<Banner> banners;

    public AutoScrollAdapter(Context context, ArrayList<Banner> imgdata){
        this.context = context;
        this.banners = imgdata;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        //뷰페이지 슬라이딩 할 레이아웃 인플레이션
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.subfragment_viewpager_banner,null);

        ImageView img_banner = (ImageView) v.findViewById(R.id.img_banner);
        TextView textViewTitle = v.findViewById(R.id.tv_banner_title);
        TextView textViewSubTitle = v.findViewById(R.id.tv_banner_subtitle);

        Glide.with(context).load(banners.get(position).getBannerImg()).centerCrop().into(img_banner);
        textViewTitle.setText(banners.get(position).getBannerText());
        textViewSubTitle.setText(banners.get(position).getBannerSub());

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View)object);

    }

    @Override
    public int getCount() {
        return banners.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
