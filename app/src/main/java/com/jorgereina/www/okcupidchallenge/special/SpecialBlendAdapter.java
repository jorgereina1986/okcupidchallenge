package com.jorgereina.www.okcupidchallenge.special;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jorgereina.www.okcupidchallenge.Communicator;
import com.jorgereina.www.okcupidchallenge.R;
import com.jorgereina.www.okcupidchallenge.model.Data;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jorgereina on 2/26/18.
 */

public class SpecialBlendAdapter extends RecyclerView.Adapter<SpecialBlendAdapter.ViewHolder> {

    private Context context;
    private List<Data> dataList;
    private List<Data> matchList;
    Communicator communicator;

    public SpecialBlendAdapter(Context context, List<Data> dataList, List<Data> matchList) {
        this.context = context;
        this.dataList = dataList;
        this.matchList = matchList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_card_item, parent, false);
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

        public ImageView profileIv;
        public TextView usernameTv;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            profileIv = itemView.findViewById(R.id.profile_iv);
            usernameTv = itemView.findViewById(R.id.username_tv);
            cardView = itemView.findViewById(R.id.card_view);
            communicator = (Communicator) itemView.getContext();
        }

        public void bind(final Data data) {

            Picasso.with(context).load(data.getPhoto().getFullPath().getLarge()).resize(400, 400).centerInside().into(profileIv);
            usernameTv.setText(data.getUsername());

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    if (!data.isClicked()) {
//                        data.setClicked(true);
//                        matchList.add(data);
//                        cardView.setCardBackgroundColor(Color.YELLOW);
//                        communicator.addToMatches(matchList);
//                        Toast.makeText(view.getContext(), data.isClicked() + " "+ matchList.size(), Toast.LENGTH_LONG).show();
//
//                    } else {
//                        data.setClicked(false);
//                        cardView.setCardBackgroundColor(0xFAFAFAFA);
//                        matchList.remove(data);
//                        Toast.makeText(view.getContext(), data.isClicked() + " "+ matchList.size(), Toast.LENGTH_LONG).show();
//
//                    }
//                }
//            });
        }
    }
}
