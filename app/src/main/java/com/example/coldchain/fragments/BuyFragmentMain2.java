package com.example.coldchain.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.coldchain.Local;
import com.example.coldchain.R;
import com.example.coldchain.adapters.B2_DingDan_Adapter;
import com.example.coldchain.adapters.Goods_Adapter;
import com.example.coldchain.adapters.Horizontal_Recyclerview_Adapter;
import com.example.coldchain.adapters.TableLayoutAdapter;
import com.example.coldchain.beans.Children_goods;
import com.example.coldchain.beans.DingDanBean;
import com.example.coldchain.beans.Goods;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class BuyFragmentMain2 extends Fragment implements View.OnClickListener{
    private Context mContext;
    private View view;
    TabLayout tabLayout;
    ViewPager viewPager;
    List<Fragment> fragments=new ArrayList<>();
    /*Button local;
    RecyclerView recyclerView;
    List<DingDanBean> goodsList=new ArrayList<>();*/

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
            view = inflater.inflate(R.layout.buy_fragment_main2, null);
            //初始化控件
            initFragment();
            initview();

            /*goodsList = DingDanBean.getData();

            LinearLayoutManager manager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(manager);

            B2_DingDan_Adapter adapter = new B2_DingDan_Adapter(goodsList);

            recyclerView.setAdapter(adapter);*/

            TableLayoutAdapter adapter=new TableLayoutAdapter(getFragmentManager(),fragments);
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);

        }
        return view;

    }

    private void initFragment() {
        fragments.add(new BuyFragmentMain2_children1());
        fragments.add(new BuyFragmentMain2_children2());

    }

    private void initview() {
        /*recyclerView=view.findViewById(R.id.b2_recyclerview);*/
        tabLayout=view.findViewById(R.id.tab_layout);
        viewPager=view.findViewById(R.id.view_pager);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }
}
