package com.brightstars.android.how.data;

import android.widget.ImageView;

public class Item {

    private ImageView image;
    private String title;


    public Item(String title) {
        this.title = title;
    }

    public Item(String title , ImageView image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }


}

