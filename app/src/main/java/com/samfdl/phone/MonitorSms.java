package com.samfdl.phone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MonitorSms extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 为content://sms的数据改变注册监听器
        getContentResolver().registerContentObserver(
                Uri.parse("content://sms"), true,
                new SmsObserver(new Handler()));
        System.out.println("dddwww发送短信：");
    }

    // 提供自定义的ContentObserver监听器类
    private final class SmsObserver extends ContentObserver {
        public SmsObserver(Handler handler) {
            super(handler);
        }

        public void onChange(boolean selfChange) {
            // 查询发送箱中的短信（处于正在发送状态的短信放在发送箱）
            if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(MonitorSms.this, Manifest.permission.READ_SMS)) {
                System.out.println("dddfeewffd发送短信：");
                sendSMS();
            } else {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(MonitorSms.this,
                        Manifest.permission.READ_SMS)) {
                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
//                    Log.i(DEBUG_TAG, "we should explain why we need this permission!");
                    System.out.println("ddd发送短信：");
                } else {
                    System.out.println("ff11发送短信：");
                    // No explanation needed, we can request the permission.
//                    Log.i(DEBUG_TAG, "==request the permission==");
                    // 动态权限申请
                    ActivityCompat.requestPermissions(MonitorSms.this, new String[]{Manifest.permission.READ_SMS}, 1);
                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                    sendSMS();
                }
            }
        }
    }

    private void sendSMS() {
        // 不太对
        //has permission, do operation directly
        Cursor cursor = getContentResolver().query(
                Uri.parse("content://sms/sent")
                , null, null, null, null);
        // 遍历查询得到的结果集，即可获取用户正在发送的短信
        while (cursor.moveToNext()) {
            StringBuilder sb = new StringBuilder();
            // 获取短信的发送地址
            sb.append("address=").append(cursor
                    .getString(cursor.getColumnIndex("address")));
            // 获取短信的标题
            sb.append(";subject=").append(cursor
                    .getString(cursor.getColumnIndex("subject")));
            // 获取短信的内容
            sb.append(";body=").append(cursor
                    .getString(cursor.getColumnIndex("body")));
            // 获取短信的发送时间
            sb.append(";time=").append(cursor
                    .getLong(cursor.getColumnIndex("date")));
            System.out.println("发送短信：" + sb.toString());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, PhoneList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}