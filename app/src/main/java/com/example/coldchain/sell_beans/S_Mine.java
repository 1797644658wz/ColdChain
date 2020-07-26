package com.example.coldchain.sell_beans;

import com.example.coldchain.R;

import java.util.ArrayList;
import java.util.List;

public class S_Mine {

    public int TYPE;
    public int[] imgUrls;
    public String content = "";
    public String source = "";
    public String time = "";
    public String link = "";

    public S_Mine(int TYPE, int[] imgUrls, String content, String source) {
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

    public static List<S_Mine> getdata(){
        List<S_Mine> datas=new ArrayList<>();

        int datas1[]={R.drawable.ic_launcher};
        int datas2[]={R.drawable.ic_payment_24dp};
        int datas3[]={R.drawable.ic_location_on_black_24dp};
        int datas4[]={R.drawable.ic_store_black_24dp};
        int datas5[]={R.drawable.ic_transport_black_24dp};
        int datas6[]={R.drawable.ic_mine_24dp};

        S_Mine data1 = new S_Mine(1, datas1, "账号名：黔运","01");
        datas.add(data1);

        S_Mine data2 = new S_Mine(4, datas2, "钱包", null);
        datas.add(data2);

        S_Mine data3 = new S_Mine(4, datas4, "账单查询",null);
        datas.add(data3);

        S_Mine data4 = new S_Mine(4, datas6, "退出登录",null);
        datas.add(data4);

        return datas;
    }
}
