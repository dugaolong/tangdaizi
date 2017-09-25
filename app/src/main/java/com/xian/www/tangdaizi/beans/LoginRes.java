package com.xian.www.tangdaizi.beans;

/**
 * Created by dugaolong on 17/9/25.
 */

public class LoginRes {

    private String isOk;

    public LoginRes(String isOk) {
        this.isOk = isOk;
    }

    public LoginRes() {
    }

    public String getIsOk() {
        return isOk;
    }

    public void setIsOk(String isOk) {
        this.isOk = isOk;
    }
}
