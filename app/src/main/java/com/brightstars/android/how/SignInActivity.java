package com.brightstars.android.how;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {

    String mEmail;
    String mPassword;
    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailField = findViewById(R.id.email_edit_text);
        passwordField = findViewById(R.id.password_edit_text);

        Intent intent = getIntent();
        mEmail = intent.getStringExtra("email");
        emailField.setText(mEmail);
    }

    public void signIn(View view) {
        // temporary for testing
        // TODO: user input validation
        Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void signUp(View view) {
        Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    public void resetPassword(View view) {
        Intent intent = new Intent(SignInActivity.this, ForgotPassActivity.class);
        startActivity(intent);
    }

}
