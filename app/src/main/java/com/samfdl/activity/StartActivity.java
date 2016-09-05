package com.samfdl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.samfdl.R;

public class StartActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startactivity);
        // 获取应用程序中的bn按钮
        Button bn = (Button) findViewById(R.id.bn);
        // 为bn按钮绑定事件监听器
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                // 创建需要启动的Activity对应的Intent
                Intent intent = new Intent(StartActivity.this,
                        StartActivity2.class);
                // 启动intent对应的Activity
                startActivity(intent);
            }
        });
    }
}