package com.samfdl.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Toast;

public class FirstService1 extends Service {
    // 必须实现的方法
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    // Service被创建时回调该方法
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service is Created");
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            public void run() {
                System.out.println("存Service is runingdddd");
                Toast.makeText(getApplicationContext(), "存Service is onCreate!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Service被启动时回调该方法
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("Service is Started");
        return START_STICKY;
    }

    // Service被关闭之前回调
    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service is Destroyed");
    }
}