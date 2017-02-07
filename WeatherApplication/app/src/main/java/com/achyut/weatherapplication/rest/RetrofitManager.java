package com.achyut.weatherapplication.rest;

import android.os.Bundle;

import com.achyut.weatherapplication.rest.response.WeatherList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by bhand on 2/2/2017.
 */

public class RetrofitManager {

    public static Retrofit retrofit = null;
    public static RetrofitManager retrofitManager = null;
    public static WeatherListingService weatherListingService = null;
    public static final String BASE_URL = "https://api.forecast.io/";

    public RetrofitManager() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().build();

        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        weatherListingService = retrofit.create(WeatherListingService.class);
    }

    public static RetrofitManager getInstance() {

        if (retrofitManager == null) {
            retrofitManager = new RetrofitManager();
        }

        return  retrofitManager ;
    }

    public static void getWeatherForecast(String apikey, String location, Callback<WeatherList> weatherListCallBack) {
        Call<WeatherList> weatherListCall = weatherListingService.getWeatherDetail(apikey, location);
       weatherListCall.enqueue(weatherListCallBack);
    }

}
