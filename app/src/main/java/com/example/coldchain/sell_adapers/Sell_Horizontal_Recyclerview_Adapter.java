package com.example.coldchain.sell_adapers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coldchain.R;
import com.example.coldchain.beans.Children_goods;
import com.example.coldchain.sell_beans.S1_children_goods;

import java.util.List;

public class Sell_Horizontal_Recyclerview_Adapter extends RecyclerView.Adapter {

    List<S1_children_goods> goodsList;

    public Sell_Horizontal_Recyclerview_Adapter(List<S1_children_goods> goodsList) {
        this.goodsList = goodsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_b1_top_recyclerview, parent, false);
        TopItem holder = new TopItem(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TopItem topItem= (TopItem) holder;
        S1_children_goods children_goods=goodsList.get(position);
        topItem.imageView.setImageResource(children_goods.getImageId());
        topItem.textView.setText(children_goods.getName());
    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    public class TopItem extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView imageView;
        TextView textView;

        public TopItem(@NonNull View itemView) {
            super(itemView);

            cardView= (CardView) itemView;
            imageView=itemView.findViewById(R.id.b1_top_icon);
            textView=itemView.findViewById(R.id.b1_top_context);

        }
    }
}
