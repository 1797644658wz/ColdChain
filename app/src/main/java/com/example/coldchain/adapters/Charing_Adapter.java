package com.example.coldchain.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.coldchain.R;
import com.example.coldchain.beans.B_Mine;
import com.example.coldchain.beans.B_Mine_Batter;
import com.example.coldchain.beans.DingDanBean;

import java.util.List;

public class Charing_Adapter extends RecyclerView.Adapter {

    Context context;
    List<B_Mine_Batter> b_mine_batterList;

    public Charing_Adapter(List<B_Mine_Batter> b_mine_batterList) {
        this.b_mine_batterList = b_mine_batterList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_charing, parent, false);
        final CharingItem holder = new CharingItem(view);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                B_Mine_Batter b_mine_batter = b_mine_batterList.get(position);
                Toast.makeText(v.getContext(),"进入" + b_mine_batter.getCharing_name(), Toast.LENGTH_SHORT).show();
                /*Intent intent=new Intent(v.getContext(), Local.class);
                v.getContext().startActivity(intent);*/
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CharingItem charingItem= (CharingItem) holder;
        B_Mine_Batter b_mine_batter=b_mine_batterList.get(position);
        charingItem.charing_name.setText(b_mine_batter.getCharing_name());
        charingItem.charing_distance.setText(b_mine_batter.getCharing_distance());
        charingItem.charing_other.setText(b_mine_batter.getCharing_other());
    }

    @Override
    public int getItemCount() {
        return b_mine_batterList.size();
    }

    class CharingItem extends RecyclerView.ViewHolder{

        TextView charing_name;
        TextView charing_distance;
        TextView charing_other;
        CardView cardView;

        public CharingItem(@NonNull View itemView) {
            super(itemView);

            cardView= (CardView) itemView;
            charing_name=itemView.findViewById(R.id.charing_name);
            charing_distance=itemView.findViewById(R.id.charing_distance);
            charing_other=itemView.findViewById(R.id.charing_other);
        }
    }

}
