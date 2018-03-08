package com.jorgereina.www.okcupidchallenge.matches;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jorgereina.www.okcupidchallenge.R;
import com.jorgereina.www.okcupidchallenge.model.Data;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jorgereina on 2/27/18.
 */

public class MatchesAdapter extends RecyclerView.Adapter<MatchesViewHolder> {

    private Context context;
    private List<Data> dataList;
    private List<Data> topSix;

    public MatchesAdapter(Context context, List<Data> dataList, List<Data> topSix) {
        this.context = context;
        this.dataList = dataList;
        this.topSix = topSix;
    }

    @Override
    public MatchesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.profile_card_item, parent, false);
        return new MatchesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MatchesViewHolder holder, int position) {
        Data data = topSix.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return topSix.size();
    }

    public void displayOnlyTopSix() {
        if (dataList.size() > 6) {
            topSix.clear();
            topSix.addAll(dataList.subList(0, 6));
        } else {
            topSix.clear();
            topSix.addAll(dataList);
        }
        notifyDataSetChanged();
    }
}
