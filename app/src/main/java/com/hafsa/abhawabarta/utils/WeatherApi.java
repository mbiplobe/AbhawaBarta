package com.hafsa.abhawabarta.utils;

import com.hafsa.abhawabarta.response.CurrentWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("data/2.5/weather")
    Call<CurrentWeatherResponse> getCurrentWeather(
            @Query("appid")String apiKey,
            @Query("lat")float lat,
            @Query("lon")float lon,
            @Query("units")String units
    );

}
