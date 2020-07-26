package com.example.coldchain.beans;

import com.example.coldchain.R;

import java.util.ArrayList;
import java.util.List;

public class Goods {

    public int TYPE;
    public int[] imgUrls;
    public String content = "";
    public String source = "";
    public String time = "";
    public String link = "";

    public Goods(int TYPE, int[] imgUrls, String content) {
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
    public static List<Goods> getDatas(){
        List<Goods> goodsList=new ArrayList<>();


        int datas1[]={R.drawable.b1_information1};
        int datas2[]={R.drawable.b1_information2};
        int datas3[]={R.drawable.b1_information3};
        int datas4[]={R.drawable.b1_information4};
        int datas5[]={R.drawable.b1_information5};

        Goods data1=new Goods(1,null,null);
        goodsList.add(data1);

        Goods data2 = new Goods(3, null, null);
        goodsList.add(data2);


        for (int i=0;i<20;i++) {
            Goods data3 = new Goods(2, datas1, "物流五要素 (Five Elements of Logistics)是指评价物流体系的五个主要要素.");
            goodsList.add(data3);
            Goods data4 = new Goods(2, datas2, "农产品冷链物流：农产品冷链物流泛指水果、蔬菜、肉类等物品在生产、贮藏运输、销售，到消费前的各个环节中始终处于规定的低温环境下。");
            goodsList.add(data4);
            Goods data5 = new Goods(2, datas3, "冷链物流(Cold Chain Logistics) 一般指冷藏冷冻类食品在生产、贮藏运输、销售。");
            goodsList.add(data5);
            Goods data6 = new Goods(2, datas4, "近年来，我国冷库容量进一步增长。");
            goodsList.add(data6);
            Goods data7 = new Goods(2, datas5, "速冻食品是利用现代速冻技术，在零下25摄氏度迅速冻结。");
            goodsList.add(data7);
        }

        return goodsList;
    }
}
