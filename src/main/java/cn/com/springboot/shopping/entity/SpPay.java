package cn.com.springboot.shopping.entity;

import java.io.Serializable;

public class SpPay implements Serializable {
    private Integer pyId;

    private String pyName;

    private String pyImg;

    private static final long serialVersionUID = 1L;

    public Integer getPyId() {
        return pyId;
    }

    public void setPyId(Integer pyId) {
        this.pyId = pyId;
    }

    public String getPyName() {
        return pyName;
    }

    public void setPyName(String pyName) {
        this.pyName = pyName == null ? null : pyName.trim();
    }

    public String getPyImg() {
        return pyImg;
    }

    public void setPyImg(String pyImg) {
        this.pyImg = pyImg == null ? null : pyImg.trim();
    }
}