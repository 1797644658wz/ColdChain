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
import com.example.coldchain.adapters.Mine_Adapter;
import com.example.coldchain.beans.B_Mine;

import java.util.ArrayList;
import java.util.List;

public class BuyFragmentMain3 extends Fragment {

    private Context mContext;
    private View view;
    RecyclerView recyclerView;
    List<B_Mine> b_mineList=new ArrayList<>();

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
            view = inflater.inflate(R.layout.buy_fragment_main3, null);
            //初始化控件
            initview();

            b_mineList=B_Mine.getdata();

            LinearLayoutManager manager=new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(manager);

            Mine_Adapter news_adapter=new Mine_Adapter(b_mineList);
            recyclerView.setAdapter(news_adapter);

        }
        return view;

    }

    private void initview() {
        recyclerView=view.findViewById(R.id.b3_mine_recyclerview);
    }
}
