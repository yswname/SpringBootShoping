package cn.com.springboot.shopping.entity;

import java.io.Serializable;

public class SpIdCard implements Serializable {
    private Integer icId;

    private String icCode;

    private String icName;

    private static final long serialVersionUID = 1L;

    public Integer getIcId() {
        return icId;
    }

    public void setIcId(Integer icId) {
        this.icId = icId;
    }

    public String getIcCode() {
        return icCode;
    }

    public void setIcCode(String icCode) {
        this.icCode = icCode == null ? null : icCode.trim();
    }

    public String getIcName() {
        return icName;
    }

    public void setIcName(String icName) {
        this.icName = icName == null ? null : icName.trim();
    }
}