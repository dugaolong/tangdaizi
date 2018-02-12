package cn.dq.www.guangchangan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import cn.dq.www.guangchangan.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private Context context;
    private List<String> list;
    private List<Integer> heightList;
    private RecyclerViewItemViewListener listener ;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;

//        heightList = new ArrayList<>();
//        for (int i = 0; i < list.size() ; i++) {
//            int height = (int) (Math.random()*400 + 400);
//            heightList.add(height);
//        }

    }

    /**
     * 给itemView监听器赋值
     * @param listener
     */
    public void setOnRecyclerViewItemViewListener(RecyclerViewItemViewListener listener){
        this.listener = listener;
    }

    int i = 0;
    /**
     * 创建ViewHolder对contentView进行复用
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        i++;
        Log.e("MyAdapter","----------------onCreateViewHolder-----------i:"+i);
        View contentView = LayoutInflater.from(context).inflate(R.layout.grid_item,parent,false);
        return new ViewHolder(contentView);
    }

    /**
     * 进行数据绑定，itemView设置数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

//        //改变holder.button的高度
//        int height = heightList.get(position);
//        ViewGroup.LayoutParams lp = holder.imageView.getLayoutParams();
//        lp.height = height;
//        holder.imageView.setLayoutParams(lp);

        Log.e("MyAdapter","----------------onBindViewHolder-----------position："+position);
//        if(list.size()<=0){
//            Glide.with(context).load(R.drawable.camera).into(holder.imageView);
//        }else {
            Glide.with(context)
                    .load(list.get(position))
                    .error(R.drawable.camera)
                    .into(holder.imageView);
//        }

//        WXHLImageLoader.getInstance().displayImage(list.get(position),holder.imageView);
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        private int position;

        public ViewHolder(View itemView) {
            super(itemView);
            //为ViewHolder中的组件进行赋值
            imageView = (ImageView) itemView.findViewById(R.id.image);

            if(listener != null){//判断RecyclerViewItemViewListener是否为空，
                                // 若为空，不能给子条目设置点击事件，否则会出现空指针
                itemView.setOnClickListener(this);
//                itemView.setOnLongClickListener(this);
            }
        }

        public void setPosition(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.image://itemView的点击事件
                    listener.onClickListener(this,position);
                    break;
            }
        }

//        @Override
//        public boolean onLongClick(View v) {//itemView的长按事件
//            listener.onLongClickListener(this,position);
//            return true;
//        }
    }
}