package com.samfdl.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class bootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "bootReceiver", Toast.LENGTH_LONG).show();
        System.out.println("bootReceiverbootReceiverbootReceiverbootReceiver");
        Intent tIntent = new Intent(context
                , BootService.class);
        // 启动指定Service
        context.startService(tIntent);
    }
}