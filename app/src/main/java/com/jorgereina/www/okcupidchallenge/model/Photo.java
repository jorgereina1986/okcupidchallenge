package com.jorgereina.www.okcupidchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgereina on 2/26/18.
 */

public class Photo {

    @SerializedName("full_paths")
    @Expose
    private FullPath fullPath;

    @SerializedName("thumb_paths")
    @Expose
    private ThumbPath thumbPath;

    public FullPath getFullPath() {
        return fullPath;
    }

    public void setFullPath(FullPath fullPath) {
        this.fullPath = fullPath;
    }

    public ThumbPath getThumbPath() {
        return thumbPath;
    }

    public void setThumbPath(ThumbPath thumbPath) {
        this.thumbPath = thumbPath;
    }
}
