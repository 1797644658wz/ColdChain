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
import com.example.coldchain.sell_adapers.Sell_Mine_Adapter;
import com.example.coldchain.sell_beans.S_Mine;

import java.util.ArrayList;
import java.util.List;

public class SellFragmentMain3 extends Fragment {

    private Context mContext;
    private View view;
    RecyclerView recyclerView;
    List<S_Mine> s_mines=new ArrayList<>();

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
            view = inflater.inflate(R.layout.sell_fragment_main3, null);
            //初始化控件
            initview();

            s_mines=S_Mine.getdata();

            LinearLayoutManager manager=new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(manager);

            Sell_Mine_Adapter news_adapter=new Sell_Mine_Adapter(s_mines);
            recyclerView.setAdapter(news_adapter);

        }
        return view;

    }

    private void initview() {
        recyclerView=view.findViewById(R.id.sell_main_recyclerview);
    }
}
