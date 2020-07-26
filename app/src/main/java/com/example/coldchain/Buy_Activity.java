package com.example.coldchain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coldchain.b_mine_activity.Send_mail;
import com.example.coldchain.fragments.BuyFragmentMain1;
import com.example.coldchain.fragments.BuyFragmentMain2;
import com.example.coldchain.fragments.BuyFragmentMain3;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Buy_Activity extends AppCompatActivity {

    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;
    FragmentManager fragmentManager;
    TextView buy_title;

    //声明fragments
    BuyFragmentMain1 buyFragmentMain1;
    BuyFragmentMain2 buyFragmentMain2;
    BuyFragmentMain3 buyFragmentMain3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_);

        initview();

        /*//占用手机顶部的bar
        StatusBarUtil.fullScreen(this);*/

        //替换actionbar
        final Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        }

        //设置默认选中左侧导航栏第一个
        navigationView.setCheckedItem(R.id.left_nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.left_nav_call:
                        Intent call = new Intent(Intent.ACTION_DIAL);
                        call.setData(Uri.parse("tel:18302630842"));
                        startActivity(call);
                        Toast.makeText(Buy_Activity.this, "给蒋涛打电话", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.left_nav_login_out:
                        Intent login_out = new Intent(Buy_Activity.this, MainActivity.class);
                        startActivity(login_out);
                        Toast.makeText(Buy_Activity.this, "退出登录成功", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.left_nav_mail:
                        Intent mail = new Intent(Buy_Activity.this, Send_mail.class);
                        startActivity(mail);
                        Toast.makeText(Buy_Activity.this, "进入消息界面", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.left_nav_setting:
                        Intent music = new Intent(Settings.ACTION_SETTINGS);
                        startActivity(music);
                        Toast.makeText(Buy_Activity.this, "进入设置界面", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        buyFragmentMain1 = new BuyFragmentMain1();
        transaction.add(R.id.frame_layout, buyFragmentMain1).commit();
        buy_title.setText("首页");

        //设置底部标签栏点击事件
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Hidefragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.first:
                        transaction.show(buyFragmentMain1).commit();
                        /*viewPager.setCurrentItem(0);*/
                        buy_title.setText("首页");
                        return true;
                    case R.id.second:
                        /*viewPager.setCurrentItem(1);*/
                        if (buyFragmentMain2 == null) {
                            buyFragmentMain2 = new BuyFragmentMain2();
                            transaction.add(R.id.frame_layout, buyFragmentMain2).commit();
                            buy_title.setText("订单");
                        } else {
                            transaction.show(buyFragmentMain2).commit();
                            buy_title.setText("订单");
                        }
                        return true;
                    case R.id.third:
                        /*viewPager.setCurrentItem(2);*/
                        if (buyFragmentMain3 == null) {
                            buyFragmentMain3 = new BuyFragmentMain3();
                            transaction.add(R.id.frame_layout, buyFragmentMain3).commit();
                            buy_title.setText("我的");
                        } else {
                            transaction.show(buyFragmentMain3).commit();
                            buy_title.setText("我的");
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
        if (buyFragmentMain1 != null && buyFragmentMain1.isAdded()) {
            transaction.hide(buyFragmentMain1);
        }
        if (buyFragmentMain2 != null && buyFragmentMain2.isAdded()) {
            transaction.hide(buyFragmentMain2);
        }
        if (buyFragmentMain3 != null && buyFragmentMain3.isAdded()) {
            transaction.hide(buyFragmentMain3);
        }
        //提交
        transaction.commit();
    }

    //设置toolbar上图标点击事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }


    //在toolbar上添加menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_head, menu);
        return true;
    }

    private void initview() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        buy_title = findViewById(R.id.buy_title);
    }
}
