package com.hafsa.abhawabarta.request;

import com.hafsa.abhawabarta.utils.Credential;
import com.hafsa.abhawabarta.utils.WeatherApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicy {
    private static Retrofit.Builder mRetrofitBuilder=
            new Retrofit.Builder()
                    .baseUrl(Credential.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit mRetrofit= mRetrofitBuilder.build();

    public static WeatherApi getWeatherApi() {
        return mWeatherApi;
    }

    private static WeatherApi mWeatherApi = mRetrofit.create(WeatherApi.class);
}
