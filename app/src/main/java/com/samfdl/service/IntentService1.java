package com.samfdl.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.samfdl.R;

public class IntentService1 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_intentservice);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, ServiceList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }

    public void startService(View source) {
        // 创建需要启动的Service的Intent
        Intent intent = new Intent(this, IntentServiceNo.class);
        // 启动Service
        startService(intent);
    }

    public void startIntentService(View source) {
        // 创建需要启动的IntentService的Intent
        Intent intent = new Intent(this, IntentService2.class);
        // 启动IntentService
        startService(intent);
    }
}