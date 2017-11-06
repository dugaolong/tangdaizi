package com.xian.www.tangdaizi.beans;

/**
 * Created by dugaolong on 17/9/25.
 */

public class LoginRes {

    private String isOk;
    private String username;
    private String userAge;
    private String userSchool;
    private String userPhone;
    private String userpass;

    public LoginRes(String isOk, String username, String userAge, String userSchool, String userPhone, String userpass) {
        this.isOk = isOk;
        this.username = username;
        this.userAge = userAge;
        this.userSchool = userSchool;
        this.userPhone = userPhone;
        this.userpass = userpass;
    }

    public LoginRes() {
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

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
}
