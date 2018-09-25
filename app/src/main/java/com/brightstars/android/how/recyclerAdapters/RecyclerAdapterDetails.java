package com.brightstars.android.how.recyclerAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brightstars.android.how.R;
import com.brightstars.android.how.models.Item;

import java.util.ArrayList;
import java.util.List;

    public class RecyclerAdapterDetails extends RecyclerView.Adapter<RecyclerAdapterDetails.ViewHolder> {

        private CustomItemClickListener mCallback;
        private View rootView;
        private ArrayList<Item> mItem;
        int positionItem;

        public RecyclerAdapterDetails(ArrayList<Item> items, CustomItemClickListener listener) {
            this.mItem = items;
            mCallback = listener;
        }

        @NonNull
        @Override
        public RecyclerAdapterDetails.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            rootView = inflater.inflate(R.layout.item_row_details, parent, false);

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
        public void onBindViewHolder(@NonNull RecyclerAdapterDetails.ViewHolder holder, int position) {

            Item item = mItem.get(position);
            holder.textView_title.setText(item.getTitle());

        }

        @Override
        public int getItemCount() {
            return mItem.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView_title;
            TextView textView_time;
            ImageView imageView_item;


            // to define what is inside every row :
            public ViewHolder(View rootView) {
                super(rootView);
                imageView_item = rootView.findViewById(R.id.item_video_image);
                textView_title = rootView.findViewById(R.id.item_video_name);
                textView_time = rootView.findViewById(R.id.item_video_time);
            }
        }

    }


