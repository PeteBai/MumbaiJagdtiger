package org.liberty.j.jagdtiger.entity;


public class GetCityAffectedBean {
    private String dateId;
    private Integer confirmedCount;
    public GetCityAffectedBean(String dateId,Integer confirmedCount){
        this.dateId = dateId;
        this.confirmedCount = confirmedCount;
    }
    public GetCityAffectedBean(){}
    public void setDateId(String dateId) {
        this.dateId = dateId;
    }
    public String getDateId() {
        return dateId;
    }
    public Integer getConfirmedCount() {
        return confirmedCount;
    }
    public void setConfirmedCount(Integer confirmedCount) {
        this.confirmedCount = confirmedCount;
    }
}
