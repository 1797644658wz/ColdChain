package com.example.coldchain.beans;

import com.example.coldchain.R;

import java.util.ArrayList;
import java.util.List;

public class B_Mine {

    public int TYPE;
    public int[] imgUrls;
    public String content = "";
    public String source = "";
    public String time = "";
    public String link = "";

    public B_Mine(int TYPE, int[] imgUrls, String content, String source) {
        this.TYPE = TYPE;
        this.imgUrls = imgUrls;
        this.content = content;
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public static List<B_Mine> getdata(){
        List<B_Mine> datas=new ArrayList<>();

        int datas1[]={R.drawable.ic_launcher};
        int datas2[]={R.drawable.ic_payment_24dp};
        int datas3[]={R.drawable.ic_location_on_black_24dp};
        int datas4[]={R.drawable.ic_battery_control_24dp};
        int datas5[]={R.drawable.ic_transport_black_24dp};
        int datas6[]={R.drawable.ic_mine_24dp};


        B_Mine data1 = new B_Mine(1, datas1, "账号名：黔运","01");
        datas.add(data1);

        B_Mine data2 = new B_Mine(4, datas2, "支付", null);
        datas.add(data2);

        B_Mine data3 = new B_Mine(4, datas3, "定位",null);
        datas.add(data3);

        B_Mine data4 = new B_Mine(4, datas4, "附近充电桩",null);
        datas.add(data4);

        B_Mine data5 = new B_Mine(4, datas5, "车辆状态",null);
        datas.add(data5);

        B_Mine data6 = new B_Mine(4, datas6, "退出登录",null);
        datas.add(data6);

        return datas;
    }
}
