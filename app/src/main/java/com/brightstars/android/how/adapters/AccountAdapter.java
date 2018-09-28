package com.brightstars.android.how.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brightstars.android.how.R;
import com.brightstars.android.how.models.AccountItem;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Afnan A. A. Abed on 9/28/2018.
 */

public class AccountAdapter extends ArrayAdapter<AccountItem> {

    private List<AccountItem> accountItems;

    public AccountAdapter(@NonNull Context context, int resource, List<AccountItem> items) {
        super(context, resource);
        this.accountItems = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AccountItem accountItem = accountItems.get(position);

        AccountAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_account, parent, false);
            viewHolder = new AccountAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (AccountAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.titleTextView.setText(accountItem.getTitle());
        viewHolder.videoCountTextView.setText(accountItem.getVideoCount() + " videos");
        viewHolder.iconImageView.setImageResource(accountItem.getIcon());

        return convertView;
    }


    @Override
    public int getCount() {
        return accountItems.size();
    }


    class ViewHolder {
        TextView titleTextView;
        TextView videoCountTextView;
        ImageView iconImageView;

        public ViewHolder(View rootView) {
            titleTextView = rootView.findViewById(R.id.textView_title);
            videoCountTextView = rootView.findViewById(R.id.textView_count);
            iconImageView = rootView.findViewById(R.id.list_icon);
        }
    }
}
