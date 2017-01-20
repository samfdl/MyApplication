package com.samfdl.hardware;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.widget.Toast;

public class ProximityAlertReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // 获取是否为进入指定区域
        boolean isEnter = intent.getBooleanExtra(
                LocationManager.KEY_PROXIMITY_ENTERING, false);
        if (isEnter) {
            // 显示提示信息
            Toast.makeText(context
                    , "您已经进入太阳宫大厦"
                    , Toast.LENGTH_LONG)
                    .show();
        } else {
            // 显示提示信息
            Toast.makeText(context
                    , "您已经离开太阳宫大厦"
                    , Toast.LENGTH_LONG)
                    .show();
        }
    }
}