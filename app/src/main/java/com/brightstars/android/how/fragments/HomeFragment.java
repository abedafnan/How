package com.brightstars.android.how.fragments;

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
import com.brightstars.android.how.VideoActivity;
import com.brightstars.android.how.models.Item;
import com.brightstars.android.how.adapters.RecyclerAdapterCategory;

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
                        // Go to the categories' details
                        Intent intent = new Intent(getContext(), DetailsActivity.class);
                        intent.putExtra(ITEM_CATEGORY_CHOOSED, itemChosen);
                        startActivity(intent);
                    }
                });
        return recyclerAdapterCategory;
    }

    public RecyclerAdapterCategory getInterestsAdapter() {
        recyclerAdapterInterests = new RecyclerAdapterCategory(interestsItems,
                new RecyclerAdapterCategory.CustomItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String itemChosen = interestsItems.get(position).getTitle();
                        // open video screen
                        Intent intent = new Intent(getContext(), VideoActivity.class);
                        intent.putExtra("key_video_name", itemChosen); // video name to be taken from API
                        startActivity(intent);
                    }
                });
        return recyclerAdapterInterests;
    }

    public RecyclerAdapterCategory getMostWatchedAdapter() {
        recyclerAdapterMostWatched = new RecyclerAdapterCategory(mostWatchedItems,
                new RecyclerAdapterCategory.CustomItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String itemChosen = mostWatchedItems.get(position).getTitle();
                        // open video screen
                        Intent intent = new Intent(getContext(), VideoActivity.class);
                        intent.putExtra("key_video_name", itemChosen);
                        startActivity(intent);
                    }
                });
        return recyclerAdapterMostWatched;
    }

    public RecyclerAdapterCategory getSuggestionAdapter() {
        recyclerAdapterSuggestions = new RecyclerAdapterCategory(suggestionItems,
                new RecyclerAdapterCategory.CustomItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String itemChosen = suggestionItems.get(position).getTitle();
                        // open video screen
                        Intent intent = new Intent(getContext(), VideoActivity.class);
                        intent.putExtra("key_video_name", itemChosen);
                        startActivity(intent);
                    }
                });
        return recyclerAdapterSuggestions;
    }

    // The category Items :
    public ArrayList<Item> getCategoryItems() {
        categoryItems = new ArrayList<>();
        categoryItems.add(new Item("Electronics"));
        categoryItems.add(new Item("Computer"));
        categoryItems.add(new Item("Phone"));
        categoryItems.add(new Item("Carpentering"));
        categoryItems.add(new Item("Plumbing"));
        categoryItems.add(new Item("Painting"));

        return categoryItems;
    }

    public ArrayList<Item> getInterestsItems() {
        interestsItems = new ArrayList<>();
        interestsItems.add(new Item("Video1"));
        interestsItems.add(new Item("Video2"));
        interestsItems.add(new Item("Video3"));
        interestsItems.add(new Item("Video4"));
        interestsItems.add(new Item("Video5"));
        interestsItems.add(new Item("Video6"));

        return interestsItems;
    }

    public ArrayList<Item> getMostWatchedItems() {
        mostWatchedItems = new ArrayList<>();
        mostWatchedItems.add(new Item("Video1"));
        mostWatchedItems.add(new Item("Video2"));
        mostWatchedItems.add(new Item("Video3"));
        mostWatchedItems.add(new Item("Video4"));
        mostWatchedItems.add(new Item("Video5"));
        mostWatchedItems.add(new Item("Video6"));

        return mostWatchedItems;
    }

    public ArrayList<Item> getSuggestionItems() {
        suggestionItems = new ArrayList<>();
        suggestionItems.add(new Item("Video1"));
        suggestionItems.add(new Item("Video2"));
        suggestionItems.add(new Item("Video3"));
        suggestionItems.add(new Item("Video4"));
        suggestionItems.add(new Item("Video5"));
        suggestionItems.add(new Item("Video6"));

        return suggestionItems;
    }

}
