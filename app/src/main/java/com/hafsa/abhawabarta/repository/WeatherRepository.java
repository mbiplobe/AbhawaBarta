package com.hafsa.abhawabarta.repository;

import androidx.lifecycle.LiveData;

import com.hafsa.abhawabarta.models.CurrentWeatherModel;
import com.hafsa.abhawabarta.request.WeatherApiClient;

public class WeatherRepository {

    private static WeatherRepository weatherRepository;

    private WeatherApiClient weatherApiClient;

    public WeatherRepository() {
        weatherApiClient= new WeatherApiClient();
    }

    public static WeatherRepository getInstance()
    {
        if (weatherRepository==null)
            weatherRepository= new WeatherRepository();

        return weatherRepository;
    }

    public void setCurrentWeatherUpdateListener(float lat, float lon)
    {
        weatherApiClient.setWeatherUpdateListener(lat,lon);
    }

    public LiveData<CurrentWeatherModel> getCurrentWeatherUpdate()
    {
        return weatherApiClient.getmCurrentWeatherModelMutableLiveData();
    }

}
