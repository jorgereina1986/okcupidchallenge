package com.jorgereina.www.okcupidchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgereina on 2/26/18.
 */

public class Location {

    @SerializedName("city_name")
    @Expose
    private String city;

    @SerializedName("state_code")
    @Expose
    private String stateCode;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
}
