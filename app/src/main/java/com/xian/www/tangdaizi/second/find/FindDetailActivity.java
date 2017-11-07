package com.xian.www.tangdaizi.second.find;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/16.
 * 华清池
 */

public class FindDetailActivity extends Activity {

    private int image = 0;
    @InjectView(R.id.title_text)
    TextView title_text;
    @InjectView(R.id.image_detail)
    ImageView image_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.find_detail);

        //using butter knife
        ButterKnife.inject(this);
        getBundle();
        setContent();

    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.containsKey("id")) {
                this.image = bundle.getInt("id");
            }
        }
    }

    private void setContent() {

        //shi
        if (image == R.id.shi_chunxiao1) {
            title_text.setText("春晓");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.shi_chunxiao_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.shi_chunxiao_xq).into(image_detail);
        }
        if (image == R.id.shi_jiuyuejiu1) {
            title_text.setText("九月九");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.shi_jiuyuejiu_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.shi_jiuyuejiu_xq).into(image_detail);
        }
        if (image == R.id.shi_jueju1) {
            title_text.setText("绝句");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.shi_jueju_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.shi_jueju_xq).into(image_detail);
        }
        if (image == R.id.shi_zengwanlun1) {
            title_text.setText("赠汪伦");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.shi_zengwanglun_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.shi_zengwanglun_xq).into(image_detail);
        }
        //qu
        if (image == R.id.qu_cuju1) {
            title_text.setText("蹴鞠");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.qu_cuju_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.qu_cuju_xq).into(image_detail);
        }
        if (image == R.id.qu_damaqiu1) {
            title_text.setText("打马球");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.qu_damaqiu_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.qu_damaqiu_xq).into(image_detail);
        }
        if (image == R.id.qu_douji1) {
            title_text.setText("斗鸡");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.qu_douji_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.qu_douji_xq).into(image_detail);
        }
        if (image == R.id.qu_qiuqian1) {
            title_text.setText("秋千");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.qu_qiuqian_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.qu_qiuqian_xq).into(image_detail);
        }
        //shii
        if (image == R.id.shii_dousha1) {
            title_text.setText("豆沙");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.shii_dousha_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.shii_dousha_xq).into(image_detail);
        }
        if (image == R.id.shii_qingfengfan1) {
            title_text.setText("清风饭");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.shii_qingfengfan_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.shii_qingfengfan_xq).into(image_detail);
        }
        if (image == R.id.shii_su1) {
            title_text.setText("酥");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.shii_su_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.shii_su_xq).into(image_detail);
        }
        if (image == R.id.shii_yingtao) {
            title_text.setText("樱桃");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.shii_yingtao_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.shii_yingtao_xq).into(image_detail);
        }
        //yi
        if (image == R.id.yi_funv1) {
            title_text.setText("妇女");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.yi_funv_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.yi_funv_xq).into(image_detail);
        }
        if (image == R.id.yi_gongqing1) {
            title_text.setText("公卿");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.yi_gongqing_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.yi_gongqing_xq).into(image_detail);
        }
        if (image == R.id.yi_junren1) {
            title_text.setText("军人");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.yi_junren_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.yi_junren_xq).into(image_detail);
        }
        if (image == R.id.yi_tianzi1) {
            title_text.setText("天子");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.yi_tianzi_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.yi_tianzi_xq).into(image_detail);
        }
        //ke
        if (image == R.id.ke_bishu1) {
            title_text.setText("避暑");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.ke_bishu_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.ke_bishu_xq).into(image_detail);
        }
        if (image == R.id.ke_cunchushui1) {
            title_text.setText("存储水");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.ke_cunchushui_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.ke_cunchushui_xq).into(image_detail);
        }
        if (image == R.id.ke_huobi1) {
            title_text.setText("货币");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.ke_huobi_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.ke_huobi_xq).into(image_detail);
        }
        if (image == R.id.ke_kaoli1) {
            title_text.setText("烤梨");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), R.drawable.ke_kaoli_xq, options);
            fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(R.drawable.ke_kaoli_xq).into(image_detail);
        }
    }


    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
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
