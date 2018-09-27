package com.brightstars.android.how;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.brightstars.android.how.adapters.AdapterListNotification;
import com.brightstars.android.how.models.Item;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity {

    private ListView commentsListView;
    private List<Item> commentsList;
    private AdapterListNotification commentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent intent = getIntent();
        String videoName = intent.getStringExtra("key_video_name");

        Toolbar toolbar = findViewById(R.id.video_toolbar);
        setSupportActionBar(toolbar);
        // Displaying the back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Setting the title of the toolbar
        getSupportActionBar().setTitle(videoName);

        playVideo("6JYIGclVQdw");


        commentsListView = findViewById(R.id.comments_listView);
        commentsList = getAllCooments();
        commentsAdapter = new AdapterListNotification(this, R.layout.activity_video, commentsList);
        commentsListView.setAdapter(commentsAdapter);
    }

    public void playVideo(final String videoId) {
        YouTubePlayerView youtubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youtubePlayerView);

        youtubePlayerView.initialize(new YouTubePlayerInitListener() {
            @Override
            public void onInitSuccess(@NonNull final YouTubePlayer initializedYouTubePlayer) {
                initializedYouTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady() {
                        initializedYouTubePlayer.loadVideo(videoId, 0);
                    }
                });
            }
        }, true);
    }

    // Code for the back arrow
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    // TODO: get the comments from API and put them in the list
    public static List<Item> getAllCooments() {
        List<Item> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            users.add(new Item("Comment " + i));
        }
        return users;
    }
}
