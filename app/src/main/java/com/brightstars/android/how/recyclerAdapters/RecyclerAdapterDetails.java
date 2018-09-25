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
import com.brightstars.android.how.data.Item;

import java.util.ArrayList;
import java.util.List;

    public class RecyclerAdapterDetails  extends RecyclerView.Adapter<RecyclerAdapterDetails.ViewHolder> {

        CustomItemClickListener mCallback;
        Context mContext;
        View rootView;
        private List<Item> mItem;
        int positionItem;

        public RecyclerAdapterDetails(Context mContext, ArrayList<Item> items, CustomItemClickListener listener) {
            this.mItem = items;
            this.mContext = mContext;
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

            positionItem=position;
            Item item = mItem.get(position);
            holder.imageView_name_item.setText(item.getTitle());

        }

        @Override
        public int getItemCount() {
            return mItem.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView imageView_video_image;
            TextView textView_video_time;
            TextView imageView_name_item;


            // to define what is inside every row :
            public ViewHolder(View rootView) {
                super(rootView);
                imageView_video_image = rootView.findViewById(R.id.item_video_image);
                imageView_name_item = rootView.findViewById(R.id.item_video_name);
                textView_video_time = rootView.findViewById(R.id.item_video_time);
            }
        }



    }


