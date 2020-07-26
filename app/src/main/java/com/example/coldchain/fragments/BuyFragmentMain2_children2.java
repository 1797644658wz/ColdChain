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
import com.example.coldchain.adapters.B2_DingDan_Adapter;
import com.example.coldchain.beans.DingDanBean;

import java.util.ArrayList;
import java.util.List;

public class BuyFragmentMain2_children2 extends Fragment {

    Context mContext;
    View view;
    RecyclerView recyclerView;
    List<DingDanBean> goodsList = new ArrayList<>();

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
            view = inflater.inflate(R.layout.buyfragmentmain2_children2, null);
            //初始化控件
            initview();

            goodsList = DingDanBean.getData();

            LinearLayoutManager manager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(manager);

            B2_DingDan_Adapter adapter = new B2_DingDan_Adapter(goodsList);

            recyclerView.setAdapter(adapter);

        }
        return view;

    }

    private void initview() {
        recyclerView = view.findViewById(R.id.b2_recyclerview_children2);
    }
}
