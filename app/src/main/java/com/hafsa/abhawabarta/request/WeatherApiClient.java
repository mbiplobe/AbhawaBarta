package com.hafsa.abhawabarta.request;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.hafsa.abhawabarta.AppExecutor;
import com.hafsa.abhawabarta.models.CurrentWeatherModel;
import com.hafsa.abhawabarta.response.CurrentWeatherResponse;
import com.hafsa.abhawabarta.utils.Credential;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class WeatherApiClient {
    private static WeatherApiClient weatherApiClient;
    private CurrentWeatherRunable weatherRunable;

    public MutableLiveData<CurrentWeatherModel> getmCurrentWeatherModelMutableLiveData() {
        return mCurrentWeatherModelMutableLiveData;
    }

    public WeatherApiClient() {
        this.mCurrentWeatherModelMutableLiveData = mCurrentWeatherModelMutableLiveData;
    }

    private MutableLiveData<CurrentWeatherModel> mCurrentWeatherModelMutableLiveData;

    public static WeatherApiClient getInstance()
    {
        if (weatherApiClient==null)
        {
            weatherApiClient= new WeatherApiClient();
        }

        return weatherApiClient;
    }

    public void setWeatherUpdateListener(float latitude, float longitude) {
        if (weatherRunable!=null)
            weatherRunable =  null;
        weatherRunable= new CurrentWeatherRunable(latitude, longitude);

        final Future myHandler = AppExecutor.getInstance().getScheduledExecutorService().submit(weatherRunable);

        AppExecutor.getInstance().getScheduledExecutorService().schedule(
                () -> {
                    myHandler.cancel(true);
                },5000, TimeUnit.MILLISECONDS
        );

    }
    private class CurrentWeatherRunable implements Runnable{

        private boolean cancelRequest;
        private float latitude;
        private float logitude;

        public CurrentWeatherRunable(float lat,float lon) {
            this.cancelRequest = false;
            this.latitude= lat;
            this.logitude=lon;

        }

        @Override
        public void run() {
            try {
                Response response= getCurrentWeather(this.latitude,this.logitude).execute();
                if (cancelRequest) return;

                if (response.code()==200)
                {

                  CurrentWeatherResponse currentWeatherResponse = (CurrentWeatherResponse) response.body();
                  cancelRequest= true;

                  if (currentWeatherResponse!=null)
                  {
                      CurrentWeatherModel currentWeatherModel= new CurrentWeatherModel(
                              currentWeatherResponse.getCoord()!=null?currentWeatherResponse.getCoord().getLatitude():0,
                              currentWeatherResponse.getCoord()!=null?currentWeatherResponse.getCoord().getLongtude():0,
                              currentWeatherResponse.getMain()!=null?currentWeatherResponse.getMain().getTemp():0,
                              currentWeatherResponse.getMain()!=null?currentWeatherResponse.getMain().getFeelsLike():0,
                              currentWeatherResponse.getMain()!=null?currentWeatherResponse.getMain().getTempMin():0,
                              currentWeatherResponse.getMain()!=null?currentWeatherResponse.getMain().getTempMax():0,
                              currentWeatherResponse.getMain()!=null?currentWeatherResponse.getMain().getHumidity():0,
                              currentWeatherResponse.getMain()!=null?currentWeatherResponse.getMain().getPressure():0,
                              currentWeatherResponse.getSys()!=null?currentWeatherResponse.getSys().getCountry():"",
                              currentWeatherResponse.getSys()!=null?currentWeatherResponse.getSys().getSunrise():0,
                              currentWeatherResponse.getSys()!=null?currentWeatherResponse.getSys().getSunset():0,
                              currentWeatherResponse.getWeather().size()>0 ? currentWeatherResponse.getWeather().get(0).getMain():"",
                              currentWeatherResponse.getWeather().size()>0 ?currentWeatherResponse.getWeather().get(0).getDescription():"",
                              currentWeatherResponse.getWeather().size()>0 ?currentWeatherResponse.getWeather().get(0).getIcon(): "",
                              currentWeatherResponse.getWind()!=null?currentWeatherResponse.getWind().getSpeed():0

                      );

                      mCurrentWeatherModelMutableLiveData.postValue(currentWeatherModel);
                  }

                }else
                {
                    mCurrentWeatherModelMutableLiveData.postValue(null);


                }
            } catch (IOException e) {
                Log.v("Server Response", e.getMessage().toString());
                mCurrentWeatherModelMutableLiveData.postValue(null);
                cancelRequest= true;
            }
        }

        private Call<CurrentWeatherResponse> getCurrentWeather(float latitude, float logitude)
        {
            return Servicy.getWeatherApi().getCurrentWeather(Credential.API_KEY,latitude,logitude,Credential.SCALE);
        }
    }



}
