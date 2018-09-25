package com.brightstars.android.how;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.brightstars.android.how.data.Item;
import com.brightstars.android.how.recyclerAdapters.RecyclerAdapterDetails;

import java.util.ArrayList;

import static com.brightstars.android.how.fragments.HomeFragment.ITEM_CATEGORY_CHOOSED;

public class DetailsActivity extends AppCompatActivity {
    ArrayList<Item> items;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.details_toolbar);
        toolbar.setTitle("Categories");
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        String itemCategoryChoosed = bundle.getString(ITEM_CATEGORY_CHOOSED);

        switch (itemCategoryChoosed){
            case ("Electrician"):
                items = getElectronicItems();
                break;

            case ("Computer"):
                items=getComputerItems();
                break;

            case ("Phone"):
                items=getPhoneItems();
                break;

            case ("Carpenter"):
                items=getCarpenterItems();
                break;

            case ("Plumbing"):
                items=getPlumbingItems();
                break;

            case ("Painting"):
                items=getPaintingItems();
                break;
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView_detilsCategory);

        ;
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayout.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapterDetails adapter = new RecyclerAdapterDetails(this, items, new RecyclerAdapterDetails.CustomItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {

                String itemChoosed = items.get(position).getTitle();
                for(int x = 0 ; x<items.size() ; x++){
                    if (getCarpenterItems().get(x).getTitle().equals(itemChoosed)){
                        Toast.makeText(DetailsActivity.this,itemChoosed,Toast.LENGTH_LONG).show();
                        // open the video which user choosed
                    }else {
                        continue;
                    }
                }
            }
        });
        recyclerView.setAdapter(adapter);

    }

    //  To call one of them when he choose a specific item of category
    public ArrayList<Item> getCarpenterItems(){
        ArrayList<Item> categoryItems = new ArrayList<>();
        categoryItems.add(new Item("Carpenter1"));
        categoryItems.add(new Item("Carpenter2"));
        categoryItems.add(new Item("Carpenter3"));
        categoryItems.add(new Item("Carpenter4"));
        categoryItems.add(new Item("Carpenter5"));
        categoryItems.add(new Item("Carpenter6"));

        return categoryItems;

    }
    public ArrayList<Item> getComputerItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("computer1"));
        items.add(new Item("computer2"));
        items.add(new Item("computer3"));
        items.add(new Item("computer4"));
        items.add(new Item("computer5"));
        items.add(new Item("computer6"));
        return items;
    }
    public ArrayList<Item> getElectronicItems(){
        ArrayList<Item> categoryItems = new ArrayList<>();
        categoryItems.add(new Item("Electronic1"));
        categoryItems.add(new Item("Electronic2"));
        categoryItems.add(new Item("Electronic3"));
        categoryItems.add(new Item("Electronic4"));
        categoryItems.add(new Item("Electronic5"));
        categoryItems.add(new Item("Electronic6"));

        return categoryItems;
    }
    public ArrayList<Item> getPaintingItems(){
        ArrayList<Item> phoneItems = new ArrayList<>();
        phoneItems.add(new Item("painting1"));
        phoneItems.add(new Item("painting2"));
        phoneItems.add(new Item("painting3"));
        phoneItems.add(new Item("painting5"));
        phoneItems.add(new Item("painting6"));
        phoneItems.add(new Item("painting7"));

        return phoneItems;
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
