package cn.dq.www.guangchangan.bmobBeans;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

public class Version extends BmobObject {
    private String valid;
    private String url;
    private String name;
    private String code;
    private String updateDescription;

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }
}