package com.jorgereina.www.okcupidchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jorgereina on 2/26/18.
 */

public class Data {

    // image / name / age / city / match percentage

    @SerializedName("location")
    @Expose
    private Location location;

    @SerializedName("photo")
    @Expose
    private Photo photo;

    @SerializedName("age")
    @Expose
    private int age;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("match")
    @Expose
    private int match;

    private boolean isClicked = false;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMatch() {
        return match;
    }

    public void setMatch(int match) {
        this.match = match;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}
