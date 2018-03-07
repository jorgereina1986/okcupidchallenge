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

import com.jorgereina.www.okcupidchallenge.MainActivity;
import com.jorgereina.www.okcupidchallenge.R;
import com.jorgereina.www.okcupidchallenge.model.Data;
import com.jorgereina.www.okcupidchallenge.special.SpecialBlendAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgereina on 2/26/18.
 */

public class MatchesFragment extends Fragment {

    private static final int LAYOUT_MANAGER_SPAN_COUNT = 2;

    private RecyclerView recyclerView;
    private SpecialBlendAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Data> dataList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.matches_fragment, container, false);
        layoutManager = new GridLayoutManager(getContext(), LAYOUT_MANAGER_SPAN_COUNT);
        recyclerView = rootView.findViewById(R.id.matches_rv);
        adapter = new SpecialBlendAdapter(getContext(), dataList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        String tag = getTag();
        ((MainActivity)getActivity()).setMatchesFragment(tag);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter.notifyDataSetChanged();
    }

    public void addDataToList(Data data) {
        dataList.add(data);
        adapter.notifyDataSetChanged();
    }

    public void removeDataFromList(Data data) {
        dataList.remove(data);
        adapter.notifyDataSetChanged();
    }
}
