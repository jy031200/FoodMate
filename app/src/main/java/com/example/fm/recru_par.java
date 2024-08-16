package com.example.fm;

public class recru_par {
    private String oder;
    private String name;

    public String getOder() {
        return oder;
    }

    public void setOder(String oder) {
        this.oder = oder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public recru_par() {
    }

    public recru_par(String oder, String name) {
        this.oder = oder;
        this.name = name;
    }
}
