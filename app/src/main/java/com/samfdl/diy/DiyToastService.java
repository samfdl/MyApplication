package com.samfdl.diy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.DisplayMetrics;

public class DiyToastService extends Service {
    // 必须实现的方法
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    // Service被创建时回调该方法
    @Override
    public void onCreate() {
        super.onCreate();
        DisplayMetrics metric = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metric);
//        int width = metric.widthPixels;     // 屏幕宽度（像素）
//        int height = metric.heightPixels / 2;   // 屏幕高度（像素）
        int width = 700;     // 屏幕宽度（像素）
        int height = 500;   // 屏幕高度（像素）

        DiyToast1 diyToast = new DiyToast1(DiyToastService.this);
        diyToast.width = 900;     // 屏幕宽度（像素）
        diyToast.height = 900;   // 屏幕高度（像素）
        diyToast.show();
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