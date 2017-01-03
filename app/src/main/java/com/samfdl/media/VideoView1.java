package com.samfdl.media;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import com.samfdl.R;

import java.io.File;

public class VideoView1 extends AppCompatActivity {
    VideoView videoView;
    MediaController mController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_videoview);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取界面上VideoView组件
        videoView = (VideoView) findViewById(R.id.video);
        // 创建MediaController对象
        mController = new MediaController(this);
        File video = new File("/storage/emulated/0/DCIM/Camera/20170103_154239.mp4");
        if (video.exists()) {
            videoView.setVideoPath(video.getAbsolutePath());  // ①
            // 设置videoView与mController建立关联
            videoView.setMediaController(mController);  // ②
            // 设置mController与videoView建立关联
            mController.setMediaPlayer(videoView);  // ③
            // 让VideoView获取焦点
            videoView.requestFocus();
        }
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