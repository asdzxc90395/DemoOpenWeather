package com.example.cjcucsie.e;

import android.widget.TextView;

public class Weather {
    private Double temp;
    private String city,description,data;

    public Weather(Double temp) {
        this.temp = temp;
    }

    public Double getTemp() {
        return temp;
    }
    public void setTemp(Double temp) {
        this.temp = temp;
    }

}
