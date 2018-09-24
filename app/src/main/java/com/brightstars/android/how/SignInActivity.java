package com.brightstars.android.how;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void signIn2(View view) {
        // temporary for testing
        // TODO: implement the backstack
        Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
