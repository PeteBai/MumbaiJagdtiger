package org.liberty.j.jagdtiger.entity;

public class GetProvinceConfirmedBean {
    private String dateId;
    private Integer confirmedCount;
    private String province;
    public GetProvinceConfirmedBean(String dateId,Integer confirmedCount,String province){
        this.confirmedCount = confirmedCount;
        this.dateId = dateId;
        this.province = province;
    }
    public GetProvinceConfirmedBean(){}
    public Integer getConfirmedCount() {
        return confirmedCount;
    }

    public String getDateId() {
        return dateId;
    }

    public String getProvince() {
        return province;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public void setConfirmedCount(Integer confirmedCount) {
        this.confirmedCount = confirmedCount;
    }
}
