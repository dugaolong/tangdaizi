package cn.dq.www.guangchangan.bmobBeans;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

public class Person extends BmobUser {
    private String userAge;
    private String userSchool;
    private String userPhone;

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

}