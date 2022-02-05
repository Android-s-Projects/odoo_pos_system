package com.example.odoo_pos_system.authentication.services;

import com.example.odoo_pos_system.authentication.model.Authentication;
import com.example.odoo_pos_system.authentication.model.AuthenticationData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface POSTAuthentication {
    @POST("web/session/authenticate")
    public Call<AuthenticationData> authenticate(@Body Authentication authentication);
}
