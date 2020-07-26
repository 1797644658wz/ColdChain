package com.example.coldchain.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.coldchain.R;

public class SellFragmentMain2 extends Fragment implements View.OnClickListener{

    private Context mContext;
    private View view;
    Button getlocal;
    EditText ed_set_local;
    Button subbit_button;

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
            view = inflater.inflate(R.layout.sell_fragment_main2, null);
            //初始化控件
            initview();

        }
        return view;

    }

    private void initview() {
        getlocal=view.findViewById(R.id.get_button);
        getlocal.setOnClickListener(this);

        subbit_button=view.findViewById(R.id.submit_button);
        subbit_button.setOnClickListener(this);

        ed_set_local=view.findViewById(R.id.ed_set_local);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.get_button:
                ed_set_local.setText("贵州轻工职业技术学院");
                break;

            case R.id.submit_button:
                Toast.makeText(mContext, "数据上传成功！", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
