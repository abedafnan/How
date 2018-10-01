package com.brightstars.android.how;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.brightstars.android.how.models.Item;
import com.brightstars.android.how.adapters.RecyclerAdapterDetails;

import java.util.ArrayList;

import static com.brightstars.android.how.fragments.HomeFragment.ITEM_CATEGORY_CHOOSED;

public class DetailsActivity extends AppCompatActivity {

    private ArrayList<Item> items;
    private SwipeRefreshLayout refreshLayout;
    private String itemCategoryChosen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        itemCategoryChosen = bundle.getString(ITEM_CATEGORY_CHOOSED);

        refreshLayout = findViewById(R.id.refresh_details);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDetailItems();
            }
        });

        Toolbar toolbar = findViewById(R.id.details_toolbar);
        setSupportActionBar(toolbar);
        // Displaying the back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Setting the title of the toolbar
        getSupportActionBar().setTitle(itemCategoryChosen);

        getDetailItems();

        RecyclerView recyclerView = findViewById(R.id.recyclerView_detilsCategory);
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
        if (itemCategoryChosen != null) {
            switch (itemCategoryChosen) {
                case ("Electronics"):
                    items = getElectronicItems();
                    break;
                case ("Computer"):
                    items = getComputerItems();
                    break;
                case ("Phone"):
                    items = getPhoneItems();
                    break;
                case ("Carpentering"):
                    items = getCarpenterItems();
                    break;
                case ("Plumbing"):
                    items = getPlumbingItems();
                    break;
                case ("Painting"):
                    items = getPaintingItems();
                    break;
            }
        } else {
            Toast.makeText(DetailsActivity.this,
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

    // Code for the back arrow
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    //  To call one of them when he choose a specific item of category
    public ArrayList<Item> getCarpenterItems(){
        ArrayList<Item> carpenterItems = new ArrayList<>();
        carpenterItems.add(new Item("Carpenter1"));
        carpenterItems.add(new Item("Carpenter2"));
        carpenterItems.add(new Item("Carpenter3"));
        carpenterItems.add(new Item("Carpenter4"));
        carpenterItems.add(new Item("Carpenter5"));
        carpenterItems.add(new Item("Carpenter6"));
        return carpenterItems;
    }
    public ArrayList<Item> getComputerItems() {
        ArrayList<Item> computerItems = new ArrayList<>();
        computerItems.add(new Item("computer1"));
        computerItems.add(new Item("computer2"));
        computerItems.add(new Item("computer3"));
        computerItems.add(new Item("computer4"));
        computerItems.add(new Item("computer5"));
        computerItems.add(new Item("computer6"));
        return computerItems;
    }
    public ArrayList<Item> getElectronicItems(){
        ArrayList<Item> electronicItems = new ArrayList<>();
        electronicItems.add(new Item("Electronic1"));
        electronicItems.add(new Item("Electronic2"));
        electronicItems.add(new Item("Electronic3"));
        electronicItems.add(new Item("Electronic4"));
        electronicItems.add(new Item("Electronic5"));
        electronicItems.add(new Item("Electronic6"));
        return electronicItems;
    }
    public ArrayList<Item> getPaintingItems(){
        ArrayList<Item> paintingItems = new ArrayList<>();
        paintingItems.add(new Item("painting1"));
        paintingItems.add(new Item("painting2"));
        paintingItems.add(new Item("painting3"));
        paintingItems.add(new Item("painting5"));
        paintingItems.add(new Item("painting6"));
        paintingItems.add(new Item("painting7"));
        return paintingItems;
    }
    public ArrayList<Item> getPhoneItems(){
        ArrayList<Item> phoneItems = new ArrayList<>();
        phoneItems.add(new Item("phone1"));
        phoneItems.add(new Item("phone2"));
        phoneItems.add(new Item("phone3"));
        phoneItems.add(new Item("phone4"));
        phoneItems.add(new Item("phone5"));
        phoneItems.add(new Item("phone6"));
        return phoneItems;
    }
    public ArrayList<Item> getPlumbingItems(){
        ArrayList<Item> plumbingItems = new ArrayList<>();
        plumbingItems.add(new Item("plumbing1"));
        plumbingItems.add(new Item("plumbing2"));
        plumbingItems.add(new Item("plumbing3"));
        plumbingItems.add(new Item("plumbing4"));
        plumbingItems.add(new Item("plumbing5"));
        plumbingItems.add(new Item("plumbing6"));
        return plumbingItems;
    }
}
