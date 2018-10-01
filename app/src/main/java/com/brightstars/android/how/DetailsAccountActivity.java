package com.brightstars.android.how;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.brightstars.android.how.adapters.RecyclerAdapterDetails;
import com.brightstars.android.how.models.Item;

import java.sql.Ref;
import java.util.ArrayList;

public class DetailsAccountActivity extends AppCompatActivity {

    private ArrayList<Item> items;
    private SwipeRefreshLayout refreshLayout;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_account);

        Intent intent = getIntent();
        title = intent.getStringExtra("key_title");

        refreshLayout = findViewById(R.id.refresh_account_details);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDetailItems();
            }
        });

        Toolbar toolbar = findViewById(R.id.account_details_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getDetailItems();

        RecyclerView recyclerView = findViewById(R.id.recyclerView_account_details);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapterDetails adapter = new RecyclerAdapterDetails(items, new RecyclerAdapterDetails.CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String itemChosen = items.get(position).getTitle();
                playVideo(itemChosen);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void getDetailItems() {
        if (title != null) {
            switch (title) {
                case ("My List"):
                    items = getListItems();
                    break;
                case ("Likes"):
                    items = getLikesItems();
                    break;
                case ("Downloads"):
                    items = getDownloadsItems();
                    break;
                case ("History"):
                    items = getHistoryItems();
                    break;
            }
        } else {
            Toast.makeText(DetailsAccountActivity.this,
                    "Error loading items because of NPE", Toast.LENGTH_SHORT).show();
        }
        refreshLayout.setRefreshing(false);
    }

    // It will start the video activity when a RecyclerView item is clicked
    private void playVideo(String videoName) {
        Intent intent = new Intent(this, VideoActivity.class);
        intent.putExtra("key_video_name", videoName);
        // later video id as well
        startActivity(intent);
    }

    public ArrayList<Item> getListItems() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item("list1"));
        list.add(new Item("list2"));
        list.add(new Item("list3"));
        list.add(new Item("list4"));
        list.add(new Item("list5"));
        list.add(new Item("list6"));
        return list;
    }

    public ArrayList<Item> getLikesItems() {
        ArrayList<Item> likes = new ArrayList<>();
        likes.add(new Item("likes1"));
        likes.add(new Item("likes2"));
        likes.add(new Item("likes3"));
        likes.add(new Item("likes4"));
        likes.add(new Item("likes5"));
        likes.add(new Item("likes6"));
        return likes;
    }

    public ArrayList<Item> getDownloadsItems() {
        ArrayList<Item> downloads = new ArrayList<>();
        downloads.add(new Item("downloads1"));
        downloads.add(new Item("downloads2"));
        downloads.add(new Item("downloads3"));
        downloads.add(new Item("downloads4"));
        downloads.add(new Item("downloads5"));
        downloads.add(new Item("downloads6"));
        return downloads;
    }

    public ArrayList<Item> getHistoryItems() {
        ArrayList<Item> history = new ArrayList<>();
        history.add(new Item("history1"));
        history.add(new Item("history2"));
        history.add(new Item("history3"));
        history.add(new Item("history4"));
        history.add(new Item("history5"));
        history.add(new Item("history6"));
        return history;
    }

    // Code for the back arrow
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
