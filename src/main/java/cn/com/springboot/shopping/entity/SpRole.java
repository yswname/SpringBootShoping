package cn.com.springboot.shopping.entity;

import java.io.Serializable;

public class SpRole implements Serializable {
    private Integer rlId;

    private String rlName;

    private static final long serialVersionUID = 1L;

    public Integer getRlId() {
        return rlId;
    }

    public void setRlId(Integer rlId) {
        this.rlId = rlId;
    }

    public String getRlName() {
        return rlName;
    }

    public void setRlName(String rlName) {
        this.rlName = rlName == null ? null : rlName.trim();
    }
}