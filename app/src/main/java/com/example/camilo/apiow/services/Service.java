package com.example.camilo.apiow.services;

import com.example.camilo.apiow.models.Player;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {
    @GET("us/{player}")
    Call<Player> getPlayer(@Path("player") String username);

}
