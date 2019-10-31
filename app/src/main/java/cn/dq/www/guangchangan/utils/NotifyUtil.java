package cn.dq.www.guangchangan.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;

/**
 * @author zhouxiaohui
 * @date 2019-07-10 11:08
 * @package cn.qtone.ssp.xxtUitl
 * @email 735665926@qq.com
 * @describe 通知栏工具类
 */

public class NotifyUtil {

    public static String getChannelId(String channelId,String channelName,int importance
            ,NotificationManager mNotificationManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
            channel.enableLights(true);//显示桌面红点
            channel.setLightColor(Color.RED);
            channel.setShowBadge(true);
            mNotificationManager.createNotificationChannel(channel);
            return channel.getId();
        } else {
            return null;

        }

    }

}
