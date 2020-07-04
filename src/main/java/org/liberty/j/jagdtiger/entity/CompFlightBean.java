package org.liberty.j.jagdtiger.entity;

public class CompFlightBean {
    private String company;
    private String ct;
    public Integer count;
    public CompFlightBean(){}
    public CompFlightBean(String pCompany, String pCt, Integer pCount)
    {
        this.company = pCompany;
        this.ct = pCt;
        this.count = pCount;
    }
    public String getCompany()
    {
        return company;
    }
    public String getCt()
    {
        return ct;
    }
    public Integer getCount()
    {
        return count;
    }
    public void setCompany(String pCompany){
        this.company = pCompany;
    }
    public void setCt(String pCt)
    {
        this.ct = pCt;
    }
    public void setCount(Integer pCount)
    {
        this.count = pCount;
    }

}