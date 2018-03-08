package com.jorgereina.www.okcupidchallenge;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jorgereina.www.okcupidchallenge.model.Data;
import com.squareup.picasso.Picasso;

/**
 * Created by jorgereina on 3/6/18.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private ImageView profileIv;
    private TextView ageLocationTv;
    private TextView usernameTv;
    private TextView matchPecentageTv;

    public BaseViewHolder(View itemView) {
        super(itemView);
        profileIv = itemView.findViewById(R.id.profile_iv);
        ageLocationTv = itemView.findViewById(R.id.age_location_tv);
        usernameTv = itemView.findViewById(R.id.username_tv);
        matchPecentageTv = itemView.findViewById(R.id.match_tv);
    }

    public void bind(final Data data) {

        int age = data.getAge();
        String city = data.getLocation().getCity();
        String state = data.getLocation().getStateCode();

        Picasso.with(itemView.getContext())
                .load(data.getPhoto().getThumbPath().getLarge())
                .into(profileIv);
        ageLocationTv.setText(createAgeCityStateString(age, city, state));
        usernameTv.setText(data.getUsername());
        matchPecentageTv.setText(convertMatchPercentage(data.getMatch()));
    }

    private String createAgeCityStateString(int age, String city, String state) {
        return age + " · " + city + ", " + state;
    }

    private String convertMatchPercentage(int match) {
        match = match / 100;
        return match + "% Match";
    }
}
