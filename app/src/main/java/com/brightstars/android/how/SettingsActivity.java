package com.brightstars.android.how;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SettingsActivity extends AppCompatPreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the toolbar
        setupActionBar();

        // load settings fragment
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MainPreferenceFragment()).commit();
    }

    public static class MainPreferenceFragment extends
            PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

            // Change password click listener
            Preference changePass = findPreference(getString(R.string.key_change_password));
            changePass.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    changePassword();
                    return true;
                }
            });

            // Change password click listener
            Preference clearHistory = findPreference(getString(R.string.key_clear_history));
            clearHistory.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    clearHistory();
                    return true;
                }
            });

            // Find the username, email and phone preferences
            EditTextPreference username = (EditTextPreference) findPreference(getString(R.string.key_user_name));
            EditTextPreference email = (EditTextPreference) findPreference(getString(R.string.key_email));
            EditTextPreference phone = (EditTextPreference) findPreference(getString(R.string.key_phone));

            // Get the saved SharedPreferences and set it in the dialog's EditText
            // TODO: put the user's registered data as the default values
            SharedPreferences getData = PreferenceManager.getDefaultSharedPreferences(getContext());
            username.setText(getData.getString(getString(R.string.key_user_name), "My Username"));
            email.setText(getData.getString(getString(R.string.key_email), "me@example.com"));
            phone.setText(getData.getString(getString(R.string.key_phone), "0123456"));

            // Put the preference value as the summary
            Preference userPref = (EditTextPreference) findPreference(getString(R.string.key_user_name));
            userPref.setSummary(username.getText());
            Preference emailPref = (EditTextPreference) findPreference(getString(R.string.key_email));
            emailPref.setSummary(email.getText());
            Preference phonePref = (EditTextPreference) findPreference(getString(R.string.key_phone));
            phonePref.setSummary(phone.getText());
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            Preference pref = findPreference(key);

            if (pref instanceof EditTextPreference) {
                EditTextPreference editPref = (EditTextPreference) pref;
                pref.setSummary(editPref.getText());
            }
        }

        public void changePassword() {
            Intent intent = new Intent(getContext(), ChangePasswordActivity.class);
            startActivity(intent);
        }

        public void clearHistory() {
            final AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
            dialog.setMessage("Are you sure?");
            dialog.setCancelable(true);

            dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dialog.setNegativeButton("No", null);
            dialog.create().show();
        }
    }

    private void setupActionBar() {
        ViewGroup rootView = (ViewGroup)findViewById(R.id.action_bar_root); //id from appcompat

        if (rootView != null) {
            View view = getLayoutInflater().inflate(R.layout.app_bar_layout, rootView, false);
            rootView.addView(view, 0);

            Toolbar toolbar = (Toolbar)findViewById(R.id.settings_toolbar);
            setSupportActionBar(toolbar);
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Settings");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return false;
    }
}
