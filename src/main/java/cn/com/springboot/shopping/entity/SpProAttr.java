package cn.com.springboot.shopping.entity;

import java.io.Serializable;

public class SpProAttr implements Serializable {
    private Integer proAttrId;

    private String proAttrName;

    private String proAttrCode;

    private Integer proAttrCtId;

    private static final long serialVersionUID = 1L;

    public Integer getProAttrId() {
        return proAttrId;
    }

    public void setProAttrId(Integer proAttrId) {
        this.proAttrId = proAttrId;
    }

    public String getProAttrName() {
        return proAttrName;
    }

    public void setProAttrName(String proAttrName) {
        this.proAttrName = proAttrName == null ? null : proAttrName.trim();
    }

    public String getProAttrCode() {
        return proAttrCode;
    }

    public void setProAttrCode(String proAttrCode) {
        this.proAttrCode = proAttrCode == null ? null : proAttrCode.trim();
    }

    public Integer getProAttrCtId() {
        return proAttrCtId;
    }

    public void setProAttrCtId(Integer proAttrCtId) {
        this.proAttrCtId = proAttrCtId;
    }
}