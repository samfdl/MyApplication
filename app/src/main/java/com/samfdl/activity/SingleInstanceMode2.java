package com.samfdl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingleInstanceMode2 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
        // 创建一个TextView来显示该Activity和它所在Task ID。
        TextView tv = new TextView(this);
        tv.setText("Activity为：" + this.toString() + "\n" + "，Task ID为:" + this.getTaskId());
        layout.addView(tv);
        Button button = new Button(this);
        button.setText("启动SingleInstanceTest");
        layout.addView(button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleInstanceMode2.this, SingleInstanceMode.class);
                startActivity(intent);
            }
        });
    }
}