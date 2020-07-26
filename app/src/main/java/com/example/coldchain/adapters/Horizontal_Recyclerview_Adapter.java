package com.example.coldchain.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coldchain.Buy_Activity;
import com.example.coldchain.R;
import com.example.coldchain.b_mine_activity.Car_situation;
import com.example.coldchain.b_mine_activity.Get_person;
import com.example.coldchain.b_mine_activity.S1_Goods_Activity;
import com.example.coldchain.beans.Children_goods;
import com.example.coldchain.beans.Goods;

import java.util.List;

public class Horizontal_Recyclerview_Adapter extends RecyclerView.Adapter {

    Context context;
    List<Children_goods> goodsList;

    public Horizontal_Recyclerview_Adapter(List<Children_goods> goodsList) {
        this.goodsList = goodsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_b1_top_recyclerview, parent, false);
        final TopItem holder = new TopItem(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Children_goods children_goods = goodsList.get(position);

                switch (position){
                    case 0:
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:18302630842"));
                        v.getContext().startActivity(call);
                        Toast.makeText(v.getContext(), "给蒋涛打电话！", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Intent situation_car = new Intent(v.getContext(), Car_situation.class);
                        v.getContext().startActivity(situation_car);
                        break;
                    case 2:
                        break;
                    case 3:
                        Intent get_persion = new Intent(v.getContext(), Get_person.class);
                        v.getContext().startActivity(get_persion);
                        break;
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TopItem topItem= (TopItem) holder;
        Children_goods children_goods=goodsList.get(position);
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
