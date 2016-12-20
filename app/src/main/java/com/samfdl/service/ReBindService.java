package com.samfdl.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.samfdl.R;

public class ReBindService extends AppCompatActivity {
    // 保持所启动的Service的IBinder对象
    ReBindService1.MyBinder binder;
    // 定义启动Service的Intent
    Intent intent;
    // 定义一个ServiceConnection对象
    private ServiceConnection conn = new ServiceConnection() {
        // 当该Activity与Service连接成功时回调该方法
        @Override
        public void onServiceConnected(ComponentName name
                , IBinder service) {
            System.out.println("--Service Connected--");
            // 获取Service的onBind方法所返回的MyBinder对象
            binder = (ReBindService1.MyBinder) service; // ①
        }

        // 当该Activity与Service断开连接时回调该方法
        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("--Service Disconnected--");
        }
    };

    public void start(View source) {
        // 启动intent对应的Service
        startService(intent);
    }

    public void bind(View source) {
        // 启动intent对应的Service
        // 绑定指定Serivce
        bindService(intent, conn, Service.BIND_AUTO_CREATE);
    }

    public void unBind(View source) {
        // 解除绑定Serivce
        unbindService(conn);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_rebindservice);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 创建启动Service的Intent
        intent = new Intent(this, ReBindService1.class);
        System.out.println("--onCreate --");
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
}