package com.jorgereina.www.okcupidchallenge.special;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jorgereina.www.okcupidchallenge.BaseViewHolder;
import com.jorgereina.www.okcupidchallenge.Communicator;
import com.jorgereina.www.okcupidchallenge.R;
import com.jorgereina.www.okcupidchallenge.model.Data;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jorgereina on 2/26/18.
 */

public class SpecialBlendAdapter extends RecyclerView.Adapter<SpecialViewHolder> {

    private Context context;
    private List<Data> dataList;

    public SpecialBlendAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public SpecialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.profile_card_item, parent, false);
        return new SpecialViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SpecialViewHolder holder, int position) {
        Data data = dataList.get(position);
        holder.bind(data);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
