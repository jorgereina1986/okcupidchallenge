package com.jorgereina.www.okcupidchallenge.matches;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jorgereina.www.okcupidchallenge.R;
import com.jorgereina.www.okcupidchallenge.model.Data;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jorgereina on 2/27/18.
 */

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private Context context;
    private List<Data> dataList;

    public MatchesAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.profile_card_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView profileIv;
        private TextView ageLocationTv;
        private TextView usernameTv;

        public ViewHolder(View itemView) {
            super(itemView);
            profileIv = itemView.findViewById(R.id.profile_iv);
            ageLocationTv = itemView.findViewById(R.id.age_location_tv);
            usernameTv = itemView.findViewById(R.id.username_tv);
        }

        public void bind(Data data) {
            Picasso.with(context)
                    .load(data.getPhoto().getThumbPath().getLarge())
                    .into(profileIv);
            ageLocationTv.setText(data.getAge() + " · " + data.getLocation().getCity() + ", " + data.getLocation().getStateCode());
            usernameTv.setText(data.getUsername());
        }
    }
}
