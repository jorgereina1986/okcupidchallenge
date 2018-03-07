package com.jorgereina.www.okcupidchallenge.matches;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.jorgereina.www.okcupidchallenge.MainActivity;
import com.jorgereina.www.okcupidchallenge.R;
import com.jorgereina.www.okcupidchallenge.model.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by jorgereina on 2/26/18.
 */

public class MatchesFragment extends Fragment {

    private static final int LAYOUT_MANAGER_SPAN_COUNT = 2;

    private RecyclerView recyclerView;
    private MatchesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Data> dataList = new ArrayList<>();
    CardView cardView;
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.matches_fragment, container, false);
        layoutManager = new GridLayoutManager(getContext(), LAYOUT_MANAGER_SPAN_COUNT);
        recyclerView = rootView.findViewById(R.id.matches_rv);
        adapter = new MatchesAdapter(getContext(), dataList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        cardView = rootView.findViewById(R.id.card_view);
        String tag = getTag();
        ((MainActivity) getActivity()).setMatchesFragment(tag);
        button = rootView.findViewById(R.id.temp_button);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter.notifyDataSetChanged();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.deleteItem(0);
            }
        });
    }

    public void addDataToList(Data data) {
        dataList.add(data);
        Collections.sort(dataList);
        adapter.notifyDataSetChanged();
    }

    public void removeDataFromList(Data data) {
        dataList.remove(data);
        Collections.sort(dataList);
        adapter.notifyDataSetChanged();
    }
}
