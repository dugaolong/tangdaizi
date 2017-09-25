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
import android.widget.SeekBar;

import com.bumptech.glide.Glide;
import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.widget.CustomVideoView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/20.
 * 导游助手
 */

public class DytdaoyouActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    private Button playButton;
    private Button stopButton;
    private MediaPlayer mediaPlayer;
    private SeekBar audio_seekBar;
    //记录播放位置
    private int time;
    //记录是否暂停
    private boolean flage = false, isChanging = false;
    private MediaPlayer m;
    private Thread thread;

    private Button btnPause, btnPlayUrl;

    private CustomVideoView videoview;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.three_dyt_daoyou);

        //using butter knife
        ButterKnife.inject(this);
        //Media控件设置
        m = new MediaPlayer();

        playButton=(Button)findViewById(R.id.playButton);
        stopButton=(Button)findViewById(R.id.stopButton);
        init();

        image = (ImageView) findViewById(R.id.image);
        videoview = (CustomVideoView) findViewById(R.id.videoview);

        btnPlayUrl = (Button) this.findViewById(R.id.btnPlayUrl);
        btnPlayUrl.setOnClickListener(new DytdaoyouActivity.VideoClickEvent());

        btnPause = (Button) this.findViewById(R.id.btnPause);
        btnPause.setOnClickListener(new DytdaoyouActivity.VideoClickEvent());
        MediaMetadataRetriever rev = new MediaMetadataRetriever();

        rev.setDataSource(this, Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.r_dyt)); //这里第一个参数需要Context，传this指针


        Bitmap bitmap = rev.getFrameAtTime(videoview.getCurrentPosition() * 1000, MediaMetadataRetriever.OPTION_CLOSEST_SYNC);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] bytes=baos.toByteArray();
        Glide.with(this).load(bytes).into(image);


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
        if (videoview != null) {
            if (videoview.isPlaying()) {
                videoview.start();
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
        if (videoview != null) {
            if (videoview.isPlaying()) {
                videoview.pause();
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
        if (videoview != null) {
            if (!videoview.isPlaying()) {
                videoview.start();
            }
        }
    }

    //Activity被销毁
    protected void onDestroy() {
        if (m.isPlaying()) {
            m.stop();//停止音频的播放
        }
        m.release();//释放资源
        if (videoview.isPlaying()) {
            videoview.suspend();//停止音频的播放
        }

        super.onDestroy();
    }

    class ClickEvent implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.playButton:
                    if (m.isPlaying()) {
                        //m.getCurrentPosition();获取当前播放位置
                        time = m.getCurrentPosition();
                        // 如果正在播放，则暂停，并把按钮上的文字设置成“暂停”
                        m.pause();
                        playButton.setText("暂停");
                        flage = true;//flage 标记为 ture
                    } else if (flage) {
                        m.start();//先开始播放
                        m.seekTo(time);//设置从哪里开始播放
                        playButton.setText("播放");
                        flage = false;
                    } else {
                        m.reset();//恢复到未初始化的状态
                        m = MediaPlayer.create(DytdaoyouActivity.this, R.raw.a_dyt);//读取音频
                        audio_seekBar.setMax(m.getDuration());//设置SeekBar的长度
                        try {
                            m.prepare();    //准备
                        } catch (IllegalStateException | IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        m.start();  //播放
                        // 创建一个线程
                        playButton.setText("播放");
                    }
                    thread = new Thread(new DytdaoyouActivity.SeekBarThread());
                    // 启动线程
                    thread.start();
                    break;
                case R.id.stopButton:
                    m.stop();
                    audio_seekBar.setProgress(0);
                    break;
            }

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//        now_time.setText("当前播放时间" + ShowTime(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //防止在拖动进度条进行进度设置时与Thread更新播放进度条冲突
        isChanging = true;
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
//        now_time.setText("当前播放时间" + ShowTime(seekBar.getProgress()));
        //将media进度设置为当前seekbar的进度
        m.seekTo(seekBar.getProgress());
        isChanging = false;
        thread = new Thread(new DytdaoyouActivity.SeekBarThread());
        // 启动线程
        thread.start();
    }

    // 自定义的线程
    class SeekBarThread implements Runnable {

        @Override
        public void run() {
            while (!isChanging && m.isPlaying()) {
                // 将SeekBar位置设置到当前播放位置
                audio_seekBar.setProgress(m.getCurrentPosition());
                try {
                    // 每100毫秒更新一次位置
                    Thread.sleep(100);
                    //播放进度
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //时间显示函数,我们获得音乐信息的是以毫秒为单位的，把把转换成我们熟悉的00:00格式
    public String ShowTime(int time) {
        time /= 1000;
        int minute = time / 60;
        int hour = minute / 60;
        int second = time % 60;
        minute %= 60;
        return String.format("%02d:%02d", minute, second);
    }

    private void init() {
        audio_seekBar = (SeekBar) findViewById(R.id.seekbar);
        playButton = (Button) findViewById(R.id.playButton);
        stopButton = (Button) findViewById(R.id.stopButton);
//        now_time = (TextView) findViewById(R.id.now_time);

        playButton.setOnClickListener(new DytdaoyouActivity.ClickEvent());
        stopButton.setOnClickListener(new DytdaoyouActivity.ClickEvent());
        audio_seekBar.setOnSeekBarChangeListener(this);

    }

    class VideoClickEvent implements View.OnClickListener {

        @Override
        public void onClick(View arg0) {
            if (arg0 == btnPause) {
                videoview.pause();
            } else if (arg0 == btnPlayUrl) {
                image.setVisibility(View.GONE);
                //设置播放加载路径
                videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.r_dyt));
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
