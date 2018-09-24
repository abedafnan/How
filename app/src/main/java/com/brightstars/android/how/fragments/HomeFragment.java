package com.brightstars.android.how.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.brightstars.android.how.R;

/**
 * Created by Afnan A. A. Abed on 9/24/2018.
 */

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        if (getArguments() != null) {
            Bundle bundle = getArguments();
            String name = bundle.getString("key_name");

            Toast.makeText(getContext(), "You are in " + name, Toast.LENGTH_SHORT).show();
        }

        return view;
    }
}
