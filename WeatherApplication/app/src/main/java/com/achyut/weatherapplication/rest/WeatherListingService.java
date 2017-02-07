package com.achyut.weatherapplication.rest;

import com.achyut.weatherapplication.rest.response.Datum__;
import com.achyut.weatherapplication.rest.response.WeatherList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by bhand on 2/2/2017.
 */

public interface WeatherListingService {

    @GET("forecast/{apikey}/{latlong}")
    Call<WeatherList> getWeatherDetail(@Path("apikey") String apikey, @Path("latlong") String latlong);


}
