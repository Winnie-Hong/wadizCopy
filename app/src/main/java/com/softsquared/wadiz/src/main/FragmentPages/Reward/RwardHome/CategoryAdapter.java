package com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.main.FragmentPages.Reward.RwardHome.models.CategoryData;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    Context mContext;

    private ArrayList<CategoryData> categoryDatas;

    public CategoryAdapter(Context mContext, ArrayList<CategoryData> categoryDatas) {
        this.mContext = mContext;
        this.categoryDatas = categoryDatas;
    }

    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_category_rewardhome, parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);

        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryData categoryData = categoryDatas.get(position);

        holder.description.setText(categoryData.getCategory());
        Glide.with(mContext).load(categoryData.getCategoryImg()).circleCrop().into(holder.icon);

    }

    @Override
    public int getItemCount() {
        return categoryDatas.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView description;

        CategoryViewHolder(View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon_category);
            description = itemView.findViewById(R.id.icon_description);
        }
    }
}
