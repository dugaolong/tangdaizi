package com.xian.www.tangdaizi.second.find;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dugaolong on 17/9/16.
 * 广告
 */

public class GgDetailActivity extends Activity {

    private int image = 0;
    @InjectView(R.id.image_detail)
    ImageView image_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.gg_detail);

        //using butter knife
        ButterKnife.inject(this);
        setContent();
    }

    private void setContent() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.gg_xq, options);
        fitImage(this, image_detail, options.outWidth, options.outHeight);
        Glide.with(this).load(R.drawable.gg_xq).into(image_detail);

    }

    /**
     * 根据图片大小按比例适配全屏
     *
     * @param imageView
     * @param picWidth
     * @param picHeight
     */
    public static void fitImage(Activity activity, ImageView imageView, float picWidth, float picHeight) {
        WindowManager wm = activity.getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        float height = (float) width / picWidth * picHeight;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = (int) height;
        imageView.setLayoutParams(layoutParams);
    }
}
