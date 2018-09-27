package com.brightstars.android.how;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.EditTextPreference;
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

    public static class MainPreferenceFragment extends PreferenceFragment {

        Preference myPref;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);

            // Change password preference click listener
            myPref = findPreference(getString(R.string.key_change_password));
            myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    changePassword();
                    return true;
                }
            });

            // Change password preference click listener
            myPref = findPreference(getString(R.string.key_clear_history));
            myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    clearHistory();
                    return true;
                }
            });

            // gallery EditText change listener
            bindPreferenceSummaryToValue(findPreference(getString(R.string.key_user_name)));

            // gallery EditText change listener
            bindPreferenceSummaryToValue(findPreference(getString(R.string.key_email)));

            // gallery EditText change listener
            bindPreferenceSummaryToValue(findPreference(getString(R.string.key_phone)));
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

        private static void bindPreferenceSummaryToValue(Preference preference) {
            preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

            sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                    PreferenceManager
                            .getDefaultSharedPreferences(preference.getContext())
                            .getString(preference.getKey(), ""));
        }

        private static Preference.OnPreferenceChangeListener
                sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                String stringValue = newValue.toString();

                if (preference instanceof EditTextPreference) {
                    if (preference.getKey().equals("key_user_name")) {
                        // update the changed gallery name to summary filed
                        preference.setSummary(stringValue);
                    } else if (preference.getKey().equals("key_email")) {
                        // update the changed gallery name to summary filed
                        preference.setSummary(stringValue);
                    } else if (preference.getKey().equals("key_phone")) {
                        // update the changed gallery name to summary filed
                        preference.setSummary(stringValue);
                    }
                } else {
                    preference.setSummary(stringValue);
                }
                return true;
            }
        };
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
