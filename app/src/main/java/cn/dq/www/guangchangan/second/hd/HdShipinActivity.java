package cn.dq.www.guangchangan.second.hd;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import cn.dq.www.guangchangan.second.hd.tools.CommonTools;
import cn.dq.www.guangchangan.second.hd.tools.DebugTools;
import cn.dq.www.guangchangan.second.hd.tools.DisplayUtil;
import cn.dq.www.guangchangan.second.hd.video.VideoViewHolderControl;

import butterknife.ButterKnife;


/**
 * Created by dugaolong on 17/9/16.
 * 广告
 */

public class HdShipinActivity extends Activity  {

    public static String URL_VIDEO ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(cn.dq.www.guangchangan.R.layout.shipin);
//        URL_VIDEO = "android.resource://" + getPackageName() + "/" + cn.dq.www.guangchangan.R.raw.hd_shipin;
        URL_VIDEO = "http://player.youku.com/embed/XMzQxNzUzOTMxMg==";
        initView();
        loadData();
    }

    private void initView(){
        ButterKnife.inject(this);
        initFakeStatusBarHeight(true);
    }



    private void loadData(){
        View view = findViewById(cn.dq.www.guangchangan.R.id.activity_video_rl);
        initVideoMode(view);
    }

    protected int mPixelInsetTop;
    protected void initFakeStatusBarHeight(boolean isNewsPage){
        View statusbarBgLayout = (View)findViewById(cn.dq.www.guangchangan.R.id.statusbar_bg_layout);
        if(statusbarBgLayout == null){
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mPixelInsetTop = CommonTools.getStatusbarHeight(this);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)statusbarBgLayout.getLayoutParams();
            params.height = mPixelInsetTop;
            statusbarBgLayout.setLayoutParams(params);
            statusbarBgLayout.setBackgroundResource(cn.dq.www.guangchangan.R.color.black70);
        }else{
            mPixelInsetTop = 0;
            statusbarBgLayout.setVisibility(View.GONE);
        }
    }

    //----------videoview----------------
    private VideoViewHolderControl.VideoViewHolder mVideoHolder;
    private VideoView mVideoView;
    private VideoViewHolderControl mVideoControl;
    private void initVideoMode(View view){
        showFullScreen(false);
        mVideoView = (VideoView) view.findViewById(cn.dq.www.guangchangan.R.id.videoview);
        mVideoHolder = new VideoViewHolderControl.VideoViewHolder(view);
        mVideoHolder.imgIv.setImageResource(cn.dq.www.guangchangan.R.drawable.shipinjietu);
        mVideoControl = new VideoViewHolderControl(mVideoHolder, mVideoView, URL_VIDEO);
        setupVideoControlListener(mVideoControl);
        mVideoControl.setup();
        setVideoViewLayout(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setFullScreen(true);
    }

    private void setupVideoControlListener(VideoViewHolderControl control){
        control.setOnVideoControlListener(new VideoViewHolderControl.OnVideoControlProxy() {
            @Override
            public void onCompletion() {
                DebugTools.d("video2 onCompletion");
                setFullScreen(false);
            }

            @Override
            public void onClickHalfFullScreen() {
                boolean isFull = isFullScreen();
                setFullScreen(!isFull);
            }

            @Override
            public void onError(int code, String msg) {

            }

        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            initHalfFullState(true);
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            initHalfFullState(false);
        }
    }

    private void initHalfFullState(boolean isFull){
        DebugTools.d("video2 initHalfFullState isFull: " + isFull);
        setVideoViewLayout(isFull);
        showFullScreen(isFull);
    }


    //---------videoview fullscreen---------
    private void showFullScreen(boolean isFullScreen){
        if(isFullScreen){
//		      //不显示程序的标题栏
            hideNavigationBar();
        }else{
            showNavigationBar();
        }
    }

    protected void setFullScreen(boolean isFull){
        if(isFull){
            if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        }else{
            if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        }
    }

    protected boolean isFullScreen(){
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    private void showNavigationBar(){
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    public void hideNavigationBar() {
        int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN; // hide status bar

        getWindow().getDecorView().setSystemUiVisibility(uiFlags);
    }

    private void setVideoViewLayout(boolean isFull){
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)mVideoHolder.videoRl.getLayoutParams();
        RelativeLayout.LayoutParams controlParams = (RelativeLayout.LayoutParams)mVideoHolder.mediaControl.getLayoutParams();
        RelativeLayout.LayoutParams indexImageParams = (RelativeLayout.LayoutParams)mVideoHolder.imgIv.getLayoutParams();

        int videoMarginTop = (int)getResources().getDimension(cn.dq.www.guangchangan.R.dimen.library_video_video_margin_top) + mPixelInsetTop;
        if(isFull){
            params.height = RelativeLayout.LayoutParams.MATCH_PARENT;
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            params.setMargins(0, 0, 0, 0);

            controlParams.setMargins(0, 0, 0, 0);

            indexImageParams.height = RelativeLayout.LayoutParams.MATCH_PARENT;
            indexImageParams.setMargins(0, 0, 0, 0);
        }else{
            params.height = DisplayUtil.dip2px(this, 202);
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            params.setMargins(0, videoMarginTop, 0, 0);

            controlParams.setMargins(0, 0, 0, 0);

            indexImageParams.height = DisplayUtil.dip2px(this, 202);
            indexImageParams.setMargins(0, 0, 0, 0);

        }
        mVideoHolder.videoRl.setLayoutParams(params);
        mVideoHolder.mediaControl.setLayoutParams(controlParams);
        mVideoHolder.imgIv.setLayoutParams(indexImageParams);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            handleClickBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void handleClickBack(){
//        if(isFullScreen()){
//            setFullScreen(false);
//            return;
//        }
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
