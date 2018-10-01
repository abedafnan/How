package com.brightstars.android.how;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class InterestsActivity extends AppCompatActivity {

    private FloatingActionButton actionButton;
    private Spinner InterestSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);

        actionButton = findViewById(R.id.interests_fab);
        InterestSpinner = findViewById(R.id.interests_spinner);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: send registered interests to server
                Intent intent = new Intent(InterestsActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
