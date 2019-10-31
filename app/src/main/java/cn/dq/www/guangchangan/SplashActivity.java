package cn.dq.www.guangchangan;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

//import com.xiaomi.ad.SplashAdListener;
//import com.xiaomi.ad.adView.SplashAd;

import java.util.ArrayList;
import java.util.List;

import cn.dq.www.guangchangan.utils.CommanConstantSet;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;


/**
 * Created by dugaolong on 17/9/19.
 */

public class SplashActivity extends Activity implements EasyPermissions.PermissionCallbacks {

    private static final String TAG = "VerticalSplash";
    //以下的POSITION_ID 需要使用您申请的值替换下面内容
    private static final String POSITION_ID = "67594b06623119a8a89a36c5ca38e0de";
    private ViewGroup mContainer;

    String[] request_perms = {Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE};
    private int RC_STORAGE=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);
        // 如果targetSDKVersion >= 23，就要申请好权限。如果您的App没有适配到Android6.0（即targetSDKVersion < 23），那么只需要在这里直接调用fetchSplashAD接口。
        if (EasyPermissions.hasPermissions(this, request_perms)) {
            gotoWelcomeActivity();
        } else {
            EasyPermissions.requestPermissions(this, "需要获取存储和手机识别码权限",
                    RC_STORAGE, request_perms);
        }
        mContainer = (ViewGroup) findViewById(R.id.splash_ad_container);
//        SplashAd splashAd = new SplashAd(this, mContainer, R.drawable.splash, new SplashAdListener() {
//            @Override
//            public void onAdPresent() {
//                // 开屏广告展示
//                Log.d(TAG, "onAdPresent");
//            }
//
//            @Override
//            public void onAdClick() {
//                //用户点击了开屏广告
//                Log.d(TAG, "onAdClick");
//                gotoWelcomeActivity();
//            }
//
//            @Override
//            public void onAdDismissed() {
//                //这个方法被调用时，表示从开屏广告消失。
//                Log.d(TAG, "onAdDismissed");
//                gotoWelcomeActivity();
//            }
//
//            @Override
//            public void onAdFailed(String s) {
//                Log.d(TAG, "onAdFailed, message: " + s);
//                gotoWelcomeActivity();
//            }
//        });
//        splashAd.requestAd(POSITION_ID);
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            // 捕获back键，在展示广告期间按back键，不跳过广告
            if (mContainer.getVisibility() == View.VISIBLE) {
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }


    public  void gotoWelcomeActivity(){
        Intent mIntent = new Intent();
        mIntent.setClass(this, WelcomeActivity.class);
        startActivity(mIntent);
        finish();
    }
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            String msg = "";
            if (requestCode == CommanConstantSet.RC_CAMERA) {
                msg = "拍照";
            } else if (requestCode == CommanConstantSet.RC_STORAGE) {
                msg = "存储";
            } else if (requestCode == CommanConstantSet.RC_RECORD) {
                msg = "录音";
            }
            new AppSettingsDialog.Builder(this).setRationale(String.format(getString(R.string.refused_tip), msg)).build().show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

}
