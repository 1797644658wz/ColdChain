package com.example.coldchain.beans;

import com.example.coldchain.R;

import java.util.ArrayList;
import java.util.List;

public class Children_goods {

    private int ImageId;

    private String name;

    public Children_goods(int imageId, String name) {
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

    public static List<Children_goods> getChildren_Datas(){
        List<Children_goods> children_goodsList=new ArrayList<>();


        Children_goods data1 = new Children_goods(R.drawable.ic_call_black_24dp, "反馈");
        children_goodsList.add(data1);
        Children_goods data2 = new Children_goods(R.drawable.ic_notifications_active_black_24dp, "警报");
        children_goodsList.add(data2);
        Children_goods data3 = new Children_goods(R.drawable.ic_payment_24dp, "支付");
        children_goodsList.add(data3);
        Children_goods data4 = new Children_goods(R.drawable.ic_local_florist_black_24dp, "爱心助农");
        children_goodsList.add(data4);
        Children_goods data5 = new Children_goods(R.drawable.ic_more_24dp, "更多");
        children_goodsList.add(data5);

        return children_goodsList;
    }
}
