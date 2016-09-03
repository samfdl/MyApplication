package com.samfdl.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.samfdl.R;

public class EventQs extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_eventqs);
        // 获取应用程序中的bn按钮
        Button bn = (Button) findViewById(R.id.bn);
        // 为按钮绑定事件监听器
        bn.setOnClickListener(new MyClickListener()); // ①
    }

    // 定义一个单击事件的监听器
    class MyClickListener implements View.OnClickListener {
        // 实现监听器类必须实现的方法，该方法将会作为事件处理器
        @Override
        public void onClick(View v) {
            TextView txt = (TextView) findViewById(R.id.txt);
            txt.setText("bn按钮被单击了！");
        }
    }
}