package com.samfdl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samfdl.R;

public class HiddenIntent extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        this.setContentView(layout);
        // 创建一个TextView来显示该Activity和它所在Task ID
        TextView tv = new TextView(this);
        tv.setText("Activity为：" + this.toString() + "\n" + "，Task ID为:" + this.getTaskId());
        Button button = new Button(this);
        button.setText("启动SingleInstanceMode2");
        // 添加TextView和Button
        layout.addView(tv);
        layout.addView(button);
        // 为button添加事件监听器，使用隐式Intent启动目标Activity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 使用隐式Intent启动SingleInstanceMode2
                Intent intent = new Intent();
                intent.setAction("org.crazyit.intent.action.CRAZYIT_ACTION");
                startActivity(intent);
            }
        });
    }
}