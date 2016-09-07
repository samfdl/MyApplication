package com.samfdl.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.samfdl.R;

public class FragmentLifeCycle extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_ball);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}