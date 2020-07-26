package com.example.coldchain.sell_adapers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.coldchain.MainActivity;
import com.example.coldchain.R;
import com.example.coldchain.adapters.Horizontal_Recyclerview_Adapter;
import com.example.coldchain.b_mine_activity.Car_situation;
import com.example.coldchain.beans.B_Mine;
import com.example.coldchain.beans.Children_goods;
import com.example.coldchain.sell_beans.S_Mine;

import java.util.List;

public class Sell_Mine_Adapter extends RecyclerView.Adapter {

    List<S_Mine> goodsList;
    Context context;
    List<Children_goods> recyclerview_childrenList1;

    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;
    private static final int TYPE_THREE = 3;
    private static final int TYPE_FORE = 4;

    public Sell_Mine_Adapter(List<S_Mine> goodsList) {
        this.goodsList = goodsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {

            case TYPE_ONE:
                //banner类型
                if (context == null) {
                    context = parent.getContext();
                }
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_b2_dingdan, parent, false);
                final DingdanItem holder1 = new DingdanItem(view1);

                holder1.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "别点我，我还没有功能！", Toast.LENGTH_SHORT).show();
                    }
                });
                return holder1;
            case TYPE_TWO:
                //一张图片，一段文字
                if (context == null) {
                    context = parent.getContext();
                }
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_b1_top_recyclerview, parent, false);
                TopItem holder2 = new TopItem(view2);
                return holder2;

            case TYPE_THREE:
                //Recyclerview类型
                if (context == null) {
                    context = parent.getContext();
                }
                View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.b1_children_recyclerview1, parent, false);
                Recyclerview_Children_one holder3 = new Recyclerview_Children_one(view3);
                return holder3;

            case TYPE_FORE:
                //Mine_1类型
                if (context == null) {
                    context = parent.getContext();
                }
                View view4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mine, parent, false);
                final MineItem1 holder4 = new MineItem1(view4);

                holder4.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder4.getAdapterPosition();
                        S_Mine b_mine = goodsList.get(position);
                        switch (position) {
                            case 1:
                                Toast.makeText(v.getContext(), "钱包", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(v.getContext(), "账单查询", Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                Intent login_out = new Intent(v.getContext(), MainActivity.class);
                                v.getContext().startActivity(login_out);
                                Toast.makeText(context, "退出登录成功！", Toast.LENGTH_SHORT).show();
                                break;
                        }

                    }
                });
                return holder4;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_ONE:

                DingdanItem dingdanItem = (DingdanItem) holder;
                S_Mine dingDanBean = goodsList.get(position);
                Glide.with(holder.itemView.getContext()).load(dingDanBean.imgUrls[0]).into(dingdanItem.imageView);
                dingdanItem.dd_time.setText(dingDanBean.getContent());
                dingdanItem.dd_id.setText(dingDanBean.getSource());
                break;

            case TYPE_TWO:
                TopItem topItem = (TopItem) holder;
                S_Mine goods = goodsList.get(position);
                topItem.textView.setText(goods.getContent());
                Glide.with(holder.itemView.getContext()).load(goods.imgUrls[0]).into(topItem.imageView);
                break;

            case TYPE_THREE:
                Recyclerview_Children_one heng_item = (Recyclerview_Children_one) holder;
                recyclerview_childrenList1 = Children_goods.getChildren_Datas();
                Horizontal_Recyclerview_Adapter children_new_adapter = new Horizontal_Recyclerview_Adapter(recyclerview_childrenList1);

                GridLayoutManager layoutManager = new GridLayoutManager(context, 4);
                heng_item.recyclerView.setLayoutManager(layoutManager);
                heng_item.recyclerView.setHasFixedSize(false);
                heng_item.recyclerView.setAdapter(children_new_adapter);
                break;

            case TYPE_FORE:
                MineItem1 mineItem1 = (MineItem1) holder;
                S_Mine b_mine = goodsList.get(position);
                mineItem1.textView.setText(b_mine.getContent());
                Glide.with(holder.itemView.getContext()).load(b_mine.imgUrls[0]).into(mineItem1.imageView);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        S_Mine goods = goodsList.get(position);
        if (goods.TYPE == 1) {
            return TYPE_ONE;
        } else if (goods.TYPE == 2) {
            return TYPE_TWO;
        } else if (goods.TYPE == 3) {
            return TYPE_THREE;
        } else {
            return TYPE_FORE;
        }
    }

    public class DingdanItem extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView dd_time;
        TextView dd_id;
        TextView dd_name;
        CardView cardView;

        public DingdanItem(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView) itemView;
            imageView = itemView.findViewById(R.id.b2_dingdan_icon);
            dd_time = itemView.findViewById(R.id.b2_dingdan_time);
            dd_id = itemView.findViewById(R.id.b2_dingdan_id);
            dd_name = itemView.findViewById(R.id.b2_dingdan_name);
        }
    }

    public class TopItem extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imageView;
        TextView textView;

        public TopItem(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView) itemView;
            imageView = itemView.findViewById(R.id.b1_top_icon);
            textView = itemView.findViewById(R.id.b1_top_context);
        }
    }

    public class Recyclerview_Children_one extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        public Recyclerview_Children_one(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.b1_children_recyclerview);
        }
    }

    public class MineItem1 extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imageView;
        TextView textView;

        public MineItem1(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView) itemView;
            imageView = itemView.findViewById(R.id.b3_mine_icon);
            textView = itemView.findViewById(R.id.b3_mine_context);
        }
    }
}
