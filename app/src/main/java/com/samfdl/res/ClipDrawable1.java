package com.samfdl.res;

import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.samfdl.R;

import java.util.Timer;
import java.util.TimerTask;

public class ClipDrawable1 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.res_clipdrawable);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imageview = (ImageView) findViewById(R.id.image);
        // 获取图片所显示的ClipDrawable对象
        final ClipDrawable drawable = (ClipDrawable) imageview.getDrawable();
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // 如果该消息是本程序所发送的
                if (msg.what == 0x1233) {
                    // 修改ClipDrawable的level值
                    drawable.setLevel(drawable.getLevel() + 200);
                }
            }
        };
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0x1233;
                // 发送消息，通知应用修改ClipDrawable对象的level值。
                handler.sendMessage(msg);
                // 取消定时器
                if (drawable.getLevel() >= 10000) {
                    timer.cancel();
                }
            }
        }, 0, 300);
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