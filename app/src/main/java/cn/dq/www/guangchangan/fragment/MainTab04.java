package cn.dq.www.guangchangan.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.dq.www.guangchangan.R;
import cn.dq.www.guangchangan.ui.CangkuActivity;
import cn.dq.www.guangchangan.ui.HaoyouActivity;
import cn.dq.www.guangchangan.ui.PictureActivity;
import cn.dq.www.guangchangan.ui.SetActivity;
import cn.dq.www.guangchangan.utils.SPUtil;


public class MainTab04 extends Fragment  {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_tab_04, container, false);

        TextView home = (TextView) view.findViewById(R.id.home);
        LinearLayout tangdou = (LinearLayout) view.findViewById(R.id.tangdou);
        TextView textView = (TextView) view.findViewById(R.id.title_text);
        TextView tv_name = (TextView) view.findViewById(R.id.name);
        Button update = (Button) view.findViewById(R.id.update);
        LinearLayout haoyou = (LinearLayout) view.findViewById(R.id.haoyou);
        LinearLayout cangku = (LinearLayout) view.findViewById(R.id.cangku);
        LinearLayout set = (LinearLayout) view.findViewById(R.id.set);
        textView.setText("个人中心");
        home.setText(SPUtil.appget(getActivity(),"age","20")+"岁    来自"+SPUtil.appget(getActivity(),"school","学校"));
        String namesp = SPUtil.appget(getActivity(),"name","小花");
        tv_name.setText(namesp);

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
        tangdou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
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

    private void showDialog(){
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(getActivity());
        normalDialog.setTitle("你的唐豆数：12个");
        normalDialog.setMessage("唐豆兑换及线上商城即将开放，敬请期待！");
        normalDialog.setPositiveButton("好的",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        // 显示
        normalDialog.show();
    }
}
