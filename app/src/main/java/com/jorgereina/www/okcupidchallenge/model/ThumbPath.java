package com.jorgereina.www.okcupidchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgereina on 3/5/18.
 */

public class ThumbPath {

    @SerializedName("large")
    @Expose
    private String large;

    @SerializedName("desktop_match")
    @Expose
    private String desktopMatch;

    @SerializedName("mediume")
    @Expose
    private String medium;

    @SerializedName("small")
    @Expose
    private String small;

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getDesktopMatch() {
        return desktopMatch;
    }

    public void setDesktopMatch(String desktopMatch) {
        this.desktopMatch = desktopMatch;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }
}
