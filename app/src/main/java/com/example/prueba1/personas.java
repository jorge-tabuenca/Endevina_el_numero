package com.example.prueba1;

public class personas {

    private String name;
    private String trys;
    private String time;

    public personas(String name, String trys, String time) {
        this.name = name;
        this.trys = trys;
        this.time = time;
    }

    public personas() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrys() {
        return trys;
    }

    public void setTrys(String trys) {
        this.trys = trys;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
