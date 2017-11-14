package com.xian.www.tangdaizi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.ui.CangkuActivity;
import com.xian.www.tangdaizi.ui.HaoyouActivity;
import com.xian.www.tangdaizi.ui.PictureActivity;
import com.xian.www.tangdaizi.ui.SetActivity;
import com.xian.www.tangdaizi.utils.SPUtil;


public class MainTab04 extends Fragment  {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_tab_04, container, false);

        TextView home = (TextView) view.findViewById(R.id.home);
        TextView textView = (TextView) view.findViewById(R.id.title_text);
        TextView tv_name = (TextView) view.findViewById(R.id.name);
        Button update = (Button) view.findViewById(R.id.update);
        LinearLayout haoyou = (LinearLayout) view.findViewById(R.id.haoyou);
        LinearLayout cangku = (LinearLayout) view.findViewById(R.id.cangku);
        LinearLayout set = (LinearLayout) view.findViewById(R.id.set);
        textView.setText("个人中心");
//        home.setText(SPUtil.appget(getActivity(),"age","20")+"岁    来自"+SPUtil.appget(getActivity(),"school","学校"));
        String namesp = SPUtil.appget(getActivity(),"name","小花");
//        tv_name.setText(namesp);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PictureActivity.class));
            }
        });
        cangku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CangkuActivity.class));
            }
        });
        haoyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HaoyouActivity.class));
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SetActivity.class));
            }
        });
        return view;
    }

}
