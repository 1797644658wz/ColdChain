package com.example.coldchain.sell_adapers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.coldchain.R;
import com.example.coldchain.adapters.Horizontal_Recyclerview_Adapter;
import com.example.coldchain.beans.Children_goods;
import com.example.coldchain.beans.Goods;
import com.example.coldchain.sell_beans.S1_children_goods;
import com.example.coldchain.sell_beans.S1_children_goods_pbl;
import com.example.coldchain.sell_beans.Sell_Goods;
import com.example.coldchain.util.BannerImageLoad;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import java.util.ArrayList;
import java.util.List;

public class Sell_Goods_Adapter extends RecyclerView.Adapter {

    List<Sell_Goods> goodsList;
    Context context;
    List<S1_children_goods> s1_children_goodsList;
    List<S1_children_goods_pbl> s1_children_goods_pblList;

    private static final int TYPE_ONE=1;
    private static final int TYPE_TWO=2;
    private static final int TYPE_THREE=3;
    private static final int TYPE_FORE=4;

    public Sell_Goods_Adapter(List<Sell_Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType){

            case TYPE_ONE:
                //banner类型
                if (context==null){
                    context=parent.getContext();
                }
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_head, parent, false);
                BannerItem holder1 = new BannerItem(view1);
                return holder1;
            case TYPE_TWO:
                //一张图片，一段文字
                if (context==null){
                    context=parent.getContext();
                }
                View view2=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_s1_goods,parent,false);
                TopItem holder2 = new TopItem(view2);
                return holder2;

            case TYPE_THREE:
                //Recyclerview类型
                if (context==null){
                    context=parent.getContext();
                }
                View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.b1_children_recyclerview1, parent, false);
                Recyclerview_Children_one holder3 = new Recyclerview_Children_one(view3);
                return holder3;

            case TYPE_FORE:
                //瀑布流recyclerview
                if (context==null){
                    context=parent.getContext();
                }
                View view4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.b1_children_recyclerview1,parent,false);
                Recyclerview_s1_Children holder4 = new Recyclerview_s1_Children(view4);
                return holder4;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case TYPE_ONE:
                BannerItem titleBanner= (BannerItem) holder;
                titleBanner.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                //设置图片加载器
                titleBanner.banner.setImageLoader(new BannerImageLoad());
                //设置图片集合
                List<Integer> image = new ArrayList<>();
                image.add(R.drawable.login_head);
                image.add(R.drawable.banner1);
                image.add(R.drawable.banner2);
                image.add(R.drawable.banner3);
                image.add(R.drawable.banner4);
                titleBanner.banner.setImages(image);
                //设置banner动画效果
                titleBanner.banner.setBannerAnimation(Transformer.DepthPage);
                //设置标题集合（当banner样式有显示title时）
                /*List<String> titles = new ArrayList<>();
                titles.add("图1");
                titles.add("图2");
                titleBanner.banner.setBannerTitles(titles);*/
                //设置自动轮播，默认为true
                titleBanner.banner.isAutoPlay(true);
                //设置轮播时间
                titleBanner.banner.setDelayTime(3000);
                //设置指示器位置（当banner模式中有指示器时）
                titleBanner.banner.setIndicatorGravity(BannerConfig.CENTER);
                //banner设置方法全部调用完毕时最后调用
                titleBanner.banner.start();
                break;

            case TYPE_TWO:
                TopItem topItem= (TopItem) holder;
                Sell_Goods goods = goodsList.get(position);
                topItem.textView.setText(goods.getContent());
                Glide.with(holder.itemView.getContext()).load(goods.imgUrls[0]).into(topItem.imageView);
                break;

            case TYPE_THREE:
                Recyclerview_Children_one heng_item= (Recyclerview_Children_one) holder;
                s1_children_goodsList= S1_children_goods.getDatas();
                Sell_Horizontal_Recyclerview_Adapter children_new_adapter=new Sell_Horizontal_Recyclerview_Adapter(s1_children_goodsList);

                GridLayoutManager layoutManager = new GridLayoutManager(context,4);
                heng_item.recyclerView.setLayoutManager(layoutManager);
                heng_item.recyclerView.setHasFixedSize(false);
                heng_item.recyclerView.setAdapter(children_new_adapter);
                break;

            case TYPE_FORE:
                Recyclerview_s1_Children pbl_recyclerview_item= (Recyclerview_s1_Children) holder;
                s1_children_goods_pblList=S1_children_goods_pbl.getDatas();
                Sell_Horizontal_Recyclerview_pbl_Adapter sell_horizontal_recyclerview_adapter2=new Sell_Horizontal_Recyclerview_pbl_Adapter(s1_children_goods_pblList);

                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                pbl_recyclerview_item.recyclerView.setLayoutManager(staggeredGridLayoutManager);
                pbl_recyclerview_item.recyclerView.setAdapter(sell_horizontal_recyclerview_adapter2);
                break;

        }

    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Sell_Goods goods=goodsList.get(position);
        if (goods.TYPE==1){
            return TYPE_ONE;
        }else if (goods.TYPE==2){
            return TYPE_TWO;
        }else if (goods.TYPE==3){
            return TYPE_THREE;
        }else {
            return TYPE_FORE;
        }
    }

    public class BannerItem extends RecyclerView.ViewHolder{

        Banner banner;
        public BannerItem(@NonNull View itemView) {
            super(itemView);

            banner=itemView.findViewById(R.id.banner_item);
        }
    }

    public class TopItem extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView imageView;
        TextView textView;

        public TopItem(@NonNull View itemView) {
            super(itemView);

            cardView= (CardView) itemView;
            imageView=itemView.findViewById(R.id.s1_goods_icon);
            textView=itemView.findViewById(R.id.s1_goods_text);
        }
    }
    public class Recyclerview_Children_one extends RecyclerView.ViewHolder{

        RecyclerView recyclerView;

        public Recyclerview_Children_one(@NonNull View itemView) {
            super(itemView);

            recyclerView=itemView.findViewById(R.id.b1_children_recyclerview);
        }
    }
    public class Recyclerview_s1_Children extends RecyclerView.ViewHolder{

        RecyclerView recyclerView;

        public Recyclerview_s1_Children(@NonNull View itemView) {
            super(itemView);

            recyclerView=itemView.findViewById(R.id.b1_children_recyclerview);
        }
    }
}
