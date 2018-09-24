package com.brightstars.android.how;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class HelpFeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_feedback);

        Toolbar toolbar = findViewById(R.id.help_feedback_toolbar);
        setSupportActionBar(toolbar);
        // Displaying the back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Setting the title of the toolbar
        getSupportActionBar().setTitle("Help & Feedback");
    }

    // Code for the back arrow
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
