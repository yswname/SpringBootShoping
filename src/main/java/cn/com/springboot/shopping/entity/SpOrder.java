package cn.com.springboot.shopping.entity;

import java.io.Serializable;
import java.util.Date;

public class SpOrder implements Serializable {
    private Integer odId;

    private String odCode;

    private Date odCreateTime;

    private Integer odUrId;

    private Integer odAddressId;

    private Integer odStatus;

    private Integer odPyId;

    private static final long serialVersionUID = 1L;

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public String getOdCode() {
        return odCode;
    }

    public void setOdCode(String odCode) {
        this.odCode = odCode == null ? null : odCode.trim();
    }

    public Date getOdCreateTime() {
        return odCreateTime;
    }

    public void setOdCreateTime(Date odCreateTime) {
        this.odCreateTime = odCreateTime;
    }

    public Integer getOdUrId() {
        return odUrId;
    }

    public void setOdUrId(Integer odUrId) {
        this.odUrId = odUrId;
    }

    public Integer getOdAddressId() {
        return odAddressId;
    }

    public void setOdAddressId(Integer odAddressId) {
        this.odAddressId = odAddressId;
    }

    public Integer getOdStatus() {
        return odStatus;
    }

    public void setOdStatus(Integer odStatus) {
        this.odStatus = odStatus;
    }

    public Integer getOdPyId() {
        return odPyId;
    }

    public void setOdPyId(Integer odPyId) {
        this.odPyId = odPyId;
    }
}