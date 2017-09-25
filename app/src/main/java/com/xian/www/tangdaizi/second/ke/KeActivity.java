package com.xian.www.tangdaizi.second.ke;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.three.LengActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by dugaolong on 17/9/20.
 */

public class KeActivity extends Activity {

    @InjectView(R.id.sec_back)
    ImageView sec_back;
    @InjectView(R.id.list)
    ListView listView;  //声明一个ListView对象
    private List<String> mlistInfo = new ArrayList<String>();  //声明一个list，动态存储要显示的信息
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sec_ke);
        //using butter knife
        ButterKnife.inject(this);
        setInfo();  //给信息赋值函数，用来测试

        listView.setAdapter(new ListViewAdapter(mlistInfo));

        //处理Item的点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(KeActivity.this, LengActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    @OnClick(R.id.sec_back)   //返回
    public void sec_back() {
        finish();
    }

    public class ListViewAdapter extends BaseAdapter {
        View[] itemViews;

        public ListViewAdapter(List<String> mlistInfo) {
            // TODO Auto-generated constructor stub
            itemViews = new View[mlistInfo.size()];
            for(int i=0;i<mlistInfo.size();i++){
                String name=mlistInfo.get(i);    //获取第i个对象
                //调用makeItemView，实例化一个Item
                itemViews[i]=makeItemView(name);
            }
        }

        public int getCount() {
            return itemViews.length;
        }

        public View getItem(int position) {
            return itemViews[position];
        }

        public long getItemId(int position) {
            return position;
        }

        //绘制Item的函数
        private View makeItemView(String strTitle) {
            LayoutInflater inflater = (LayoutInflater) KeActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 使用View的对象itemView与R.layout.item关联
            View itemView = inflater.inflate(R.layout.ke_item, null);

            // 通过findViewById()方法实例R.layout.item内各组件
            TextView title = (TextView) itemView.findViewById(R.id.title);
            title.setText(strTitle);    //填入相应的值

            return itemView;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                return itemViews[position];
            return convertView;
        }
    }

    public void setInfo(){
        mlistInfo.clear();
        mlistInfo.add("【八拓将军】");
        mlistInfo.add("度量衡");
        mlistInfo.add("古人的避暑措施");
        mlistInfo.add("唐朝人烧梨");
        mlistInfo.add("深井冰（储存冰的方法）");
        mlistInfo.add("狗咬人怎么判？");
        mlistInfo.add("唐朝外国人众多");
        mlistInfo.add("皇帝给大臣赐护肤品");
    }

}
