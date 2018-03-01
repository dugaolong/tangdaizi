package cn.dq.www.guangchangan.second;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.dq.www.guangchangan.second.zhuye.MijiDetailActivity;
import cn.dq.www.guangchangan.utils.VideoActivity;

/**
 * Created by dugaolong on 17/9/16.
 * 华清池
 */

public class HqcActivityShipin extends Activity {

    @InjectView(cn.dq.www.guangchangan.R.id.play)
    RelativeLayout play;
    @InjectView(cn.dq.www.guangchangan.R.id.miji)
    ImageView miji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(cn.dq.www.guangchangan.R.layout.sec_hqc);
        //using butter knife
        ButterKnife.inject(this);

    }

    @OnClick(cn.dq.www.guangchangan.R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }

    @OnClick(cn.dq.www.guangchangan.R.id.play)   //播放视频
    public void play() {
        Bundle mbundle = new Bundle();
        Intent intent = new Intent(this, VideoActivity.class);
        mbundle.putString("url", "http://player.youku.com/embed/XMzI2NTgzMzc4MA==");
        intent.putExtras(mbundle);
        startActivity(intent);
    }

    @OnClick(cn.dq.www.guangchangan.R.id.miji)   //秘籍
    public void miji() {
        startActivity(new Intent(this, MijiDetailActivity.class));
    }


}
