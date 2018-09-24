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
import com.brightstars.android.how.data.Item;
import com.brightstars.android.how.recyclerAdapters.RecyclerAdapterCategory;

import java.util.ArrayList;

/**
 * Created by Afnan A. A. Abed on 9/24/2018.
 */

public class HomeFragment extends Fragment {
    ItemClickListener mCallBack;


    // key for intent when he move the details activiy to carry the kind item he choosed :
    public static final String ITEM_CATEGORY_CHOOSED = "itemChoosed";

    // The category Items :
    public ArrayList<Item> getCategoryItems(){
        ArrayList<Item> categoryItems = new ArrayList<>();
        categoryItems.add(new Item("Electrician"));
        categoryItems.add(new Item("Computer"));
        categoryItems.add(new Item("Phone"));
        categoryItems.add(new Item("Carpenter"));
        categoryItems.add(new Item("Plumbing"));
        categoryItems.add(new Item("Painting"));
        return  categoryItems;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        // UI :
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        final RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView_categories);

        // Data set :
        final ArrayList<Item> categoryItem = getCategoryItems();

        // customizing the layout manager :
        RecyclerView.LayoutManager layoutManager=
                new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL
                        , false);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapterCategory recyclerAdapterCategory = new RecyclerAdapterCategory(getContext()
                ,categoryItem, new RecyclerAdapterCategory.CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                String itemChoosed=categoryItem.get(position).getTitle();
                Toast.makeText(getContext(),itemChoosed,Toast.LENGTH_LONG).show();


        /**
         *
         * this is a true code . uncomment it after prepairing details recycler adapter and details activity
         *
         * :
                  Intent intent;
                String itemChoosed=categoryItem.get(position).getTitle();
                intent = new Intent(getContext(),DetailsActivity.class);
                intent.putExtra(ITEM_CATEGORY_CHOOSED,itemChoosed);
                getContext().startActivity(intent);
        */


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


    public interface ItemClickListener{
        public void onItemClicked(Item item);
    }


    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallBack = (ItemClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }

    }




}
