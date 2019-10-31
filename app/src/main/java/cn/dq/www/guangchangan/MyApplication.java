package cn.dq.www.guangchangan;

import android.app.Application;
import android.content.Context;

//import com.xiaomi.ad.AdSdk;

import cn.bmob.v3.Bmob;

/**
 * 系统组件
 */
public class MyApplication extends Application {
    private static Context appContext;
    public static MyApplication instance;
    String TAG = "MyApplication";
    // 请注意，千万要把以下的 APP_ID 替换成您在小米开发者网站上申请的 AppID。否则，可能会影响你的应用广告收益。
    private static final String APP_ID = "2882303761517738438";
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        instance = this;
        //miad初始化
//        AdSdk.initialize(this, APP_ID);
//        AdSdk.setDebugOn(); // 打开调试，输出调试信息

        //第一：默认初始化
        Bmob.initialize(this, "3d285237af8b688314ef26f993f9b59f");
    }

    public static MyApplication getInstance() {
        if (instance == null) {
            instance = new MyApplication();
        }
        return instance;
    }

}
