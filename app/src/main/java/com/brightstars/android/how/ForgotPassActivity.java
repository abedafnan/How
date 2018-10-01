package com.brightstars.android.how;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgotPassActivity extends AppCompatActivity {

    private EditText emailResetField;
    private Button emailResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);

        emailResetField = findViewById(R.id.email_reset_editText);
        emailResetButton = findViewById(R.id.email_reset_button);

        String email = emailResetField.getText().toString().trim();

        emailResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInput()) {
                    finish();
                }
            }
        });
    }

    public boolean checkInput() {
        // Input validation
        return true;
    }
}
