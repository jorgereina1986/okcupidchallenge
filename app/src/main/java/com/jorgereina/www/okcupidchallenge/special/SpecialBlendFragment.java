package com.jorgereina.www.okcupidchallenge.special;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jorgereina.www.okcupidchallenge.R;
import com.jorgereina.www.okcupidchallenge.model.Data;
import com.jorgereina.www.okcupidchallenge.model.OkcResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by jorgereina on 2/26/18.
 */

public class SpecialBlendFragment extends Fragment {

    private static final String BASE_URL = "https://www.okcupid.com/";
    private static final int LAYOUT_MANAGER_SPAN_COUNT = 2;

    private RecyclerView specialBundleRecyclerView;
    private SpecialBlendAdapter adapter;
    private List<Data> dataList;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.special_blend_fragment, container, false);
        dataList = new ArrayList<>();
        specialBundleRecyclerView = rootView.findViewById(R.id.special_blend_rv);
        layoutManager = new GridLayoutManager(getContext(), LAYOUT_MANAGER_SPAN_COUNT);
        adapter = new SpecialBlendAdapter(getContext(), dataList);
        specialBundleRecyclerView.setLayoutManager(layoutManager);
        specialBundleRecyclerView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        networkConnection();
    }

    private void networkConnection() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SpecialBlendService service = retrofit.create(SpecialBlendService.class);
        Call<OkcResponse> results = service.listResults();
        results.enqueue(new Callback<OkcResponse>() {
            @Override
            public void onResponse(Call<OkcResponse> call, Response<OkcResponse> response) {
                dataList.addAll(response.body().getData());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<OkcResponse> call, Throwable t) {
                Toast.makeText(getContext(), t + "", Toast.LENGTH_LONG);
            }
        });
    }
}
