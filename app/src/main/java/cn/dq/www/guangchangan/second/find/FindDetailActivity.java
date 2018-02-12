package cn.dq.www.guangchangan.second.find;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.dq.www.guangchangan.utils.ImageTools;

/**
 * Created by dugaolong on 17/9/16.
 * 华清池
 */

public class FindDetailActivity extends Activity {

    private int image = 0;
    @InjectView(cn.dq.www.guangchangan.R.id.title_text)
    TextView title_text;
    @InjectView(cn.dq.www.guangchangan.R.id.image_detail)
    ImageView image_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(cn.dq.www.guangchangan.R.layout.find_detail);

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
        if (image == cn.dq.www.guangchangan.R.id.shi_chunxiao1) {
            title_text.setText("春晓");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.shi_chunxiao_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.shi_chunxiao_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.shi_jiuyuejiu1) {
            title_text.setText("九月九");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.shi_jiuyuejiu_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.shi_jiuyuejiu_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.shi_jueju1) {
            title_text.setText("绝句");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.shi_jueju_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.shi_jueju_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.shi_zengwanlun1) {
            title_text.setText("赠汪伦");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.shi_zengwanglun_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.shi_zengwanglun_xq).into(image_detail);
        }
        //qu
        if (image == cn.dq.www.guangchangan.R.id.qu_cuju1) {
            title_text.setText("蹴鞠");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.qu_cuju_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.qu_cuju_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.qu_damaqiu1) {
            title_text.setText("打马球");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.qu_damaqiu_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.qu_damaqiu_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.qu_douji1) {
            title_text.setText("斗鸡");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.qu_douji_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.qu_douji_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.qu_qiuqian1) {
            title_text.setText("秋千");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.qu_qiuqian_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.qu_qiuqian_xq).into(image_detail);
        }
        //shii
        if (image == cn.dq.www.guangchangan.R.id.shii_dousha1) {
            title_text.setText("豆沙");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.shii_dousha_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.shii_dousha_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.shii_qingfengfan1) {
            title_text.setText("清风饭");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.shii_qingfengfan_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.shii_qingfengfan_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.shii_su1) {
            title_text.setText("酥");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.shii_su_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.shii_su_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.shii_yingtao) {
            title_text.setText("樱桃");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.shii_yingtao_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.shii_yingtao_xq).into(image_detail);
        }
        //yi
        if (image == cn.dq.www.guangchangan.R.id.yi_funv1) {
            title_text.setText("妇女");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.yi_funv_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.yi_funv_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.yi_gongqing1) {
            title_text.setText("公卿");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.yi_gongqing_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.yi_gongqing_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.yi_junren1) {
            title_text.setText("军人");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.yi_junren_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.yi_junren_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.yi_tianzi1) {
            title_text.setText("天子");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.yi_tianzi_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.yi_tianzi_xq).into(image_detail);
        }
        //ke
        if (image == cn.dq.www.guangchangan.R.id.ke_bishu1) {
            title_text.setText("避暑");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.ke_bishu_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.ke_bishu_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.ke_cunchushui1) {
            title_text.setText("存储水");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.ke_cunchushui_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.ke_cunchushui_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.ke_huobi1) {
            title_text.setText("货币");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.ke_huobi_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.ke_huobi_xq).into(image_detail);
        }
        if (image == cn.dq.www.guangchangan.R.id.ke_kaoli1) {
            title_text.setText("烤梨");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.ke_kaoli_xq, options);
            ImageTools.fitImage(this, image_detail, options.outWidth, options.outHeight);
            Glide.with(this).load(cn.dq.www.guangchangan.R.drawable.ke_kaoli_xq).into(image_detail);
        }
    }


    @OnClick(cn.dq.www.guangchangan.R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }



}
