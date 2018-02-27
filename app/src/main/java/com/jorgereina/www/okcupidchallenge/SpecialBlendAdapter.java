package com.jorgereina.www.okcupidchallenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jorgereina.www.okcupidchallenge.model.Data;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

/**
 * Created by jorgereina on 2/26/18.
 */

public class SpecialBlendAdapter extends RecyclerView.Adapter<SpecialBlendAdapter.ViewHolder> {

    private Context context;
    private List<Data> dataList;

    public SpecialBlendAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_card_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Data data = dataList.get(position);
        Picasso.with(context).load(data.getPhoto().getFullPath().getLarge()).into(holder.profileIv);
        holder.usernameTv.setText(data.getUsername());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView profileIv;
        TextView usernameTv;
        public ViewHolder(View itemView) {
            super(itemView);
            profileIv = itemView.findViewById(R.id.profile_iv);
            usernameTv = itemView.findViewById(R.id.username_tv);
        }
    }
}
