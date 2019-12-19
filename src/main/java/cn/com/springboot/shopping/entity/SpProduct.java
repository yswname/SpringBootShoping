package cn.com.springboot.shopping.entity;

import java.io.Serializable;

public class SpProduct implements Serializable {
    private Integer prId;

    private Double prPrice;

    private String prTitle;

    private String prSimpleDesc;

    private Integer prCtId;

    private String prAttrs;

    private String prDetailDesc;

    private static final long serialVersionUID = 1L;

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }

    public Double getPrPrice() {
        return prPrice;
    }

    public void setPrPrice(Double prPrice) {
        this.prPrice = prPrice;
    }

    public String getPrTitle() {
        return prTitle;
    }

    public void setPrTitle(String prTitle) {
        this.prTitle = prTitle == null ? null : prTitle.trim();
    }

    public String getPrSimpleDesc() {
        return prSimpleDesc;
    }

    public void setPrSimpleDesc(String prSimpleDesc) {
        this.prSimpleDesc = prSimpleDesc == null ? null : prSimpleDesc.trim();
    }

    public Integer getPrCtId() {
        return prCtId;
    }

    public void setPrCtId(Integer prCtId) {
        this.prCtId = prCtId;
    }

    public String getPrAttrs() {
        return prAttrs;
    }

    public void setPrAttrs(String prAttrs) {
        this.prAttrs = prAttrs == null ? null : prAttrs.trim();
    }

    public String getPrDetailDesc() {
        return prDetailDesc;
    }

    public void setPrDetailDesc(String prDetailDesc) {
        this.prDetailDesc = prDetailDesc == null ? null : prDetailDesc.trim();
    }
}