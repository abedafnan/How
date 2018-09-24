package com.brightstars.android.how.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.brightstars.android.how.R;
import com.brightstars.android.how.models.Item;
import com.brightstars.android.how.recyclerAdapters.RecyclerAdapterCategory;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    // key for intent when he move the details activity to carry the kind item he choosed :
    public static final String ITEM_CATEGORY_CHOOSED = "itemChosen";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // UI :
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        final RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView_categories);

        // Data set :
        final ArrayList<Item> categoryItem = getCategoryItems();

        // customizing the layout manager :
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapterCategory recyclerAdapterCategory = new RecyclerAdapterCategory(categoryItem,
                new RecyclerAdapterCategory.CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                String itemChosen = categoryItem.get(position).getTitle();
                Toast.makeText(getContext(), itemChosen, Toast.LENGTH_LONG).show();

            }
        });
        recyclerView.setAdapter(recyclerAdapterCategory);


        if (getArguments() != null) {
            Bundle bundle = getArguments();
            String name = bundle.getString("key_name");
            Toast.makeText(getContext(), "You are in " + name, Toast.LENGTH_SHORT).show();
        }

        return rootView;
    }

    // The category Items :
    public ArrayList<Item> getCategoryItems() {
        ArrayList<Item> categoryItems = new ArrayList<>();
        categoryItems.add(new Item("Electrician"));
        categoryItems.add(new Item("Computer"));
        categoryItems.add(new Item("Phone"));
        categoryItems.add(new Item("Carpenter"));
        categoryItems.add(new Item("Plumbing"));
        categoryItems.add(new Item("Painting"));
        return categoryItems;
    }

}
