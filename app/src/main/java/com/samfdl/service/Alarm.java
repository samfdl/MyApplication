package com.samfdl.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TimeUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.samfdl.R;

import java.util.Calendar;

public class Alarm extends AppCompatActivity {
    Button setTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_alarm);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取程序界面的按钮
        setTime = (Button) findViewById(R.id.setTime);
        // 为“设置闹铃”按钮绑定监听器。
        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                Calendar currentTime = Calendar.getInstance();
                // 创建一个TimePickerDialog实例，并把它显示出来。
                new TimePickerDialog(Alarm.this, 0, // 绑定监听器
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp,
                                                  int hourOfDay, int minute) {
                                // 指定启动AlarmActivity组件
                                Intent intent = new Intent(Alarm.this,
                                        Alarm1.class);
                                // 创建PendingIntent对象
                                PendingIntent pi = PendingIntent.getActivity(
                                        Alarm.this, 0, intent, 0);
                                Calendar c = Calendar.getInstance();
                                c.setTimeInMillis(System.currentTimeMillis());
                                // 根据用户选择时间来设置Calendar对象
                                c.set(Calendar.HOUR, hourOfDay);
                                c.set(Calendar.MINUTE, minute);
                                // 获取AlarmManager对象
                                AlarmManager aManager = (AlarmManager)
                                        getSystemService(ALARM_SERVICE);
                                // 设置AlarmManager将在Calendar对应的时间启动指定组件
                                // 有点问题
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                                    System.out.println(c.getTimeInMillis());
                                    aManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
                                } else {
                                    aManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
                                }
                                // 显示闹铃设置成功的提示信息
                                Toast.makeText(Alarm.this, "闹铃设置成功啦"
                                        , Toast.LENGTH_SHORT).show();
                            }
                        }, currentTime.get(Calendar.HOUR_OF_DAY), currentTime
                        .get(Calendar.MINUTE), false).show();
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