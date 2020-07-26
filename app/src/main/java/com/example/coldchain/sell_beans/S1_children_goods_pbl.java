package com.example.coldchain.sell_beans;

import com.example.coldchain.R;

import java.util.ArrayList;
import java.util.List;

public class S1_children_goods_pbl {

    private int ImageId;

    private String name;

    public S1_children_goods_pbl(int imageId, String name) {
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

    public static List<S1_children_goods_pbl> getDatas(){
        List<S1_children_goods_pbl> datas=new ArrayList<>();

        for (int i=0;i<10;i++) {
            S1_children_goods_pbl data1 = new S1_children_goods_pbl(R.drawable.s1_good1, "贵州特产盘州正宗天然火腿精装");
            datas.add(data1);
            S1_children_goods_pbl data2 = new S1_children_goods_pbl(R.drawable.s1_good2, "贵州土特产精选二荆条辣椒");
            datas.add(data2);
            S1_children_goods_pbl data3 = new S1_children_goods_pbl(R.drawable.s1_good3, "贵州特产农家新鲜紫心红薯番薯");
            datas.add(data3);
            S1_children_goods_pbl data4 = new S1_children_goods_pbl(R.drawable.s1_good4, "贵州特产绿色蔬菜现摘新鲜大白菜口感好");
            datas.add(data4);
            S1_children_goods_pbl data5 = new S1_children_goods_pbl(R.drawable.s1_good5, "贵州野菜蕨菜新鲜春天野蔬菜绿色农村水蕨菜现摘新鲜");
            datas.add(data5);
            S1_children_goods_pbl data6 = new S1_children_goods_pbl(R.drawable.s1_good6, "贵州绿色水果香脆李");
            datas.add(data6);
            S1_children_goods_pbl data7 = new S1_children_goods_pbl(R.drawable.s1_good7, "贵州绿色新鲜猪毛菜 扎蓬棵 蓬蓬菜蓬子菜猪毛缨 ");
            datas.add(data7);
        }

        return datas;
    }
}
