package com.hafsa.abhawabarta.response;

import com.google.gson.annotations.SerializedName;
import com.hafsa.abhawabarta.models.Coord;
import com.hafsa.abhawabarta.models.Main;
import com.hafsa.abhawabarta.models.Sys;
import com.hafsa.abhawabarta.models.Weather;
import com.hafsa.abhawabarta.models.Wind;

import java.util.List;

public class CurrentWeatherResponse {
    @SerializedName("base")
    private String base;
    @SerializedName("coord")
    private Coord coord;
    @SerializedName("weather")
    private List<Weather> weather;

    @SerializedName("main")
    private Main main;
    @SerializedName("visibility")
    private int visibility;

    public String getBase() {
        return base;
    }

    public Coord getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Sys getSys() {
        return sys;
    }

    @SerializedName("wind")
    private Wind wind;
    @SerializedName("sys")
    private Sys sys;


}
