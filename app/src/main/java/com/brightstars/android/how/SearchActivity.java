package com.brightstars.android.how;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Find the views
        searchView = findViewById(R.id.search_view);
        listView = findViewById(R.id.search_list);

        // Create the list that will contain video tags to search from
        ArrayList<String> videoTags = new ArrayList<>();
        // Here we will get the tags data from the server
        videoTags.add("test");
        videoTags.add("test");
        videoTags.add("test");

        // Create the adapter and set it to the list
        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, videoTags);
        listView.setAdapter(adapter);

        // Action of clicking on the list item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(SearchActivity.this, "Item clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // TODO: Implement filtering elements according to user input
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                String text = newText;
//                adapter.filter(text);
//                return false;}
//        });
    }

}
