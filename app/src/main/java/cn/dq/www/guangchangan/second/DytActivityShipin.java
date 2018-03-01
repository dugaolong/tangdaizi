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
import cn.dq.www.guangchangan.R;
import cn.dq.www.guangchangan.second.zhuye.MijiDetailActivity;
import cn.dq.www.guangchangan.utils.VideoActivity;

/**
 * Created by dugaolong on 17/9/16.
 * 大雁塔
 */

public class DytActivityShipin extends Activity {

    @InjectView(R.id.play)
    RelativeLayout play;
    @InjectView(R.id.miji)
    ImageView miji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sec_dyt);
        //using butter knife
        ButterKnife.inject(this);

    }

    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }

    @OnClick(R.id.play)   //播放视频
    public void play() {
        Bundle mbundle = new Bundle();
        Intent intent = new Intent(this, VideoActivity.class);
        mbundle.putString("url", "http://player.youku.com/embed/XMzI2NTgyODI4NA==");
        intent.putExtras(mbundle);
        startActivity(intent);
    }

    @OnClick(R.id.miji)   //秘籍
    public void miji() {
        startActivity(new Intent(this, MijiDetailActivity.class));
    }

}
