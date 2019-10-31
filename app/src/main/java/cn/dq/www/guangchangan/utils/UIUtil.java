package cn.dq.www.guangchangan.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;


public class UIUtil {

    public static int commentcount;
    public static long classid = -1;
    public static String classname = "";
    public static boolean isfirstenter1 = true;
    public static boolean isfirstenter2 = true;
    public static boolean isfirstenter3 = true;
    public static boolean isfirstenter4 = true;
    public static boolean isShowDialog = false;
    public static boolean isExit = false;

    /*
     * 换肤
     */
    public static void setSkin(Context context, int userType, boolean isdown) {
        Configuration config = context.getResources().getConfiguration();
        switch (userType) {
            case 1:
                break;
            case 2:
                if (isdown) {
                    config.locale = new Locale("zh", "CN");
                } else {
                    config.locale = new Locale("jz", "CN");
                }
                context.getResources().updateConfiguration(config, null);
                break;
            default:
                break;
        }

    }

    /*
     * 换肤
     */
    public static void setChinese(Context context) {
        Configuration config = context.getResources().getConfiguration();
        config.locale = new Locale("zh", "CN");
        context.getResources().updateConfiguration(config, null);
    }

    /*
     * 换肤
     */
    public static void setJiaZhangSkin(Context context) {
        Configuration config = context.getResources().getConfiguration();
        config.locale = new Locale("jz", "CN");
        context.getResources().updateConfiguration(config, null);
    }

    private static Toast toast;

    /**
     * Toast提醒
     *
     * @param context
     * @param msg
     */
    public static void showToast(Context context, String msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }




    /**
     * 开通广东业务弹框
     *
     * @param context
     */

    /**
     * 广东加入班级弹框
     *
     * @param context
     */

    /**
     * 广东1级用户加入班级审核状态弹框
     *
     * @param context
     */

    /**
     * 不能提供此服务对话框
     *
     * @param context
     */

    /**
     * 需要完善角色信息对话框
     *
     * @param context
     */

    /**
     * 申请正在审核对话框
     *
     * @param context
     */


    /**
     * 申请成功对话框
     *
     * @param context
     */

    /**
     * 开通人人通对话框
     *
     * @param context
     */

    /**
     * 联系班主任开通和教育对话框
     *
     * @param context
     */

    /**
     * 是否打电话对话框
     *
     * @param context
     */

    /*
     * 判断URL的合法性
     */

    /**
     * 所有访问服务端接口返回预处理函数
     *
     * @param context
     * @param response
     */


    /**
     * 检查服务端返回的resposnse是否有contentMsg字段且内容不为空，如有则弹幕显示
     *
     * @param context
     * @param response
     */

    /**
     * 检测是否体验期过期,贵州用
     *
     * @param context
     * @param response
     */

    /**
     * 检测session是否过期（广东）
     *
     * @param context
     * @param response
     */

    /**
     * 记住密码
     *
     * @param session
     */

    //==========与退出登录相同============


    private static LocalBroadcastManager mLocalBroadcastManager;

    public static LocalBroadcastManager getLocalBroadcastManager(Context mcontext) {
        if (mLocalBroadcastManager == null)
            mLocalBroadcastManager = LocalBroadcastManager.getInstance(mcontext);
        return mLocalBroadcastManager;
    }

    /**
     * 暂无数据提示
     *
     * @param context
     * @param text    为空默认提示暂无数据
     * @return
     */

    /**
     * 自定义积分弹出的所有的toast请求
     *
     * @param msg
     */

    /**
     * 动画效果
     *
     * @param view
     */

    /**
     * 退出登录,清除数据
     *
     * @param activity
     */


    /**
     * 退出登录,清除数据
     *
     * @param activity
     */

}
