package org.liberty.j.jagdtiger.entity;

public class CityAvgPriceBean {
    private String  city;
    private double avg_dep_price;
    private double avg_arr_price;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getAvg_dep_price() {
        return avg_dep_price;
    }

    public void setAvg_dep_price(double avg_dep_price) {
        this.avg_dep_price = avg_dep_price;
    }

    public double getAvg_arr_price() {
        return avg_arr_price;
    }

    public void setAvg_arr_price(double avg_arr_price) {
        this.avg_arr_price = avg_arr_price;
    }
}
