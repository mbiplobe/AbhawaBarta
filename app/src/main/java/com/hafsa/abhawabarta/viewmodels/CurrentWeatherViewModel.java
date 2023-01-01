package com.hafsa.abhawabarta.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hafsa.abhawabarta.models.CurrentWeatherModel;
import com.hafsa.abhawabarta.repository.WeatherRepository;

public class CurrentWeatherViewModel extends ViewModel {
    private WeatherRepository mWeatherRepository;

    public CurrentWeatherViewModel(WeatherRepository mWeatherRepository) {
        this.mWeatherRepository = mWeatherRepository;
    }

    public LiveData<CurrentWeatherModel> getCurrentWeatherUpdate()
    {
        return mWeatherRepository.getCurrentWeatherUpdate();
    }

    public void setCurrentWeatherListener(float lat, float lon)
    {
        mWeatherRepository.setCurrentWeatherUpdateListener(lat,lon);
    }
}
