package com.samfdl.service;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.samfdl.R;

public class Alarm1 extends AppCompatActivity {
    MediaPlayer alarmMusic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphics_canvas);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 加载指定音乐，并为之创建MediaPlayer对象
        alarmMusic = MediaPlayer.create(this, R.raw.service_alarm);
        alarmMusic.setLooping(true);
        // 播放音乐
        alarmMusic.start();
        // 创建一个对话框
        new AlertDialog.Builder(this).setTitle("闹钟")
                .setMessage("闹钟响了,Go！Go！Go！")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 停止音乐
                        alarmMusic.stop();
                        // 结束该Activity
                        Alarm1.this.finish();
                    }
                }).show();
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