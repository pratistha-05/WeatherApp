package com.example.myweather.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiinterface {
    @GET("weather?appid=cc9f8c3ca1366f583743bfcca59570ec&units=metric")
    Call<Example> getWeatherData(@Query("q") String name);
}
