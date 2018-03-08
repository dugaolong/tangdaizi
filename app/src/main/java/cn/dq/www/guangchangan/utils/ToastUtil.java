package cn.dq.www.guangchangan.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;


public class ToastUtil {

    private static Toast toast;

    public static int commentcount;
    public static long classid = -1;
    public static String classname = "";
    public static boolean isfirstenter1 = true;
    public static boolean isfirstenter2 = true;
    public static boolean isfirstenter3 = true;
    public static boolean isfirstenter4 = true;
    public static PopupWindow popupwindow;
    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            try {
                PopupWindow window = null;
                if (null != msg) {
                    window = (PopupWindow) msg.obj;
                }
                if (null != window) {
                    window.dismiss();
                }

            } catch (IllegalArgumentException e) {

            }
//            popupwindow.dismiss();
        }
    };

    public static synchronized void showTopToast(Activity activity, View view, String text, boolean isSuccess) {
        if (popupwindow != null) {
            popupwindow.dismiss();
            popupwindow = null;
        }
        popupwindow.showAsDropDown(view, 0, 0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (Exception e) {

                }
                Message msg = new Message();
                msg.obj = popupwindow;
                handler.sendMessage(msg);
            }
        }).start();
    }

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
     * Toast提醒
     *
     * @param context
     */
    public static void showToast(Context context, int resId) {
        if (toast == null) {
            toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        } else {
            toast.setText(context.getResources().getString(resId));
        }
        toast.show();
    }


}
