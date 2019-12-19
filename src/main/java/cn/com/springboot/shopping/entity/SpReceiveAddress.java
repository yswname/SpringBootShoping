package cn.com.springboot.shopping.entity;

import java.io.Serializable;

public class SpReceiveAddress implements Serializable {
    private Integer reAdrId;

    private String reAdrAddress;

    private String reAdrName;

    private String reAdrPhone;

    private Integer reAdrUrId;

    private static final long serialVersionUID = 1L;

    public Integer getReAdrId() {
        return reAdrId;
    }

    public void setReAdrId(Integer reAdrId) {
        this.reAdrId = reAdrId;
    }

    public String getReAdrAddress() {
        return reAdrAddress;
    }

    public void setReAdrAddress(String reAdrAddress) {
        this.reAdrAddress = reAdrAddress == null ? null : reAdrAddress.trim();
    }

    public String getReAdrName() {
        return reAdrName;
    }

    public void setReAdrName(String reAdrName) {
        this.reAdrName = reAdrName == null ? null : reAdrName.trim();
    }

    public String getReAdrPhone() {
        return reAdrPhone;
    }

    public void setReAdrPhone(String reAdrPhone) {
        this.reAdrPhone = reAdrPhone == null ? null : reAdrPhone.trim();
    }

    public Integer getReAdrUrId() {
        return reAdrUrId;
    }

    public void setReAdrUrId(Integer reAdrUrId) {
        this.reAdrUrId = reAdrUrId;
    }
}