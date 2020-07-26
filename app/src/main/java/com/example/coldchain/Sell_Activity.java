package com.example.coldchain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.coldchain.fragments.BuyFragmentMain1;
import com.example.coldchain.fragments.BuyFragmentMain2;
import com.example.coldchain.fragments.BuyFragmentMain3;
import com.example.coldchain.fragments.SellFragmentMain1;
import com.example.coldchain.fragments.SellFragmentMain2;
import com.example.coldchain.fragments.SellFragmentMain3;
import com.example.coldchain.util.StatusBarUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Sell_Activity extends AppCompatActivity {

    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    FragmentManager fragmentManager;
    TextView sell_title;

    SellFragmentMain1 sellFragmentMain1;
    SellFragmentMain2 sellFragmentMain2;
    SellFragmentMain3 sellFragmentMain3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_);

        initview();
        /*//占用手机顶部的bar
        StatusBarUtil.fullScreen(this);*/

        //替换actionbar
        final Toolbar toolbar=findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        }

        //设置默认选中左侧导航栏第一个
        navigationView.setCheckedItem(R.id.left_nav_call);

        fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        sellFragmentMain1=new SellFragmentMain1();
        transaction.add(R.id.frame_layout,sellFragmentMain1).commit();
        sell_title.setText("首页");

        //设置底部标签栏点击事件
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Hidefragment();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                switch (item.getItemId()){
                    case R.id.first:
                        transaction.show(sellFragmentMain1).commit();
                        sell_title.setText("首页");
                        /*viewPager.setCurrentItem(0);*/
                        return true;
                    case R.id.second:
                        /*viewPager.setCurrentItem(1);*/
                        if (sellFragmentMain2==null){
                            sellFragmentMain2=new SellFragmentMain2();
                            transaction.add(R.id.frame_layout,sellFragmentMain2).commit();
                            sell_title.setText("上传商品");
                        }else {
                            transaction.show(sellFragmentMain2).commit();
                            sell_title.setText("上传商品");
                        }
                        return true;
                    case R.id.third:
                        /*viewPager.setCurrentItem(2);*/
                        if (sellFragmentMain3==null){
                            sellFragmentMain3=new SellFragmentMain3();
                            transaction.add(R.id.frame_layout,sellFragmentMain3).commit();
                            sell_title.setText("我的");
                        }else {
                            transaction.show(sellFragmentMain3).commit();
                            sell_title.setText("我的");
                        }
                        return true;
                }
                return false;
            }
        });

    }

    //隐藏fragment
    private void Hidefragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (sellFragmentMain1 != null && sellFragmentMain1.isAdded()) {
            transaction.hide(sellFragmentMain1);
        }
        if (sellFragmentMain2 != null && sellFragmentMain2.isAdded()) {
            transaction.hide(sellFragmentMain2);
        }
        if (sellFragmentMain3 != null && sellFragmentMain3.isAdded()) {
            transaction.hide(sellFragmentMain3);
        }
        //提交
        transaction.commit();
    }

    //设置toolbar上图标点击事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
    //在toolbar上添加menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_head,menu);
        return true;
    }

    private void initview() {
        bottomNavigationView=findViewById(R.id.bottom_navigation_view);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        sell_title=findViewById(R.id.sell_title);
    }
}
