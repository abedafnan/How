package com.brightstars.android.how.listView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.brightstars.android.how.R;
import com.brightstars.android.how.models.User;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterListNotification extends ArrayAdapter<User> {

    private List<User> users;

    public AdapterListNotification(@NonNull Context context, int resource,List<User> users) {
        super(context, resource);
        this.users = users;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = users.get(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_user, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView_notificationContent.setText(user.getFirstName());

        /**
         * We will use (viewHolder.textView_notificationTime) to get the time from API .
         * We will use (viewHolder.circleImage_profilePicture) to get the image from API.
        */

        return  convertView;
    }


    @Override
    public int getCount() {
        return users.size();
    }



    class ViewHolder{
        TextView textView_notificationContent;
        TextView textView_notificationTime;
        CircleImageView circleImage_profilePicture;
        public ViewHolder(View rootView){
            textView_notificationContent = rootView.findViewById(R.id.textView_name);
            textView_notificationTime=rootView.findViewById(R.id.textView_Time);
            circleImage_profilePicture=rootView.findViewById(R.id.profile_image);
        }
    }
}

