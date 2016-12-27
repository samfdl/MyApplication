package com.samfdl.hardware;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

public class Vibrator1 extends AppCompatActivity {
    Vibrator vibrator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取系统的Vibrator服务
        vibrator = (Vibrator) getSystemService(
                Service.VIBRATOR_SERVICE);
    }

    // 重写onTouchEvent方法，当用户触碰触摸屏时触发该方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(this, "手机振动"
                , Toast.LENGTH_SHORT).show();
        // 控制手机振动2秒
        vibrator.vibrate(2000);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, HardwareList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}