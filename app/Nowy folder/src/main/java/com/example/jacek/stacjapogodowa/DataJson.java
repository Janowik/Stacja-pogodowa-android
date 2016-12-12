package com.example.jacek.stacjapogodowa;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DataJson {
    private String temperatura;
    private String wilgotnosc;
    private String cisnienie;
    private String pm10;
    private String data;

    public String getTemperatura() {
        return temperatura;
    }

    public String getWilgotnosc() {
        return wilgotnosc;
    }

    public String getCisnienie() {
        return cisnienie;
    }

    public String getpm10() {
        return pm10;
    }

    public String getData() {
        return data;
    }
}

