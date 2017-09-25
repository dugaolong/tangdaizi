package com.xian.www.tangdaizi.three;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;

import com.xian.www.tangdaizi.R;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/20.
 * 导游助手
 */

public class DmgdaoyouActivity extends Activity {
    private Button playButton;
    private Button stopButton;
    private MediaPlayer mediaPlayer;
    private SeekBar audio_seekBar;
    //记录播放位置
    private int time;
    //记录是否暂停
    private boolean flage = false, isChanging = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.three_dmg_daoyou);

        //using butter knife
        ButterKnife.inject(this);

        playButton=(Button)findViewById(R.id.playButton);
        stopButton=(Button)findViewById(R.id.stopButton);
        //播放MP3
        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(playButton.getText().toString().equals("播放")){
                    boolean createState=false;
                    if(mediaPlayer==null){
                        mediaPlayer=createLocalMp3();
                        createState=true;
                    }
                    //当播放完音频资源时，会触发onCompletion事件，可以在该事件中释放音频资源，
                    //以便其他应用程序可以使用该资源:
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.release();//释放音频资源
                            stopButton.setEnabled(false);
                            setTitle("资源已经被释放了");
                        }
                    });
                    try {
                        //在播放音频资源之前，必须调用Prepare方法完成些准备工作
                        if(createState) mediaPlayer.prepare();
                        //开始播放音频
                        mediaPlayer.start();
                        playButton.setText("暂停");
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if(playButton.getText().toString().equals("暂停")){
                    if(mediaPlayer!=null){
                        mediaPlayer.pause();//暂停
                        playButton.setText("播放");
                    }
                }
                stopButton.setEnabled(true);
            }
        });

        //停止
        stopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null){
                    mediaPlayer.stop();//停止播放
                    mediaPlayer.release();//释放资源
                    mediaPlayer=null;
                    playButton.setText("播放");
                    stopButton.setEnabled(false);
                }
            }
        });

    }

    /**
     * 创建本地MP3
     * @return
     */
    public MediaPlayer createLocalMp3(){
        /**
         * 创建音频文件的方法：
         * 1、播放资源目录的文件：MediaPlayer.create(MainActivity.this,R.raw.beatit);//播放res/raw 资源目录下的MP3文件
         * 2:播放sdcard卡的文件：mediaPlayer=new MediaPlayer();
         *   mediaPlayer.setDataSource("/sdcard/beatit.mp3");//前提是sdcard卡要先导入音频文件
         */
        MediaPlayer mp=MediaPlayer.create(this,R.raw.a_dmg);
        mp.stop();
        return mp;
    }


    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }

}
