package com.samfdl.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastReceiver1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,
                "接收到的Intent的Action为：" + intent.getAction()
                        + "\n消息内容是：" + intent.getStringExtra("msg")
                , Toast.LENGTH_LONG).show();
    }
}