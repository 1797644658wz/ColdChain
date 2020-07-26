package com.example.coldchain.sell_beans;

import com.example.coldchain.R;
import com.example.coldchain.beans.Children_goods;

import java.util.ArrayList;
import java.util.List;

public class S1_children_goods {

    private int ImageId;

    private String name;

    public S1_children_goods(int imageId, String name) {
        ImageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<S1_children_goods> getDatas(){
        List<S1_children_goods> datas=new ArrayList<>();

        S1_children_goods data1=new S1_children_goods(R.drawable.ic_call_black_24dp,"反馈");
        datas.add(data1);
        S1_children_goods data2=new S1_children_goods(R.drawable.ic_payment_24dp,"钱包");
        datas.add(data2);
        S1_children_goods data3=new S1_children_goods(R.drawable.ic_local_florist_black_24dp,"爱心助农");
        datas.add(data3);
        S1_children_goods data4=new S1_children_goods(R.drawable.ic_more_24dp,"更多");
        datas.add(data4);

        return datas;
    }
}
