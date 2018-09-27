package com.brightstars.android.how.recyclerAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.brightstars.android.how.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Afnan A. A. Abed on 9/27/2018.
 */

public class SearchAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;
    private List<String> videoTagsList = null;
    private ArrayList<String> arrayList;

    public SearchAdapter(Context context, ArrayList<String> videoTagsList) {
        mContext = context;
        this.videoTagsList = videoTagsList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<>();
        this.arrayList.addAll(videoTagsList);
    }

    public class ViewHolder {
        TextView tag;
    }

    @Override
    public int getCount() {
        return videoTagsList.size();
    }

    @Override
    public String getItem(int position) {
        return videoTagsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(android.R.layout.simple_list_item_1, null);
            holder.tag = view.findViewById(android.R.id.text1);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        
        // Set the results into TextViews
        holder.tag.setText(videoTagsList.get(position));
        return view;
    }

    // Filter the list according to the user input
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        videoTagsList.clear();
        if (charText.length() == 0) {
            videoTagsList.addAll(arrayList);
        } else {
            for (String string : arrayList) {
                if (string.toLowerCase(Locale.getDefault()).contains(charText)) {
                    videoTagsList.add(string);
                }
            }
        }
        notifyDataSetChanged();
    }
}
