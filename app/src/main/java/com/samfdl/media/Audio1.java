package com.samfdl.media;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.samfdl.R;

public class Audio1 extends AppCompatActivity {
    Button play, up, down;
    ToggleButton mute;
    AudioManager aManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_audio);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取系统的音频服务
        aManager = (AudioManager) getSystemService(
                Service.AUDIO_SERVICE);
        // 获取界面中三个按钮和一个ToggleButton控件
        play = (Button) findViewById(R.id.play);
        up = (Button) findViewById(R.id.up);
        down = (Button) findViewById(R.id.down);
        mute = (ToggleButton) findViewById(R.id.mute);
        // 为play按钮的单击事件绑定监听器
        play.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View source) {
                // 初始化MediaPlayer对象，准备播放音乐
                MediaPlayer mPlayer = MediaPlayer.create(
                        Audio1.this, R.raw.media_audio_earth);
                // 设置循环播放
                mPlayer.setLooping(true);
                // 开始播放
                mPlayer.start();
            }
        });
        up.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View source) {
                // 指定调节音乐的音频，增大音量，而且显示音量图形示意
                aManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
            }
        });
        down.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View source) {
                // 指定调节音乐的音频，降低音量，而且显示音量图形示意
                aManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
            }
        });
        mute.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton source,
                                         boolean isChecked) {
                // 指定调节音乐的音频，根据isChecked确定是否需要静音
                aManager.setStreamMute(AudioManager.STREAM_MUSIC,
                        isChecked);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, MediaList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}