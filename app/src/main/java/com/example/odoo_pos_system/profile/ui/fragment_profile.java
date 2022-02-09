package com.example.odoo_pos_system.profile.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.odoo_pos_system.R;

public class fragment_profile extends Fragment {

    private String name;
    private String username;
    private String db;

    public fragment_profile() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString("name", "No data loaded");
            username = getArguments().getString("username", "No data loaded");
            db = getArguments().getString("db", "No data loaded");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((TextView) view.findViewById(R.id.tvDtoName)).setText(this.name);
        ((TextView) view.findViewById(R.id.tvDtoUsername)).setText(this.username);
        ((TextView) view.findViewById(R.id.tvDtoDatabase)).setText(this.db);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}
