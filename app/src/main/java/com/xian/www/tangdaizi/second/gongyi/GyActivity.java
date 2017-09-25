package com.xian.www.tangdaizi.second.gongyi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.xian.www.tangdaizi.R;
import com.xian.www.tangdaizi.adapter.DividerGridItemDecoration;
import com.xian.www.tangdaizi.adapter.RecyclerViewItemViewListener;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dugaolong on 17/9/25.
 */

public class GyActivity extends Activity {

    private final String TAG = "GyActivity";
    GyAdapter adapter;

    @InjectView(R.id.rv_id)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gongyi);

        //using butter knife
        ButterKnife.inject(this);

        //设置布局管理器
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //添加分隔符
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        adapter = new GyAdapter(this);
        //设置Adapter
        recyclerView.setAdapter(adapter);

        //为子条目设置点击事件
        adapter.setOnRecyclerViewItemViewListener(new RecyclerViewItemViewListener() {
            @Override
            public void onClickListener(RecyclerView.ViewHolder viewHolder, int position) {
                Intent intent = new Intent(GyActivity.this, GyPictureDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                intent.putExtras(bundle);
                startActivity(intent);
            }

        });
    }

}
