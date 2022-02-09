package com.example.odoo_pos_system.home.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.odoo_pos_system.R;
import com.example.odoo_pos_system.category.ui.fragment_category;
import com.example.odoo_pos_system.home.ui.fragment_main;
import com.example.odoo_pos_system.profile.ui.fragment_profile;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentActivity, fragmentProfile, fragmentCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentActivity= new fragment_main();
        fragmentProfile= new fragment_profile();
        fragmentCategory = new fragment_category();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView, fragmentActivity).commit();
    }

    private void chargeDtoOnProfilePage() {
        Bundle bundle = new Bundle();
        bundle.putString("name", "Enzo");
        bundle.putString("username", getIntent().getStringExtra("username"));
        bundle.putString("db", getIntent().getStringExtra("db"));

        fragment_profile fragment = new fragment_profile();
        fragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView, fragment).commit();
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
            chargeDtoOnProfilePage();
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
