package com.jorgereina.www.okcupidchallenge.special;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.jorgereina.www.okcupidchallenge.BaseViewHolder;
import com.jorgereina.www.okcupidchallenge.MainActivity;
import com.jorgereina.www.okcupidchallenge.R;
import com.jorgereina.www.okcupidchallenge.matches.MatchesFragment;
import com.jorgereina.www.okcupidchallenge.model.Data;

/**
 * Created by jorgereina on 3/6/18.
 */

public class SpecialViewHolder extends BaseViewHolder {

    private CardView cardView;

    public SpecialViewHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_view);
    }

    @Override
    public void bind(final Data data) {
        super.bind(data);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = view.getContext();
                String matchesFragmentTag = ((MainActivity) context).getMatchesFragment();
                MatchesFragment matchesFragment = (MatchesFragment) ((MainActivity) context)
                        .getSupportFragmentManager()
                        .findFragmentByTag(matchesFragmentTag);

                if (data.isLiked()) {
                    data.setLiked(false);
                    view.setBackgroundColor(matchesFragment.getResources().getColor(R.color.defaultCardViewColor));
                    matchesFragment.removeDataFromList(data);
                    Toast.makeText(view.getContext(), data.isLiked() + " " + data.getUsername(), Toast.LENGTH_LONG).show();
                } else {
                    data.setLiked(true);
                    cardView.setBackgroundColor(matchesFragment.getResources().getColor(R.color.selectedCardViewColor));
                    matchesFragment.addDataToList(data);
                    Toast.makeText(view.getContext(), data.isLiked() + " " + data.getUsername(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
