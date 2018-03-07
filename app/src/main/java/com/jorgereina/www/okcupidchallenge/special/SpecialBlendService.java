package com.jorgereina.www.okcupidchallenge.special;

import com.jorgereina.www.okcupidchallenge.model.OkcResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jorgereina on 2/26/18.
 */

public interface SpecialBlendService {
    @GET("matchSample.json")
    Call<OkcResponse> listResults();
}
