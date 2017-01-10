package com.samfdl.media;

import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.samfdl.R;

import java.io.File;

public class RecordVideo extends AppCompatActivity implements View.OnClickListener {
    // 程序中的两个按钮
    ImageButton record, stop;
    // 系统的视频文件
    File videoFile;
    MediaRecorder mRecorder;
    // 显示视频预览的SurfaceView
    SurfaceView sView;
    // 记录是否正在进行录制
    private boolean isRecording = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_recordvideo);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取程序界面中的两个按钮
        record = (ImageButton) findViewById(R.id.record);
        stop = (ImageButton) findViewById(R.id.stop);
        // 让stop按钮不可用
        stop.setEnabled(false);
        // 为两个按钮的单击事件绑定监听器
        record.setOnClickListener(this);
        stop.setOnClickListener(this);
        // 获取程序界面中的SurfaceView
        sView = (SurfaceView) this.findViewById(R.id.sView);
        // 设置分辨率
        sView.getHolder().setFixedSize(320, 280);
        // 设置该组件让屏幕不会自动关闭
        sView.getHolder().setKeepScreenOn(true);
    }

    @Override
    public void onClick(View source) {
        switch (source.getId()) {
            // 单击录制按钮
            case R.id.record:
                if (!Environment.getExternalStorageState().equals(
                        android.os.Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(RecordVideo.this
                            , "SD卡不存在，请插入SD卡！"
                            , Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    // 创建保存录制视频的视频文件
                    videoFile = new File(Environment
                            .getExternalStorageDirectory()
                            .getCanonicalFile() + "/myvideo.mp4");
                    // 创建MediaPlayer对象
                    mRecorder = new MediaRecorder();
                    mRecorder.reset();
                    // 设置从麦克风采集声音
                    mRecorder.setAudioSource(MediaRecorder
                            .AudioSource.MIC);
                    // 设置从摄像头采集图像
                    mRecorder.setVideoSource(MediaRecorder
                            .VideoSource.CAMERA);
                    // 设置视频文件的输出格式
                    // 必须在设置声音编码格式、图像编码格式之前设置
                    mRecorder.setOutputFormat(MediaRecorder
                            .OutputFormat.MPEG_4);
                    // 设置声音编码的格式
                    mRecorder.setAudioEncoder(MediaRecorder
                            .AudioEncoder.DEFAULT);
                    // 设置图像编码的格式
                    mRecorder.setVideoEncoder(MediaRecorder
                            .VideoEncoder.MPEG_4_SP);
                    mRecorder.setVideoSize(320, 280);
                    // 每秒 4帧
                    mRecorder.setVideoFrameRate(4);
                    mRecorder.setOutputFile(videoFile.getAbsolutePath());
                    // 指定使用SurfaceView来预览视频
                    mRecorder.setPreviewDisplay(sView
                            .getHolder().getSurface());  // ①
                    mRecorder.prepare();
                    // 开始录制
                    mRecorder.start();
                    System.out.println("---recording---");
                    // 让record按钮不可用
                    record.setEnabled(false);
                    // 让stop按钮可用
                    stop.setEnabled(true);
                    isRecording = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            // 单击停止按钮
            case R.id.stop:
                // 如果正在进行录制
                if (isRecording) {
                    // 停止录制
                    mRecorder.stop();
                    // 释放资源
                    mRecorder.release();
                    mRecorder = null;
                    // 让record按钮可用
                    record.setEnabled(true);
                    // 让stop按钮不可用
                    stop.setEnabled(false);
                }
                break;
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