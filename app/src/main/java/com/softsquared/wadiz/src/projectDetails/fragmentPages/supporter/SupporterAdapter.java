package com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.recyclerview.widget.RecyclerView;

        import com.bumptech.glide.Glide;
        import com.softsquared.wadiz.R;
        import com.softsquared.wadiz.src.projectDetails.fragmentPages.supporter.models.SupportResultData;

        import java.util.ArrayList;

public class SupporterAdapter extends RecyclerView.Adapter<SupporterAdapter.SupporterViewHolder> {

    Context mContext;
    private ArrayList<SupportResultData> mSupportResultData;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public SupporterAdapter(Context context, ArrayList<SupportResultData> supportResultData) {
        mContext = context;
        mSupportResultData = supportResultData;
    }


    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public SupporterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recyclerview_supporters, parent, false);
        SupporterViewHolder vh = new SupporterViewHolder(view);

        return vh;
    }


    @Override
    public void onBindViewHolder(SupporterViewHolder supporterViewHolder, int position) {

        SupportResultData supportResultData = mSupportResultData.get(position);
        String veilName = mSupportResultData.get(position).getVeilName();
        String veilPrice = mSupportResultData.get(position).getVeilPrice();
        String supporterDetails = veilName + "님이 " + veilPrice + "원 펀딩으로 참여하였습니다.";

        Glide.with(mContext).load(supportResultData.getProfileImg()).circleCrop().into(supporterViewHolder.profileImg);
        supporterViewHolder.supportDetails.setText(supporterDetails);


    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mSupportResultData.size();
    }

    class SupporterViewHolder extends RecyclerView.ViewHolder {

        ImageView profileImg;
        TextView supportDetails;

        SupporterViewHolder(View itemView) {
            super(itemView);

            profileImg = itemView.findViewById(R.id.supporter_profile_img);
            supportDetails = itemView.findViewById(R.id.supporter_details);


        }
    }
}