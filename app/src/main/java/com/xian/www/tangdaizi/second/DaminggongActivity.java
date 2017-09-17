package com.xian.www.tangdaizi.second;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.xian.www.tangdaizi.R;

/**
 * Created by dugaolong on 17/9/16.
 */

public class DaminggongActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sec_daminggong);

    }


    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.sec_daminggong, container, false);
//        TextView textView = (TextView) view.findViewById(R.id.title_text);
//        textView.setText("公益");
//        return view;
//    }
}
