package com.samfdl.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.samfdl.R;

public class AlarmChangeWallpaper extends AppCompatActivity {
    Button start, stop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_firstservice);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        // 指定启动ChangeService组件
        Intent intent = new Intent(this, AlarmChangeWallpaperService.class);
        // 创建PendingIntent对象
        final PendingIntent pi = PendingIntent.getService(this, 0, intent, 0);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // 获取AlarmManager对象
                AlarmManager aManager = (AlarmManager) getSystemService(
                        Service.ALARM_SERVICE);
                // 设置每隔5秒执行pi代表的组件一次
                aManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP
                        , 0, 5000, pi);
                start.setEnabled(false);
                stop.setEnabled(true);
                Toast.makeText(AlarmChangeWallpaper.this
                        , "壁纸定时更换启动成功啦",
                        Toast.LENGTH_SHORT).show();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                start.setEnabled(true);
                stop.setEnabled(false);
                // 获取AlarmManager对象
                AlarmManager aManager = (AlarmManager) getSystemService(
                        Service.ALARM_SERVICE);
                // 取消对pi的调度
                aManager.cancel(pi);
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