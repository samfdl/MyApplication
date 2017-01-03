package com.samfdl.media;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.samfdl.R;

import java.io.IOException;

public class SurfaceViewPlayVideo extends AppCompatActivity implements View.OnClickListener {
    SurfaceView surfaceView;
    ImageButton play, pause, stop;
    MediaPlayer mPlayer;
    // 记录当前视频的播放位置
    int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_surfaceviewplayvideo);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取界面中的三个按钮
        play = (ImageButton) findViewById(R.id.play);
        pause = (ImageButton) findViewById(R.id.pause);
        stop = (ImageButton) findViewById(R.id.stop);
        // 为三个按钮的单击事件绑定事件监听器
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        // 创建MediaPlayer
        mPlayer = new MediaPlayer();
        surfaceView = (SurfaceView) this.findViewById(R.id.surfaceView);
        // 设置播放时打开屏幕
        surfaceView.getHolder().setKeepScreenOn(true);
        surfaceView.getHolder().addCallback(new SurfaceListener());
    }

    @Override
    public void onClick(View source) {
        try {
            switch (source.getId()) {
                // 播放按钮被单击
                case R.id.play:
                    play();
                    break;
                // 暂停按钮被单击
                case R.id.pause:
                    if (mPlayer.isPlaying()) {
                        mPlayer.pause();
                    } else {
                        mPlayer.start();
                    }
                    break;
                // 停止按钮被单击
                case R.id.stop:
                    if (mPlayer.isPlaying()) mPlayer.stop();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void play() throws IOException {
        mPlayer.reset();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        // 设置需要播放的视频
        mPlayer.setDataSource("/storage/emulated/0/DCIM/Camera/20170103_154239.mp4");
        // 把视频画面输出到SurfaceView
        mPlayer.setDisplay(surfaceView.getHolder());  // ①
        mPlayer.prepare();
        // 获取窗口管理器
        WindowManager wManager = getWindowManager();
        DisplayMetrics metrics = new DisplayMetrics();
        // 获取屏幕大小
        wManager.getDefaultDisplay().getMetrics(metrics);
        // 设置视频保持纵横比缩放到占满整个屏幕
        surfaceView.setLayoutParams(new RelativeLayout.LayoutParams(metrics.widthPixels
                , mPlayer.getVideoHeight() * metrics.widthPixels
                / mPlayer.getVideoWidth()));
        mPlayer.start();
    }

    private class SurfaceListener implements SurfaceHolder.Callback {
        @Override
        public void surfaceChanged(SurfaceHolder holder, int format,
                                   int width, int height) {
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            if (position > 0) {
                try {
                    // 开始播放
                    play();
                    // 并直接从指定位置开始播放
                    mPlayer.seekTo(position);
                    position = 0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
        }
    }

    // 当其他Activity被打开时，暂停播放
    @Override
    protected void onPause() {
        if (mPlayer.isPlaying()) {
            // 保存当前的播放位置
            position = mPlayer.getCurrentPosition();
            mPlayer.stop();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        // 停止播放
        if (mPlayer.isPlaying()) mPlayer.stop();
        // 释放资源
        mPlayer.release();
        super.onDestroy();
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