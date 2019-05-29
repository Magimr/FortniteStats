package com.example.fortnitestats.upcomingitems;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements Callback<UpcomingItem> {

    ServerResponse handler;

    public Controller(ServerResponse handler) {
        this.handler = handler;
    }

    public static String BASE_URL = "https://fortnite-public-api.theapinetwork.com/prod09/";
    public void start(){
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();

        UpcomingItemApi api = retrofit.create(UpcomingItemApi.class);

        Call<UpcomingItem> call = api.loadUpcomingItem();
        call.enqueue(this);


    }

    @Override
    public void onResponse(Call<UpcomingItem> call, Response<UpcomingItem> response) {
        if (response.isSuccessful()){
            UpcomingItem upcomingItem = response.body();
            handler.onResponse(upcomingItem);
            Log.d("Log",upcomingItem.getItems().toString());

        }
    }

    @Override
    public void onFailure(Call<UpcomingItem> call, Throwable t) {
        t.printStackTrace();
    }

    interface ServerResponse{
        public void onResponse(UpcomingItem upcomingItem);
    }
}
