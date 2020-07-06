package org.liberty.j.jagdtiger.entity;

public class CityLineNumBean {
    private String date;
    private String linumlist;
    public CityLineNumBean(String date,String linumlist){
        this.date = date;
        this.linumlist = linumlist;
    }
    public CityLineNumBean(){}

    public String getDateId() {
        return date;
    }

    public String getJsonStr() {
        return linumlist;
    }

    public void setDateId(String date) {
        this.date = date;
    }

    public void setJsonStr(String jsonStr) {
        this.linumlist = linumlist;
    }
}
