package com.brightstars.android.how.models;

/**
 * Created by Afnan A. A. Abed on 9/28/2018.
 */

public class AccountItem {

    private int icon;
    private String title;
    private int videoCount;

    public AccountItem(int icon, String title, int videoCount) {
        this.icon = icon;
        this.title = title;
        this.videoCount = videoCount;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }
}
