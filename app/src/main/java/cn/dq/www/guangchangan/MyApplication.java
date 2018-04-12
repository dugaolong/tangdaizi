package cn.dq.www.guangchangan;

import android.app.Application;
import android.content.Context;


/**
 * 系统组件
 */
public class MyApplication extends Application {
    private static Context appContext;
    public static MyApplication instance;
    String TAG = "MyApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        instance = this;
    }

    public static MyApplication getInstance() {
        if (instance == null) {
            instance = new MyApplication();
        }
        return instance;
    }

}
