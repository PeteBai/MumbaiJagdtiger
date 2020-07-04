package org.liberty.j.jagdtiger.entity;

public class CompPriceBean implements Comparable<CompPriceBean>{
    private String company;
    private Double avg_price;
    public CompPriceBean(Double pPrice, String pCompany){
        this.company = pCompany;
        this.avg_price = pPrice;
    }
    public CompPriceBean(){}
    
    public String getCompany()
    {
        return company;
    }
    public double getAvg_price()
    {
        Double get_double = Double.parseDouble(String.format("%.2f", avg_price));
        return get_double;
    }
    public void setCompany(String pCompany)
    {
        this.company = pCompany;
    }
    public void setAvg_price(Double pPrice)
    {
        this.avg_price = pPrice;
    }
    @Override
    public String toString()
    {
        return "CompPriceBean: "+"company="+company;
    }

    @Override
    public int compareTo(CompPriceBean cpb)
    {
        if(this.avg_price >= cpb.getAvg_price())
        {
            return 1;
        }
        return -1;
    }
}