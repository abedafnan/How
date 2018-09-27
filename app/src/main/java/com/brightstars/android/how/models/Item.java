package com.brightstars.android.how.models;

import android.widget.ImageView;

public class Item {

    private String image;
    private String title;
    private String time;


    public Item(String title) {
        this.title = title;
    }

    public Item(String title , String image) {
        this.title = title;
        this.image = image;
    }

    public Item(String image, String title, String time) {
        this.image = image;
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

