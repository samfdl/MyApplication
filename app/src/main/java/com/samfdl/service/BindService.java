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
import android.widget.Button;
import android.widget.Toast;

import com.samfdl.R;

public class BindService extends AppCompatActivity {
    Button bind, unbind, getServiceStatus;
    // 保持所启动的Service的IBinder对象
    BindService1.MyBinder binder;
    // 定义一个ServiceConnection对象
    private ServiceConnection conn = new ServiceConnection() {
        // 当该Activity与Service连接成功时回调该方法
        @Override
        public void onServiceConnected(ComponentName name
                , IBinder service) {
            System.out.println("--Service Connected--");
            // 获取Service的onBind方法所返回的MyBinder对象
            binder = (BindService1.MyBinder) service;  // ①
        }

        // 当该Activity与Service断开连接时回调该方法
        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("--Service Disconnected--");
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_bindservice);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取程序界面中的start、stop、getServiceStatus按钮
        bind = (Button) findViewById(R.id.bind);
        unbind = (Button) findViewById(R.id.unbind);
        getServiceStatus = (Button) findViewById(R.id.getServiceStatus);
        // 创建启动Service的Intent
        final Intent intent = new Intent(this, BindService1.class);
        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                // 绑定指定Service
                bindService(intent, conn, Service.BIND_AUTO_CREATE);
            }
        });
        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                // 解除绑定Service
                unbindService(conn);
            }
        });
        getServiceStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                // 获取、并显示Service的count值
                Toast.makeText(BindService.this,
                        "Service的count值为：" + binder.getCount(),
                        Toast.LENGTH_SHORT).show();  // ②
            }
        });
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