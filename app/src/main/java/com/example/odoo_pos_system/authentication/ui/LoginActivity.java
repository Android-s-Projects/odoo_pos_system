package com.example.odoo_pos_system.authentication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.odoo_pos_system.MainActivity;
import com.example.odoo_pos_system.R;
import com.example.odoo_pos_system.authentication.model.Authentication;
import com.example.odoo_pos_system.authentication.model.AuthenticationData;
import com.example.odoo_pos_system.authentication.services.POSTAuthentication;
import com.example.odoo_pos_system.profile.ui.ProfileActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextView info = findViewById(R.id.tvInfo);
        final Button login = findViewById(R.id.btnLogin);
        final EditText username =  findViewById(R.id.etxUsername);
        final EditText password =  findViewById(R.id.etxPassword);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://54.90.134.212:8069/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                POSTAuthentication authenticationServices = retrofit.create(POSTAuthentication.class);

                Authentication.Params params =  new Authentication.Params(
                        "odoo14", username.getText().toString(), password.getText().toString());
                Authentication authentication = new Authentication("2.0", params);

                Call<AuthenticationData> response = authenticationServices.authenticate(authentication);

                login(response, retrofit, info);
            }
        });
    }

    private void login(Call<AuthenticationData> response, Retrofit retrofit, TextView info) {
        response.enqueue(new Callback<AuthenticationData>() {
            @Override
            public void onResponse(Call<AuthenticationData> call, Response<AuthenticationData> response) {
                if(response.isSuccessful()){
                    AuthenticationData userData = response.body();

                    if(userData.result != null){
                        String session_id = response.headers().values("Set-Cookie")
                                .get(0).split(";")[0].split("=")[1];

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("session_id", session_id);
                        intent.putExtra("db", userData.result.db);
                        intent.putExtra("uid", userData.result.uid);
                        intent.putExtra("name", userData.result.name);
                        intent.putExtra("username", userData.result.username);

                        startActivity(intent);

                    }else{
                        info.setText("Username or Password was wrong.");
                    }
                }else{
                    info.setText("Username or Password was wrong.");
                }
            }

            @Override
            public void onFailure(Call<AuthenticationData> call, Throwable t) {
                info.setText("Authentication error, please try again.");
            }
        });
    }
}
