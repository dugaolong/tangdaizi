package cn.dq.www.guangchangan.second.gongyi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import cn.dq.www.guangchangan.R;
import cn.dq.www.guangchangan.adapter.RecyclerViewItemViewListener;

import java.util.ArrayList;
import java.util.List;

public class GyAdapter extends RecyclerView.Adapter<GyAdapter.MasonryView> {

    private List<Integer> urls;
    private Context mContext;
    private RecyclerViewItemViewListener listener;
    private List<Integer> heightList;

    public GyAdapter(Context context) {
        this.mContext = context;
        heightList = new ArrayList<>();
        urls = new ArrayList<>();
        urls.add(R.drawable.gy_one);
        urls.add(R.drawable.gy_two);
        urls.add(R.drawable.gy_three);
        urls.add(R.drawable.gy_four);
        urls.add(R.drawable.gy_five);
        urls.add(R.drawable.gy_six);
        urls.add(R.drawable.gy_seven);
        urls.add(R.drawable.gy_eight);
        urls.add(R.drawable.gy_nine);
        urls.add(R.drawable.gy_ten);
        urls.add(R.drawable.gy_eleven);
        urls.add(R.drawable.gy_twelve);
        setHeightList(urls);
    }

    public void setHeightList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int height = (int) (Math.random() * 200 + 300);
            heightList.add(height);
        }
    }



    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item, viewGroup, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, final int position) {
                //改变holder.button的高度
        int height = heightList.get(position);
        ViewGroup.LayoutParams lp = masonryView.imageView.getLayoutParams();
        lp.height = height;
        masonryView.imageView.setLayoutParams(lp);
        Glide.with(mContext)
                .load(urls.get(position))
                .error(R.drawable.camera)
                .into(masonryView.imageView);

        masonryView.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return urls.size();
    }

    public class MasonryView extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        int position;

        public MasonryView(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            if(listener != null){//判断RecyclerViewItemViewListener是否为空，
                // 若为空，不能给子条目设置点击事件，否则会出现空指针
                itemView.setOnClickListener(this);
            }
        }

        public void setPosition(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            listener.onClickListener(this,position);
        }

    }


    /**
     * 给itemView监听器赋值
     *
     * @param listener
     */
    public void setOnRecyclerViewItemViewListener(RecyclerViewItemViewListener listener) {
        this.listener = listener;
    }

}