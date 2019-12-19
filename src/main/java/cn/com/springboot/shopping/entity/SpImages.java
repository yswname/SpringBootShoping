package cn.com.springboot.shopping.entity;

import java.io.Serializable;

public class SpImages implements Serializable {
    private Integer imgId;

    private String imgTitle;

    private String imgUrl;

    private Integer imgType;

    private Integer imgPrId;

    private static final long serialVersionUID = 1L;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle == null ? null : imgTitle.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Integer getImgType() {
        return imgType;
    }

    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }

    public Integer getImgPrId() {
        return imgPrId;
    }

    public void setImgPrId(Integer imgPrId) {
        this.imgPrId = imgPrId;
    }
}