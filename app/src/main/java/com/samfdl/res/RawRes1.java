package com.samfdl.res;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.samfdl.R;

import java.io.IOException;

public class RawRes1 extends AppCompatActivity {
    MediaPlayer mediaPlayer1 = null;
    MediaPlayer mediaPlayer2 = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.res_rawres);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 直接根据声音文件的ID来创建MediaPlayer
        mediaPlayer1 = MediaPlayer.create(this, R.raw.res_rawres_bomb);
        // 获取该应用的AssetManager
        AssetManager am = getAssets();
        try {
            // 获取指定文件对应的AssetFileDescriptor
            AssetFileDescriptor afd = am.openFd("shot.mp3");
            mediaPlayer2 = new MediaPlayer();
            // 使用MediaPlayer加载指定的声音文件
            mediaPlayer2.setDataSource(afd.getFileDescriptor());
            mediaPlayer2.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取第一个按钮，并为它绑定事件监听器
        Button playRaw = (Button) findViewById(R.id.playRaw);
        playRaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // 播放声音
                mediaPlayer1.start();
            }
        });
        // 获取第二个按钮，并为它绑定事件监听器
        Button playAsset = (Button) findViewById(R.id.playAsset);
        playAsset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // 播放声音
                mediaPlayer2.start();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, ResList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}