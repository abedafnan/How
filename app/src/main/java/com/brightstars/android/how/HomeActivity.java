package com.brightstars.android.how;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.iid.FirebaseInstanceId;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);

        // Setting the title of the toolbar
        getSupportActionBar().setTitle("Home");

        // Will be sent to server with the user's register info
        Log.d("TOKEN", FirebaseInstanceId.getInstance().getToken());
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
            case R.id.action_account:

            case R.id.action_settings:

            case R.id.action_terms_privacy:

            case R.id.action_help_feedback:

            case R.id.action_sign_out:
        }

        return super.onOptionsItemSelected(item);
    }

    // Go to the SearchActivity
    public void search() {
        Intent intent = new Intent(HomeActivity.this, SearchActivity.class);
        startActivity(intent);
    }

}
