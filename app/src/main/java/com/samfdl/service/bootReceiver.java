package com.samfdl.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class bootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent tIntent = new Intent(context
                , BootService.class);
        // 启动指定Service
        context.startService(tIntent);
    }
}