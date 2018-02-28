package com.jorgereina.www.okcupidchallenge.matches;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorgereina.www.okcupidchallenge.R;
import com.jorgereina.www.okcupidchallenge.model.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgereina on 2/26/18.
 */

public class MatchesFragment extends Fragment {

    private RecyclerView recyclerView;
    private MatchesAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Data> dataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.matches_fragment, container, false);
        dataList = new ArrayList<>();
        layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView = rootView.findViewById(R.id.matches_rv);
        adapter = new MatchesAdapter(getContext(), dataList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void recieveDataforMatches(List<Data> list) {

        dataList.addAll(list);
        adapter.notifyDataSetChanged();

    }
}
