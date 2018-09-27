package com.brightstars.android.how.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.brightstars.android.how.R;
import com.brightstars.android.how.adapters.AdapterListNotification;
import com.brightstars.android.how.models.Item;
import com.brightstars.android.how.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Afnan A. A. Abed on 9/24/2018.
 */

public class NotificationsFragment extends Fragment {

    private ListView listView;
    private List<Item> notifications;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        listView = view.findViewById(R.id.ListView_notification);
        notifications = getAllNotifications();
        AdapterListNotification adapter = new AdapterListNotification
                (getContext(), R.layout.fragment_notifications, notifications);
        listView.setAdapter(adapter);


        return view;
    }

    // TODO: get the notifications from API and put them in the list
    public static List<Item> getAllNotifications() {
        List<Item> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            users.add(new Item("Notification" + i));
        }
        return users;
    }
}
