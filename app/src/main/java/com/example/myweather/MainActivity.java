package com.example.myweather;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myweather.retrofit.Example;
import com.example.myweather.retrofit.apiclient;
import com.example.myweather.retrofit.apiinterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
 TextView des,temp,hum;
 ImageView search;
 EditText city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.search);
        temp = findViewById(R.id.temp);
        des = findViewById(R.id.desc);
        hum = findViewById(R.id.hum);
        city=findViewById(R.id.searchtown);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getWeatherData(city.getText().toString().trim());

            }
        });
    }
    public void getWeatherData(String name) {
        apiinterface apiInterface = apiclient.getClient().create(apiinterface.class);

        Call<Example> call = apiInterface.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                temp.setText("Temp" + " " + response.body().getMain().getTemp() + " C");
                des.setText("Feels Like" + " " + response.body().getMain().getFeels_like()+ "C");
                hum.setText("Humidity" + " " + response.body().getMain().gethumidity()+"%");


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }



}
    