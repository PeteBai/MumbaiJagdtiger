package org.liberty.j.jagdtiger.entity;

public class CityLineNumSizeBean {
    private String name;
    private Integer linenum;
    private Integer size;
    public CityLineNumSizeBean(String name,Integer linenum,Integer size){
        this.name = name;
        this.linenum = linenum;
        this.size = size;
    }
    public CityLineNumSizeBean(){}

    public String getName() {
        return name;
    }

    public Integer getLinenum() {
        return linenum;
    }

    public Integer getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLinenum(Integer linenum) {
        this.linenum = linenum;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
