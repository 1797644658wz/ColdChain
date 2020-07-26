package com.example.coldchain.sell_beans;

import com.example.coldchain.R;

import java.util.ArrayList;
import java.util.List;

public class Sell_Goods {

    public int TYPE;
    public int[] imgUrls;
    public String content = "";
    public String source = "";
    public String time = "";
    public String link = "";

    public Sell_Goods(int TYPE, int[] imgUrls, String content) {
        this.TYPE = TYPE;
        this.imgUrls = imgUrls;
        this.content = content;
    }

    public int[] getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(int[] imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public static List<Sell_Goods> getDatas(){
        List<Sell_Goods> goodsList=new ArrayList<>();

        int datas1[]={R.drawable.ic_launcher_foreground};

        Sell_Goods data1=new Sell_Goods(1,null,null);
        goodsList.add(data1);

        Sell_Goods data2 = new Sell_Goods(3, null, null);
        goodsList.add(data2);

        Sell_Goods data3 = new Sell_Goods(4, null, null);
        goodsList.add(data3);

        return goodsList;
    }
}
