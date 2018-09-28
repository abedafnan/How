package com.brightstars.android.how;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText oldPassField;
    EditText newPassField;
    EditText confirmPassField;
    String oldPass;
    String newPass;
    String confirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        oldPassField = findViewById(R.id.current_password_field);
        newPassField = findViewById(R.id.new_password_field);
        confirmPassField = findViewById(R.id.confirm_password_field);

        Toolbar toolbar = findViewById(R.id.change_pass_toolbar);
        setSupportActionBar(toolbar);
        // Displaying the back arrow
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Setting the title of the toolbar
        getSupportActionBar().setTitle("Change Password");
    }

    public boolean checkPasswordMatch() {
        newPass = newPassField.getText().toString().trim();
        confirmPass = confirmPassField.getText().toString().trim();

        return newPass.equals(confirmPass);
    }

    // Code for the back arrow
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    // Inflating the option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.change_pass_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_done) {
            finish(); // temporary
        }
        return super.onOptionsItemSelected(item);
    }
}
