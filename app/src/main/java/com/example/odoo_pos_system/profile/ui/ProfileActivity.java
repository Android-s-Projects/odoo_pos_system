package com.example.odoo_pos_system.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.odoo_pos_system.R;
import com.example.odoo_pos_system.authentication.ui.LoginActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView dtoName = findViewById(R.id.tvDtoName);
        TextView dtoUsername = findViewById(R.id.tvDtoUsername);
        TextView dtoDatabase = findViewById(R.id.tvDtoDatabase);

        if(getIntent().getStringExtra("name") != null || getIntent().getStringExtra("username") != null || getIntent().getStringExtra("db") != null){
            dtoName.setText(getIntent().getStringExtra("name"));
            dtoUsername.setText(getIntent().getStringExtra("username"));
            dtoDatabase.setText(getIntent().getStringExtra("db"));
        }else{
            dtoName.setText("data could not be loaded");
            dtoUsername.setText("data could not be loaded");
            dtoDatabase.setText("data could not be loaded");
        }
    }
}
