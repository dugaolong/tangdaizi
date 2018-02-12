package cn.dq.www.guangchangan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView> {

    private List<String> urls;
    private Context mContext;
    private List<Integer> heightList;
    private RecyclerViewItemViewListener listener;

    public MasonryAdapter(Context context, List<String> list) {
        this.mContext = context;
        urls = list;
        heightList = new ArrayList<>();

    }

    public void setHeightList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            int height = (int) (Math.random() * 200 + 300);
            heightList.add(height);
        }
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(cn.dq.www.guangchangan.R.layout.grid_item, viewGroup, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, final int position) {
                //改变holder.button的高度
        int height = heightList.get(position);
        ViewGroup.LayoutParams lp = masonryView.imageView.getLayoutParams();
        lp.height = height;
        masonryView.imageView.setLayoutParams(lp);
        String urlPic = urls.get(position);
        if(urlPic.contains("drawable/pic01")){
            Glide.with(mContext)
//                .load(urls.get(position).startsWith("R")?Integer.parseInt(urls.get(position)):urls.get(position))
                    .load(cn.dq.www.guangchangan.R.drawable.pic01)
                    .error(cn.dq.www.guangchangan.R.drawable.camera)
                    .into(masonryView.imageView);
        }else if(urlPic.contains("drawable/pic02")){
            Glide.with(mContext)
//                .load(urls.get(position).startsWith("R")?Integer.parseInt(urls.get(position)):urls.get(position))
                    .load(cn.dq.www.guangchangan.R.drawable.pic02)
                    .error(cn.dq.www.guangchangan.R.drawable.camera)
                    .into(masonryView.imageView);
        }else if(urlPic.contains("drawable/pic03")){
            Glide.with(mContext)
//                .load(urls.get(position).startsWith("R")?Integer.parseInt(urls.get(position)):urls.get(position))
                    .load(cn.dq.www.guangchangan.R.drawable.pic03)
                    .error(cn.dq.www.guangchangan.R.drawable.camera)
                    .into(masonryView.imageView);
        }else if(urlPic.contains("drawable/pic04")){
            Glide.with(mContext)
//                .load(urls.get(position).startsWith("R")?Integer.parseInt(urls.get(position)):urls.get(position))
                    .load(cn.dq.www.guangchangan.R.drawable.pic04)
                    .error(cn.dq.www.guangchangan.R.drawable.camera)
                    .into(masonryView.imageView);
        }else {
            Glide.with(mContext)
//                .load(urls.get(position).startsWith("R")?Integer.parseInt(urls.get(position)):urls.get(position))
                    .load(urlPic)
                    .error(cn.dq.www.guangchangan.R.drawable.camera)
                    .into(masonryView.imageView);
        }


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
            imageView = (ImageView) itemView.findViewById(cn.dq.www.guangchangan.R.id.image);
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