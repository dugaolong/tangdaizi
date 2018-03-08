package cn.dq.www.guangchangan.second.find;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/16.
 * 华清池
 */

public class Find1 extends Activity {

    @InjectView(cn.dq.www.guangchangan.R.id.title_text)
    TextView title_text;
    @InjectView(cn.dq.www.guangchangan.R.id.image_detail)
    ImageView image_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(cn.dq.www.guangchangan.R.layout.find1);

        //using butter knife
        ButterKnife.inject(this);
        setContent();

    }


    private void setContent() {
        title_text.setText("春晓");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), cn.dq.www.guangchangan.R.drawable.shi_chunxiao_xq, options);
        fitImage(this, image_detail, options.outWidth, options.outHeight);
    }
    @OnClick(cn.dq.www.guangchangan.R.id.sec_back)   //返回
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