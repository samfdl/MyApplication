package com.samfdl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.samfdl.R;

public class StartActivity2 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startactivity2);
        // 获取应用程序中的previous按钮
        Button previous = (Button) findViewById(R.id.previous);
        // 获取应用程序中的close按钮
        Button close = (Button) findViewById(R.id.close);
        // 为previous按钮绑定事件监听器
        previous.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View source) {
                // 获取启动当前Activity的上一个Intent
                Intent intent = new Intent(StartActivity2.this,
                        StartActivity.class);
                // 启动intent对应的Activity
                startActivity(intent);
            }
        });
        // 为close按钮绑定事件监听器
        close.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View source) {
                // 获取启动当前Activity的上一个Intent
                Intent intent = new Intent(StartActivity2.this,
                        StartActivity.class);
                // 启动intent对应的Activity
                startActivity(intent);
                // 结束当前Activity
                finish();
            }
        });
    }
}