package com.example.coldchain.b_mine_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.coldchain.Local;
import com.example.coldchain.R;
import com.example.coldchain.adapters.Charing_Adapter;
import com.example.coldchain.beans.B_Mine_Batter;

import java.util.ArrayList;
import java.util.List;

public class Charging extends AppCompatActivity {

    LocationClient mlocationClient;
    MapView charing_map;
    RecyclerView charing_recyclerView;
    List<B_Mine_Batter> b_mine_batterList = new ArrayList<>();
    BaiduMap baiduMap;
    private boolean isFirstLocal = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mlocationClient=new LocationClient(getApplicationContext());
        mlocationClient.registerLocationListener(new MyLocationListener());
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_charging);

        initview();

        baiduMap=charing_map.getMap();

        baiduMap.setMyLocationEnabled(true);

        b_mine_batterList=B_Mine_Batter.getDatas();

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        charing_recyclerView.setLayoutManager(layoutManager);

        Charing_Adapter adapter=new Charing_Adapter(b_mine_batterList);
        charing_recyclerView.setAdapter(adapter);

        List<String> permissionList=new ArrayList<>();
        if (ContextCompat.checkSelfPermission(Charging.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(Charging.this,Manifest.permission.READ_PHONE_STATE)
                !=PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(Charging.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                !=PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()){
            String[] permissions=permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(Charging.this,permissions,1);
        }else {
            requestLlocation();
        }

    }

    private void requestLlocation() {
        initLocation();
        mlocationClient.start();
    }

    private void initLocation() {

        LocationClientOption option = new LocationClientOption();
        option.setScanSpan(5000);
        option.setIsNeedAddress(true);
        mlocationClient.setLocOption(option);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if (grantResults.length>0){
                    for (int result:grantResults){
                        if (result!=PackageManager.PERMISSION_DENIED){
                            Toast.makeText(this,"必须同意权限才能使用本程序！",Toast.LENGTH_LONG).show();
                            finish();
                            return;
                        }
                    }
                    requestLlocation();
                }else {
                    Toast.makeText(this,"发生未知错误！",Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
            default:
        }
    }

    public void navigateTo(BDLocation bdLocation){
        if (isFirstLocal){
            LatLng ll=new LatLng(bdLocation.getLatitude(),bdLocation.getLongitude());
            MapStatusUpdate update= MapStatusUpdateFactory.newLatLng(ll);
            baiduMap.animateMapStatus(update);
            update=MapStatusUpdateFactory.zoomTo(16f);
            baiduMap.animateMapStatus(update);
            isFirstLocal=false;
        }
        MyLocationData.Builder locationBuilder =new MyLocationData.Builder();
        locationBuilder.latitude(bdLocation.getLatitude());
        locationBuilder.longitude(bdLocation.getLongitude());
        MyLocationData locationData = locationBuilder.build();
        baiduMap.setMyLocationData(locationData);
    }
    public class MyLocationListener implements BDLocationListener{

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            if (bdLocation.getLocType()==BDLocation.TypeGpsLocation||bdLocation.getLocType()==BDLocation.TypeNetWorkLocation){
                navigateTo(bdLocation);
            }
        }
    }
    private void initview() {
        charing_map=findViewById(R.id.charging_map);
        charing_recyclerView=findViewById(R.id.charging_recyclerview);
    }

    @Override
    protected void onResume() {
        super.onResume();
        charing_map.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        charing_map.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        charing_map.onDestroy();
        baiduMap.setMyLocationEnabled(false);
    }


}
