package com.samfdl.web;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.samfdl.R;

import java.util.Timer;
import java.util.TimerTask;

public class MultiThreadDown extends AppCompatActivity {
    EditText url;
    EditText target;
    Button downBn;
    ProgressBar bar;
    MultiThreadDownUtil downUtil;
    private int mDownStatus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_multithreaddown);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取程序界面中的三个界面控件
        url = (EditText) findViewById(R.id.url);
        target = (EditText) findViewById(R.id.target);
        downBn = (Button) findViewById(R.id.down);
        bar = (ProgressBar) findViewById(R.id.bar);
        // 创建一个Handler对象
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x123) {
                    bar.setProgress(mDownStatus);
                }
            }
        };
        downBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 初始化DownUtil对象（最后一个参数指定线程数）
                downUtil = new MultiThreadDownUtil(url.getText().toString(),
                        target.getText().toString(), 6);
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            // 开始下载
                            downUtil.download();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // 定义每秒调度获取一次系统的完成进度
                        final Timer timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                // 获取下载任务的完成比例
                                double completeRate = downUtil
                                        .getCompleteRate();
                                mDownStatus = (int) (completeRate * 100);
                                // 发送消息通知界面更新进度条
                                handler.sendEmptyMessage(0x123);
                                // 下载完全后取消任务调度
                                if (mDownStatus >= 100) {
                                    timer.cancel();
                                }
                            }
                        }, 0, 100);
                    }
                }.start();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, WebList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}