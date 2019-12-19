package cn.com.springboot.shopping.entity;

import java.io.Serializable;

public class SpCatalogue implements Serializable {
    private Integer ctId;

    private String ctName;

    private Integer ctParentId;

    private String ctRemark;

    private static final long serialVersionUID = 1L;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public String getCtName() {
        return ctName;
    }

    public void setCtName(String ctName) {
        this.ctName = ctName == null ? null : ctName.trim();
    }

    public Integer getCtParentId() {
        return ctParentId;
    }

    public void setCtParentId(Integer ctParentId) {
        this.ctParentId = ctParentId;
    }

    public String getCtRemark() {
        return ctRemark;
    }

    public void setCtRemark(String ctRemark) {
        this.ctRemark = ctRemark == null ? null : ctRemark.trim();
    }
}