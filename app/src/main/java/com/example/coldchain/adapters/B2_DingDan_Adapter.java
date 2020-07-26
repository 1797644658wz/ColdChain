package com.example.coldchain.adapters;

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
import androidx.recyclerview.widget.RecyclerView;

import com.example.coldchain.Local;
import com.example.coldchain.R;
import com.example.coldchain.beans.DingDanBean;

import java.util.List;

public class B2_DingDan_Adapter extends RecyclerView.Adapter {

    List<DingDanBean> dingDanBeanList;
    Context context;

    public B2_DingDan_Adapter(List<DingDanBean> dingDanBeanList) {
        this.dingDanBeanList = dingDanBeanList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_b2_dingdan, parent, false);
        final DingdanItem holder = new DingdanItem(view);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                DingDanBean dingDanBean = dingDanBeanList.get(position);
                Toast.makeText(v.getContext(),"you clicked view " + position, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(v.getContext(),Local.class);
                v.getContext().startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final DingdanItem dingdanItem= (DingdanItem) holder;
        DingDanBean dingDanBean=dingDanBeanList.get(position);
        dingdanItem.imageView.setImageResource(dingDanBean.getDd_imageID());
        dingdanItem.dd_time.setText(dingDanBean.getDd_time());
        dingdanItem.dd_id.setText(dingDanBean.getDd_id());
        dingdanItem.dd_name.setText(dingDanBean.getDd_name());

    }

    @Override
    public int getItemCount() {
        return dingDanBeanList.size();
    }
    public class DingdanItem extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView imageView;
        TextView dd_time;
        TextView dd_id;
        TextView dd_name;

        public DingdanItem(@NonNull View itemView) {
            super(itemView);

            cardView= (CardView) itemView;
            imageView=itemView.findViewById(R.id.b2_dingdan_icon);
            dd_time=itemView.findViewById(R.id.b2_dingdan_time);
            dd_id=itemView.findViewById(R.id.b2_dingdan_id);
            dd_name=itemView.findViewById(R.id.b2_dingdan_name);
        }
    }

}
