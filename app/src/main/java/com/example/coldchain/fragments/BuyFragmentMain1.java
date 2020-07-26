package com.example.coldchain.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.coldchain.R;
import com.example.coldchain.adapters.Goods_Adapter;
import com.example.coldchain.beans.Goods;

import java.util.ArrayList;
import java.util.List;

public class BuyFragmentMain1 extends Fragment implements View.OnClickListener{
    private Context mContext;
    private View view;
    RecyclerView b1_top_recyclerView;
    List<Goods> goodsList=new ArrayList<>();
    SwipeRefreshLayout s1_swipeRefreshLayout;

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
            view = inflater.inflate(R.layout.buy_fragment_main1, null);
            //初始化控件
            initview();

            goodsList=Goods.getDatas();

            LinearLayoutManager manager=new LinearLayoutManager(getActivity());
            b1_top_recyclerView.setLayoutManager(manager);

            Goods_Adapter news_adapter=new Goods_Adapter(goodsList);
            b1_top_recyclerView.setAdapter(news_adapter);

            s1_swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
            s1_swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    refreshGoods();
                }
            });
        }
        return view;

    }
    private void refreshGoods() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        goodsList.clear();

                        goodsList=Goods.getDatas();

                        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
                        b1_top_recyclerView.setLayoutManager(manager);

                        Goods_Adapter goods_adapter=new Goods_Adapter(goodsList);
                        b1_top_recyclerView.setAdapter(goods_adapter);

                        goods_adapter.notifyDataSetChanged();
                        s1_swipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(mContext, "刷新成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }

    private void initview() {
        b1_top_recyclerView=view.findViewById(R.id.b1_top_recyclerview);
        s1_swipeRefreshLayout=view.findViewById(R.id.s1_swiperefreshlayout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}
