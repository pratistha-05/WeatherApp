package com.example.myweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myweather.retrofit.Example;
import com.example.myweather.retrofit.apiclient;
import com.example.myweather.retrofit.apiinterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class weather extends AppCompatActivity {


    TextView des, temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

    }


}
