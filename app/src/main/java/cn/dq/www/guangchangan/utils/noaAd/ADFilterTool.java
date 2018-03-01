package cn.dq.www.guangchangan.utils.noaAd;

import android.content.Context;
import android.content.res.Resources;

import cn.dq.www.guangchangan.R;

/**
* Created by BrainWang on 05/01/2016.
*/
public class ADFilterTool {
    public static boolean hasAd(Context context, String url){
        Resources res= context.getResources();
        String[]adUrls =res.getStringArray(R.array.adBlockUrl);
        for(String adUrl :adUrls){
            if(url.contains(adUrl)){
                return true;
            }
        }
        return false;
    }
}