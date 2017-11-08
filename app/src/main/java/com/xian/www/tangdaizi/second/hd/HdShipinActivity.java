package com.xian.www.tangdaizi.second.hd;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.xian.www.tangdaizi.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by dugaolong on 17/9/16.
 * 广告
 */

public class HdShipinActivity extends Activity  {
    private MediaPlayer mediaPlayer;
    //记录播放位置
    private int time;
    //记录是否暂停
    private boolean flage = false, isChanging = false;
    private MediaPlayer m;
    private Thread thread;


    private VideoView videoView;
    private ImageView shipinjietu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.shipin);

        //using butter knife
        ButterKnife.inject(this);
        //Media控件设置
        m = new MediaPlayer();
        shipinjietu = (ImageView) findViewById(R.id.shipinjietu);
        videoView = (VideoView) findViewById(R.id.videoView);
        shipinjietu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shipinjietu.setVisibility(View.GONE);
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" +R.raw.hd_shipin);
                videoView.setMediaController(new MediaController(HdShipinActivity.this));
                videoView.setVideoURI(uri);
                videoView.start();
                videoView.requestFocus();
            }
        });
    }

    //Activity从后台重新回到前台时被调用
    @Override
    protected void onRestart() {
        super.onRestart();
        if (m != null) {
            if (m.isPlaying()) {
                m.start();
            }
        }
        if (videoView != null) {
            if (videoView.isPlaying()) {
                videoView.start();
            }
        }
    }

    //Activity被覆盖到下面或者锁屏时被调用
    @Override
    protected void onPause() {
        super.onPause();
        if (m != null) {
            if (m.isPlaying()) {
                m.pause();
            }
        }
        if (videoView != null) {
            if (videoView.isPlaying()) {
                videoView.pause();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (m != null) {
            if (!m.isPlaying()) {
                m.start();
            }
        }
        if (videoView != null) {
            if (!videoView.isPlaying()) {
                videoView.start();
            }
        }
    }

    //Activity被销毁
    protected void onDestroy() {
        if (m.isPlaying()) {
            m.stop();//停止音频的播放
        }
        m.release();//释放资源
        if (videoView.isPlaying()) {
            videoView.suspend();//停止音频的播放
        }
        super.onDestroy();
    }

    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }

}
