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

import com.brightstars.android.how.DetailsActivity;
import com.brightstars.android.how.R;
import com.brightstars.android.how.models.Item;
import com.brightstars.android.how.recyclerAdapters.RecyclerAdapterCategory;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    // RecyclerViews
    private RecyclerView categoriesRecyclerView;
    private RecyclerView interestsRecyclerView;
    private RecyclerView mostWatchedRecyclerView;
    private RecyclerView suggestionsRecyclerView;
    // ArrayLists
    private ArrayList<Item> categoryItems;
    private ArrayList<Item> interestsItems;
    private ArrayList<Item> suggestionItems;
    private ArrayList<Item> mostWatchedItems;
    // Adapters
    private RecyclerAdapterCategory recyclerAdapterCategory;
    private RecyclerAdapterCategory recyclerAdapterInterests;
    private RecyclerAdapterCategory recyclerAdapterMostWatched;
    private RecyclerAdapterCategory recyclerAdapterSuggestions;

    // key for intent when he move the details activity to carry the kind item he chose :
    public static final String ITEM_CATEGORY_CHOOSED = "itemChosen";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // UI : Finding views
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        categoriesRecyclerView = rootView.findViewById(R.id.recyclerView_categories);
        interestsRecyclerView = rootView.findViewById(R.id.recyclerView_interests);
        mostWatchedRecyclerView = rootView.findViewById(R.id.recyclerView_most_watched);
        suggestionsRecyclerView = rootView.findViewById(R.id.recyclerView_suggestions);

        // Data set : Getting data
        categoryItems = getCategoryItems();
        interestsItems = getInterestsItems();
        mostWatchedItems = getMostWatchedItems();
        suggestionItems = getSuggestionItems();

        // Customizing the layout managers
        categoriesRecyclerView.setLayoutManager(getLayoutManger());
        interestsRecyclerView.setLayoutManager(getLayoutManger());
        mostWatchedRecyclerView.setLayoutManager(getLayoutManger());
        suggestionsRecyclerView.setLayoutManager(getLayoutManger());

        // Setting the adapters
        categoriesRecyclerView.setAdapter(getCategoryAdapter());
        interestsRecyclerView.setAdapter(getInterestsAdapter());
        mostWatchedRecyclerView.setAdapter(getMostWatchedAdapter());
        suggestionsRecyclerView.setAdapter(getSuggestionAdapter());

        return rootView;
    }

    public RecyclerView.LayoutManager getLayoutManger() {
        return new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
    }

    public RecyclerAdapterCategory getCategoryAdapter() {
        recyclerAdapterCategory = new RecyclerAdapterCategory(categoryItems,
                new RecyclerAdapterCategory.CustomItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String itemChosen = categoryItems.get(position).getTitle();
                        Toast.makeText(getContext(), itemChosen, Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getContext(),DetailsActivity.class);
                        intent.putExtra(ITEM_CATEGORY_CHOOSED,itemChosen);
                        getContext().startActivity(intent);
                    }
                });
        return recyclerAdapterCategory;
    }

    public RecyclerAdapterCategory getInterestsAdapter() {
        recyclerAdapterInterests = new RecyclerAdapterCategory(categoryItems,
                new RecyclerAdapterCategory.CustomItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String itemChosen = interestsItems.get(position).getTitle();
                        Toast.makeText(getContext(), itemChosen, Toast.LENGTH_LONG).show();
                    }
                });
        return recyclerAdapterInterests;
    }

    public RecyclerAdapterCategory getMostWatchedAdapter() {
        recyclerAdapterMostWatched = new RecyclerAdapterCategory(categoryItems,
                new RecyclerAdapterCategory.CustomItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String itemChosen = mostWatchedItems.get(position).getTitle();
                        Toast.makeText(getContext(), itemChosen, Toast.LENGTH_LONG).show();
                    }
                });
        return recyclerAdapterMostWatched;
    }

    public RecyclerAdapterCategory getSuggestionAdapter() {
        recyclerAdapterSuggestions = new RecyclerAdapterCategory(categoryItems,
                new RecyclerAdapterCategory.CustomItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String itemChosen = suggestionItems.get(position).getTitle();
                        Toast.makeText(getContext(), itemChosen, Toast.LENGTH_LONG).show();
                    }
                });
        return recyclerAdapterSuggestions;
    }


    // The category Items :
    public ArrayList<Item> getCategoryItems() {
        categoryItems = new ArrayList<>();
        categoryItems.add(new Item("Electrician"));
        categoryItems.add(new Item("Computer"));
        categoryItems.add(new Item("Phone"));
        categoryItems.add(new Item("Carpenter"));
        categoryItems.add(new Item("Plumbing"));
        categoryItems.add(new Item("Painting"));

        return categoryItems;
    }

    public ArrayList<Item> getInterestsItems() {
        interestsItems = new ArrayList<>();
        interestsItems.add(new Item("Electrician"));
        interestsItems.add(new Item("Computer"));
        interestsItems.add(new Item("Phone"));
        interestsItems.add(new Item("Carpenter"));
        interestsItems.add(new Item("Plumbing"));
        interestsItems.add(new Item("Painting"));

        return interestsItems;
    }

    public ArrayList<Item> getMostWatchedItems() {
        mostWatchedItems = new ArrayList<>();
        mostWatchedItems.add(new Item("Electrician"));
        mostWatchedItems.add(new Item("Computer"));
        mostWatchedItems.add(new Item("Phone"));
        mostWatchedItems.add(new Item("Carpenter"));
        mostWatchedItems.add(new Item("Plumbing"));
        mostWatchedItems.add(new Item("Painting"));

        return mostWatchedItems;
    }

    public ArrayList<Item> getSuggestionItems() {
        suggestionItems = new ArrayList<>();
        suggestionItems.add(new Item("Electrician"));
        suggestionItems.add(new Item("Computer"));
        suggestionItems.add(new Item("Phone"));
        suggestionItems.add(new Item("Carpenter"));
        suggestionItems.add(new Item("Plumbing"));
        suggestionItems.add(new Item("Painting"));

        return categoryItems;
    }

}
