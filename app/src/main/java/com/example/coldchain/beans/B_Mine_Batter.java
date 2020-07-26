package com.example.coldchain.beans;

import java.util.ArrayList;
import java.util.List;

public class B_Mine_Batter {

    String charing_name;
    String charing_distance;
    String charing_other;

    public B_Mine_Batter(String charing_name, String charing_distance, String charing_other) {
        this.charing_name = charing_name;
        this.charing_distance = charing_distance;
        this.charing_other = charing_other;
    }

    public String getCharing_name() {
        return charing_name;
    }

    public void setCharing_name(String charing_name) {
        this.charing_name = charing_name;
    }

    public String getCharing_distance() {
        return charing_distance;
    }

    public void setCharing_distance(String charing_distance) {
        this.charing_distance = charing_distance;
    }

    public String getCharing_other() {
        return charing_other;
    }

    public void setCharing_other(String charing_other) {
        this.charing_other = charing_other;
    }

    public static List<B_Mine_Batter> getDatas(){
        List<B_Mine_Batter> datas=new ArrayList<>();

        for (int i=0;i<20;i++){
            B_Mine_Batter data1=new B_Mine_Batter("优车酷汽车充电站","853米 | 党武镇思孟路","汽车服务站 | 充电站");
            datas.add(data1);
            B_Mine_Batter data2=new B_Mine_Batter("汽车充电站","2202米 | ","汽车服务站 | 充电站");
            datas.add(data2);
            B_Mine_Batter data3=new B_Mine_Batter("花溪服务区国家电网电动汽车充电站","3622米 | ","汽车服务站 | 充电站");
            datas.add(data3);
            B_Mine_Batter data4=new B_Mine_Batter("保利充电站","4079米 | 保利溪湖三期","汽车服务站 | 充电站");
            datas.add(data4);
        }
        return datas;
    }
}
