package com.example.coldchain.beans;

import com.example.coldchain.R;

import java.util.ArrayList;
import java.util.List;

public class B1_goods_beans {

    int imageId;
    String context;

    public B1_goods_beans(int imageId, String context) {
        this.imageId = imageId;
        this.context = context;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public static List<B1_goods_beans> getDatas(){
        List<B1_goods_beans> b1_goods_beansList=new ArrayList<>();

        B1_goods_beans data1=new B1_goods_beans(R.drawable.b1_information1,"内容");
        B1_goods_beans data2=new B1_goods_beans(R.drawable.b1_information2,"内容");
        B1_goods_beans data3=new B1_goods_beans(R.drawable.b1_information3,"内容");
        B1_goods_beans data4=new B1_goods_beans(R.drawable.b1_information4,"内容");
        B1_goods_beans data5=new B1_goods_beans(R.drawable.b1_information5,"内容");

        return b1_goods_beansList;
    }
}
