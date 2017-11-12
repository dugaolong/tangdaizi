package com.xian.www.tangdaizi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.xian.www.tangdaizi.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * Created by dugaolong on 17/9/13.
 * 排行榜
 */

public class RankingActivity extends Activity {

    @InjectView(R.id.first)
    TextView first;
    @InjectView(R.id.second)
    TextView second;
    @InjectView(R.id.thirt)
    TextView thirt;
    @InjectView(R.id.fourth)
    TextView fourth;
    @InjectView(R.id.fiveth)
    TextView fiveth;
    private List<String> schools = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking);

        //using butter knife
        ButterKnife.inject(this);

        schools.add("西安市大雁塔小学");
        schools.add("陕西师范大学附属小学");
        schools.add("西安建筑科技大学附属小学");
        schools.add("曲江第一小学");
        schools.add("曲江第三小学");
        Collections.shuffle(schools);

        first.setText(schools.get(0));
        second.setText(schools.get(1));
        thirt.setText(schools.get(2));
        fourth.setText(schools.get(3));
        fiveth.setText(schools.get(4));
    }


}
