package com.brightstars.android.how.models;

import android.widget.ImageView;

public class Item {

    private String image;
    private String title;


    public Item(String title) {
        this.title = title;
    }

    public Item(String title , String image) {
        this.title = title;
        this.image = image;
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


}

