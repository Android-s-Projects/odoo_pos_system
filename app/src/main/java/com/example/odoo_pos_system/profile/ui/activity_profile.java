package com.example.odoo_pos_system.profile.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.odoo_pos_system.R;

public class activity_profile extends Fragment {

    public activity_profile(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        
        return inflater.inflate(R.layout.fragment_activity_profile,container, false);
    }
}
