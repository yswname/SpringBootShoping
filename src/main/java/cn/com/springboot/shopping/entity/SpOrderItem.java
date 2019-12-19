package cn.com.springboot.shopping.entity;

import java.io.Serializable;

public class SpOrderItem implements Serializable {
    private Integer odItId;

    private Integer odItPrId;

    private Integer odItNumber;

    private Double odItPrice;

    private Integer odItOdId;

    private static final long serialVersionUID = 1L;

    public Integer getOdItId() {
        return odItId;
    }

    public void setOdItId(Integer odItId) {
        this.odItId = odItId;
    }

    public Integer getOdItPrId() {
        return odItPrId;
    }

    public void setOdItPrId(Integer odItPrId) {
        this.odItPrId = odItPrId;
    }

    public Integer getOdItNumber() {
        return odItNumber;
    }

    public void setOdItNumber(Integer odItNumber) {
        this.odItNumber = odItNumber;
    }

    public Double getOdItPrice() {
        return odItPrice;
    }

    public void setOdItPrice(Double odItPrice) {
        this.odItPrice = odItPrice;
    }

    public Integer getOdItOdId() {
        return odItOdId;
    }

    public void setOdItOdId(Integer odItOdId) {
        this.odItOdId = odItOdId;
    }
}