package com.example.coldchain.beans;

import com.example.coldchain.R;

import java.util.ArrayList;
import java.util.List;

public class DingDanBean {

    int dd_imageID;
    String dd_time;
    String dd_id;
    String dd_name;

    public DingDanBean(int dd_imageID, String dd_time, String dd_id, String dd_name) {
        this.dd_imageID = dd_imageID;
        this.dd_time = dd_time;
        this.dd_id = dd_id;
        this.dd_name = dd_name;
    }

    public String getDd_time() {
        return dd_time;
    }

    public void setDd_time(String dd_time) {
        this.dd_time = dd_time;
    }

    public String getDd_id() {
        return dd_id;
    }

    public void setDd_id(String dd_id) {
        this.dd_id = dd_id;
    }

    public String getDd_name() {
        return dd_name;
    }

    public void setDd_name(String dd_name) {
        this.dd_name = dd_name;
    }

    public int getDd_imageID() {
        return dd_imageID;
    }

    public void setDd_imageID(int dd_imageID) {
        this.dd_imageID = dd_imageID;
    }

    public static List<DingDanBean> getData(){
        List<DingDanBean> datas=new ArrayList<>();

        for (int i=0;i<100;i++) {
            DingDanBean data1 = new DingDanBean(R.drawable.transport_logo,"我是时间"+i, "我是订单"+i, "我是产品名字");
            datas.add(data1);
        }
        return datas;
    }
}
