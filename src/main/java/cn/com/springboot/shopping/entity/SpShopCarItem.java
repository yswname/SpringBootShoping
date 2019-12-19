package cn.com.springboot.shopping.entity;

import java.io.Serializable;

public class SpShopCarItem implements Serializable {
    private Integer carItId;

    private Integer carItPrId;

    private Integer carItNumber;

    private Integer carItUrId;

    private static final long serialVersionUID = 1L;

    public Integer getCarItId() {
        return carItId;
    }

    public void setCarItId(Integer carItId) {
        this.carItId = carItId;
    }

    public Integer getCarItPrId() {
        return carItPrId;
    }

    public void setCarItPrId(Integer carItPrId) {
        this.carItPrId = carItPrId;
    }

    public Integer getCarItNumber() {
        return carItNumber;
    }

    public void setCarItNumber(Integer carItNumber) {
        this.carItNumber = carItNumber;
    }

    public Integer getCarItUrId() {
        return carItUrId;
    }

    public void setCarItUrId(Integer carItUrId) {
        this.carItUrId = carItUrId;
    }
}