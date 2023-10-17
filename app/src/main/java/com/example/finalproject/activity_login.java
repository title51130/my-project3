package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.Toolbar;

public class activity_login extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            EditText userIDEditText = findViewById(R.id.user_id_edit);
            EditText passwordEditText = findViewById(R.id.user_password_edit);
            Button loginButton = findViewById(R.id.btn_login);
            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String userID = userIDEditText.getText().toString().trim();
                    String password = passwordEditText.getText().toString().trim();

                    if (userID.isEmpty() || password.isEmpty()) {
                        showErrorPopup("Please enter UserID and password");
                    } else {
                        // Perform login logic
                        Intent intent = new Intent(activity_login.this, HomePageActivity.class);
                        intent.putExtra("userID", userID);
                        startActivity(intent);
                    }
                }
            });
    }
    private void showErrorPopup(String errorMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View popupView = getLayoutInflater().inflate(R.layout.layout_error_popup, null);
        TextView errorMessageTextView = popupView.findViewById(R.id.error_message);
        Button dismissButton = popupView.findViewById(R.id.error_dismiss_button);

        errorMessageTextView.setText(errorMessage);

        builder.setView(popupView);
        AlertDialog dialog = builder.create();
        dialog.show();

        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}

