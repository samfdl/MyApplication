package com.samfdl.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.samfdl.R;

public class ActivityListener extends AppCompatActivity implements View.OnClickListener {
    TextView show;
    Button bn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_eventqs);
        show = (TextView) findViewById(R.id.txt);
        bn = (Button) findViewById(R.id.bn);
        // 直接使用Activity作为事件监听器
        bn.setOnClickListener(this);
    }

    // 实现事件处理方法
    @Override
    public void onClick(View v) {
        show.setText("bn按钮被单击了！");
    }
}