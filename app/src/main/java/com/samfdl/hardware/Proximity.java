package com.samfdl.hardware;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Proximity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 定位服务的常量
        String locService = Context.LOCATION_SERVICE;
        // 定位服务管理器实例
        LocationManager locationManager;
        // 通过getSystemService方法获得LocationManager实例
        locationManager = (LocationManager) getSystemService(locService);
        // 定义"太阳宫大厦"的经度、纬度
        double longitude = 116.4475035667;
        double latitude = 39.9727954429;
        // 定义半径（5公里）
        float radius = 5000;
        // 定义Intent
        Intent intent = new Intent(this, ProximityAlertReciever.class);
        // 将Intent包装成PendingIntent
        PendingIntent pi = PendingIntent.getBroadcast(this, -1, intent, 0);
        // 添加临近警告
        locationManager.addProximityAlert(latitude, longitude, radius, -1, pi);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, HardwareList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}