package com.hafsa.abhawabarta.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentWeatherModel implements Parcelable {
    private double latitude;
    private double longtude;
    private float temp;
    private float feelsLikeTemp;
    private float tempMin;
    private float tempMax;
    private int pressure;
    private int humidity;
    private String country;
    private long sunrise;
    private long sunset;
    private String main;
    private String description;
    private String icon;
    private float speed;

    public CurrentWeatherModel() {
    }

    public CurrentWeatherModel(double latitude, double longtude,
                               float temp, float feelsLikeTemp, float tempMin,
                               float tempMax, int pressure, int humidity, String country,
                               long sunrise, long sunset, String main, String description,
                               String icon, float speed) {
        this.latitude = latitude;
        this.longtude = longtude;
        this.temp = temp;
        this.feelsLikeTemp = feelsLikeTemp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.main = main;
        this.description = description;
        this.icon = icon;
        this.speed= speed;
    }

    protected CurrentWeatherModel(Parcel in) {
        latitude = in.readDouble();
        longtude = in.readDouble();
        temp = in.readFloat();
        feelsLikeTemp = in.readFloat();
        tempMin = in.readFloat();
        tempMax = in.readFloat();
        pressure = in.readInt();
        humidity = in.readInt();
        country = in.readString();
        sunrise = in.readLong();
        sunset = in.readLong();
        main = in.readString();
        description = in.readString();
        icon = in.readString();
        speed = in.readFloat();
    }

    public static final Creator<CurrentWeatherModel> CREATOR = new Creator<CurrentWeatherModel>() {
        @Override
        public CurrentWeatherModel createFromParcel(Parcel in) {
            return new CurrentWeatherModel(in);
        }

        @Override
        public CurrentWeatherModel[] newArray(int size) {
            return new CurrentWeatherModel[size];
        }
    };

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtude() {
        return longtude;
    }

    public void setLongtude(double longtude) {
        this.longtude = longtude;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getFeelsLikeTemp() {
        return feelsLikeTemp;
    }

    public void setFeelsLikeTemp(float feelsLikeTemp) {
        this.feelsLikeTemp = feelsLikeTemp;
    }

    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(latitude);
        dest.writeDouble(longtude);
        dest.writeFloat(temp);
        dest.writeFloat(feelsLikeTemp);
        dest.writeFloat(tempMin);
        dest.writeFloat(tempMax);
        dest.writeInt(pressure);
        dest.writeInt(humidity);
        dest.writeString(country);
        dest.writeLong(sunrise);
        dest.writeLong(sunset);
        dest.writeString(main);
        dest.writeString(description);
        dest.writeString(icon);
        dest.writeFloat(speed);
    }
}
