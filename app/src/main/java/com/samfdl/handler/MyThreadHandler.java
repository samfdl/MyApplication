package com.samfdl.handler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.samfdl.R;
import com.samfdl.graphics.GraphicsList;

public class MyThreadHandler extends AppCompatActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            System.out.println("UI---->:" + Thread.currentThread());
        }
    };

    class MyThread extends Thread {
        public Handler handler;

        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    System.out.println("currentThread:" + Thread.currentThread());
                    super.handleMessage(msg);
                }
            };
            Looper.loop();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_post);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MyThread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handler.sendEmptyMessage(1);
        thread.handler.sendEmptyMessage(1);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, GraphicsList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}