package com.example.cjcucsie.e;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView t1_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1_temp = (TextView) findViewById(R.id.textView);
        find_weather();

    }

    public void find_weather() {
        Thread thread = new Thread(new Runnable() {//背景處理程序
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
                        .build();
                Response response;
                String json = "";
                try {
                    response = client.newCall(request).execute();
                    json = response.body().string();
                    final String finalJson = json;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Gson gson = new GsonBuilder()
                                    .registerTypeAdapter(Weather.class, new stringJava())
                                    .create();
                            Weather weather = gson.fromJson(finalJson, Weather.class);
                                Double d = weather.getTemp()-273.15;
                                t1_temp.setText(d.toString());
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }

}
