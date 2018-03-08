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
    private List<Data> topSix = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.matches_fragment, container, false);
        layoutManager = new GridLayoutManager(getContext(), LAYOUT_MANAGER_SPAN_COUNT);
        recyclerView = rootView.findViewById(R.id.matches_rv);
        adapter = new MatchesAdapter(getContext(), dataList, topSix);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        String tag = getTag();
        ((MainActivity) getActivity()).setMatchesFragment(tag);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void addDataToList(Data data) {

        if (!dataList.contains(data)) {
            dataList.add(data);
            Collections.sort(dataList);
            Collections.sort(topSix);
            adapter.displayOnlyTopSix();
        }
    }

    public void removeDataFromList(Data data) {

        if (topSix.contains(data)) {
            dataList.remove(data);
            topSix.remove(data);
            Collections.sort(dataList);
            Collections.sort(topSix);
            adapter.displayOnlyTopSix();
        }
    }
}
