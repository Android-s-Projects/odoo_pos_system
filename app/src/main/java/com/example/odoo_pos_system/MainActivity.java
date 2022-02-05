package com.example.odoo_pos_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.odoo_pos_system.authentication.ui.LoginActivity;
import com.example.odoo_pos_system.profile.ui.ProfileActivity;
import com.example.odoo_pos_system.profile.ui.activity_profile;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentActivity, fragmentProfile, fragmentCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentActivity= new activity_main();
        fragmentProfile= new activity_profile();
        fragmentCategory = new activity_category();

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView, fragmentActivity).commit();
    }

    private void chargeDtoOnProfilePage() {
        String dtoName = getIntent().getStringExtra("name");
        String dtoUsername = getIntent().getStringExtra("username");
        String dtoDatabase = getIntent().getStringExtra("db");

        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        intent.putExtra("db", dtoDatabase);
        intent.putExtra("name", dtoName);
        intent.putExtra("username", dtoUsername);

        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.fragment_activity_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id =  item.getItemId();
        transaction= getSupportFragmentManager().beginTransaction();

        if(id == R.id.miProfile){
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
            transaction.replace(R.id.fragmentContainerView, fragmentProfile).commit();
            transaction.addToBackStack(null);
        }else if(id == R.id.miHome){
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            transaction.replace(R.id.fragmentContainerView, fragmentActivity).commit();
            transaction.addToBackStack(null);
        }else if(id == R.id.miCategory){
            Toast.makeText(this, "Category", Toast.LENGTH_SHORT).show();
            transaction.replace(R.id.fragmentContainerView, fragmentCategory).commit();
            transaction.addToBackStack(null);
        }
        return super.onOptionsItemSelected(item);
    }
}
