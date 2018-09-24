package com.brightstars.android.how;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.brightstars.android.how.models.Item;
import com.brightstars.android.how.fragments.AccountFragment;
import com.brightstars.android.how.fragments.HomeFragment;
import com.brightstars.android.how.fragments.NotificationsFragment;
import com.google.firebase.iid.FirebaseInstanceId;

public class HomeActivity extends AppCompatActivity {

    Bundle bundle = new Bundle();
    Fragment fragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    bundle.putString("key_name", "Home");
                    fragment.setArguments(bundle);
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_account:
                    fragment = new AccountFragment();
                    bundle.putString("key_name", "Account");
                    fragment.setArguments(bundle);
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_notifications:
                    fragment = new NotificationsFragment();
                    bundle.putString("key_name", "Notifications");
                    fragment.setArguments(bundle);
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("How ?");

        // Will be sent to server with the user's register info
        Log.d("TOKEN", FirebaseInstanceId.getInstance().getToken());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Set the home fragment as the default one
        Fragment homeFragment = new HomeFragment();
        loadFragment(homeFragment);
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    // Inflating the option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // When a menu item is pressed
        switch (id) {
            case R.id.action_search:
                search();
                break;
            case R.id.action_settings:
                settings();
                break;
            case R.id.action_terms_privacy:
                privacyAndTerms();
                break;
            case R.id.action_help_feedback:
                helpAndFeedback();
                break;
            case R.id.action_sign_out:
                signOut();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    // Go to the SearchActivity
    private void search() {
        Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
        startActivity(intent);
    }

    private void settings() {
        Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
        startActivity(intent);
    }
    private void privacyAndTerms() {
        Intent intent = new Intent(HomeActivity.this, TermsPrivacyActivity.class);
        startActivity(intent);
    }
    private void helpAndFeedback() {
        Intent intent = new Intent(HomeActivity.this, HelpFeedbackActivity.class);
        startActivity(intent);
    }
    private void signOut() {
        // TODO: edit the loggedIn shared preferences
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

}
