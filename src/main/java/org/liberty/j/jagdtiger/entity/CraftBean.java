package org.liberty.j.jagdtiger.entity;

public class CraftBean {
    private String craftFamily;
    private String craftDesc;
    private Integer craftLoad;
    private String craftSize;

    public String getCraftFamily() {
        return craftFamily;
    }

    public void setCraftFamily(String craftFamily) {
        this.craftFamily = craftFamily;
    }


    public String getCraftDesc() {
        return craftDesc;
    }

    public void setCraftDesc(String craftDesc) {
        this.craftDesc = craftDesc;
    }

    public Integer getCraftLoad() {
        return craftLoad;
    }

    public void setCraftLoad(Integer craftLoad) {
        this.craftLoad = craftLoad;
    }

    public String getCraftSize() {
        return craftSize;
    }

    public void setCraftSize(String craftSize) {
        this.craftSize = craftSize;
    }
}