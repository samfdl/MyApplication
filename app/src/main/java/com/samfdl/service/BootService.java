package com.samfdl.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class BootService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        // 定义1秒执行一行输出 暂时屏蔽输出
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("-----"
//                        + new Date() + "-----");
//            }
//        }, 0, 1000);
    }
}