package com.brightstars.android.how;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.gms.signin.SignIn;

public class SignUpActivity extends AppCompatActivity {

    private EditText firstNameField;
    private EditText lastNameField;
    private EditText emailField;
    private EditText phoneField;
    private EditText passwordField;
    private CheckBox checkBox;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstNameField = findViewById(R.id.input_first_name);
        lastNameField = findViewById(R.id.input_last_name);
        emailField = findViewById(R.id.input_email_address);
        phoneField = findViewById(R.id.input_phone_number);
        passwordField = findViewById(R.id.input_password);
        checkBox = findViewById(R.id.checkBox);
        signUpButton = findViewById(R.id.button_signUp2);
    }

    // TODO: send data entered by the user to the server

    public void checkTerms(View view) {
        Intent intent = new Intent(this, TermsPrivacyActivity.class);
        startActivity(intent);
    }

    public boolean checkTermsAgreement(){
        if (checkBox.isChecked()) {
            return true;
        } else {
            checkBox.setError("Must agree to the privacy terms");
        }
        return false;
    }

    public void signUp(View view) {
        if (checkTermsAgreement()) {
            String email = emailField.getText().toString().trim();
            Intent intent = new Intent(this, SignInActivity.class);
            intent.putExtra("email", email);
            startActivity(intent);
            finish();
        }
    }
}
