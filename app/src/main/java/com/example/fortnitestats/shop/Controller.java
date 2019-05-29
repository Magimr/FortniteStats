package com.example.fortnitestats.shop;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<Shop> {

    ServerResponse handler;

    public Controller(ServerResponse handler){
        this.handler = handler;

    }
    static final String BASE_URL = "https://fortnite-public-api.theapinetwork.com/prod09/";

    public void start(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ShopApi api = retrofit.create(ShopApi.class);
        Call<Shop> call = api.loadShop();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Shop> call, Response<Shop> response) {
        if (response.isSuccessful()){
            Shop shop = response.body();
            handler.onResponse(shop);
            Log.d("CONTROLLER",shop.getDate());

        }else{
            Log.d("CONTROLLER",response.errorBody().toString());
        }
    }

    @Override
    public void onFailure(Call<Shop> call, Throwable t) {
        t.printStackTrace();

    }

    interface ServerResponse{
        public void onResponse(Shop shop);
    }





}
