package cn.com.springboot.shopping.entity;

import java.io.Serializable;

public class SpUser implements Serializable {
    private Integer urId;

    private String urUserName;

    private String urPassword;

    private static final long serialVersionUID = 1L;

    public Integer getUrId() {
        return urId;
    }

    public void setUrId(Integer urId) {
        this.urId = urId;
    }

    public String getUrUserName() {
        return urUserName;
    }

    public void setUrUserName(String urUserName) {
        this.urUserName = urUserName == null ? null : urUserName.trim();
    }

    public String getUrPassword() {
        return urPassword;
    }

    public void setUrPassword(String urPassword) {
        this.urPassword = urPassword == null ? null : urPassword.trim();
    }

	@Override
	public String toString() {
		return "SpUser [urId=" + urId + ", urUserName=" + urUserName + ", urPassword=" + urPassword + "]";
	}
    
}