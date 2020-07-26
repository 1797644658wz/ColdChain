package com.example.coldchain.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coldchain.R;
import com.example.coldchain.adapters.Goods_Adapter;
import com.example.coldchain.beans.Goods;
import com.example.coldchain.sell_adapers.Sell_Goods_Adapter;
import com.example.coldchain.sell_beans.Sell_Goods;

import java.util.ArrayList;
import java.util.List;

public class SellFragmentMain1 extends Fragment {

    private Context mContext;
    private View view;
    RecyclerView sell_1_recyclerview;
    List<Sell_Goods> sell_goodsList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        if (null != view) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (null != parent) {
                parent.removeView(view);
            }
        } else {
            view = inflater.inflate(R.layout.sell_fragment_main1, null);
            //初始化控件
            initview();

            sell_goodsList=Sell_Goods.getDatas();

            LinearLayoutManager manager=new LinearLayoutManager(getActivity());
            sell_1_recyclerview.setLayoutManager(manager);

            Sell_Goods_Adapter news_adapter=new Sell_Goods_Adapter(sell_goodsList);
            sell_1_recyclerview.setAdapter(news_adapter);

        }
        return view;

    }

    private void initview() {
        sell_1_recyclerview=view.findViewById(R.id.sell_f1_recyclerview);
    }
}
