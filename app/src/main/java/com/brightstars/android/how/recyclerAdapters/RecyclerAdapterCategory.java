package com.brightstars.android.how.recyclerAdapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brightstars.android.how.R;
import com.brightstars.android.how.models.Item;

import java.util.ArrayList;

public class RecyclerAdapterCategory extends RecyclerView.Adapter<RecyclerAdapterCategory.ViewHolder> {

    private CustomItemClickListener mCallback;
    private View rootView;
    private ArrayList<Item> mItems;

    public RecyclerAdapterCategory(ArrayList<Item> items, CustomItemClickListener listener) {
        this.mItems = items;
        mCallback = listener;
    }

    @NonNull
    @Override
    public RecyclerAdapterCategory.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        rootView = inflater.inflate(R.layout.item_row_categories, parent, false);

        final ViewHolder viewHolder = new ViewHolder(rootView);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onItemClick(v, viewHolder.getPosition());

            }
        });

        return viewHolder;
    }

    public interface CustomItemClickListener {
        void onItemClick(View view, int position);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterCategory.ViewHolder holder, int position) {
        Item item = mItems.get(position);
        holder.textView_title.setText(item.getTitle());

        // TODO: use picasso library to load images
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView_title;

        // Define what is inside every row
        public ViewHolder(View rootView) {
            super(rootView);
            textView_title = rootView.findViewById(R.id.textView_itemCategory);

        }
    }
}
