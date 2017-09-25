package com.xian.www.tangdaizi.beans;

/**
 * Created by dugaolong on 17/9/25.
 */

public class User {
    private String isOk;
    private String username;
    private String userpass;

    public User() {
    }

    public User(String isOk, String username, String userpass) {
        this.isOk = isOk;
        this.username = username;
        this.userpass = userpass;
    }

    public String getIsOk() {
        return isOk;
    }

    public void setIsOk(String isOk) {
        this.isOk = isOk;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
}
