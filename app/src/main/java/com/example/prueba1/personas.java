package com.example.prueba1;

import android.net.Uri;

public class personas {

    private String name;
    private String trys;
    private String time;
    private Uri image;

    public personas() {
    }

    public personas(String name, String trys, String time, Uri image) {
        this.name = name;
        this.trys = trys;
        this.time = time;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrys() {
        return trys;
    }

    public void setTrys(String trys) {
        this.trys = trys;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }
}
