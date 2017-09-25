package com.xian.www.tangdaizi.three;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.widget.CustomVideoView;

import java.io.ByteArrayOutputStream;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/20.
 * 导游助手
 */

public class DtdaoyouActivity extends Activity {


    private Button btnPause, btnPlayUrl;

    private CustomVideoView videoview;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.three_dt_daoyou);

        //using butter knife
        ButterKnife.inject(this);
        image = (ImageView) findViewById(R.id.image);
        videoview = (CustomVideoView) findViewById(R.id.videoview);

        btnPlayUrl = (Button) this.findViewById(R.id.btnPlayUrl);
        btnPlayUrl.setOnClickListener(new VideoClickEvent());

        btnPause = (Button) this.findViewById(R.id.btnPause);
        btnPause.setOnClickListener(new VideoClickEvent());
        MediaMetadataRetriever rev = new MediaMetadataRetriever();

        rev.setDataSource(this, Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.r_dt)); //这里第一个参数需要Context，传this指针


        Bitmap bitmap = rev.getFrameAtTime(videoview.getCurrentPosition() * 1000, MediaMetadataRetriever.OPTION_CLOSEST_SYNC);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] bytes=baos.toByteArray();
        Glide.with(this).load(bytes).into(image);

    }

    class VideoClickEvent implements View.OnClickListener {

        @Override
        public void onClick(View arg0) {
            if (arg0 == btnPause) {
                videoview.pause();
            } else if (arg0 == btnPlayUrl) {
                image.setVisibility(View.GONE);
                //设置播放加载路径
                videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.r_dt));
                //播放
                videoview.start();
                //循环播放
                videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        videoview.start();
                    }
                });
            }
        }
    }

    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }



}
