package org.liberty.j.jagdtiger.entity;

public class CompFlightBean {
    private String ct;
    public Integer count;
    public CompFlightBean(){}
    public CompFlightBean(String pCt, Integer pCount)
    {
        this.ct = pCt;
        this.count = pCount;
    }
    public String getCt()
    {
        return ct;
    }
    public Integer getCount()
    {
        return count;
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