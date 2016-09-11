package com.samfdl.ui.layout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.samfdl.R;

import java.util.Timer;
import java.util.TimerTask;

public class FrameLayout1 extends AppCompatActivity {
    private int currentColor = 0;
    // 定义一个颜色数组
    final int[] colors = new int[]{
            R.color.ui_layout_framelayout_color1,
            R.color.ui_layout_framelayout_color2,
            R.color.ui_layout_framelayout_color3,
            R.color.ui_layout_framelayout_color4,
            R.color.ui_layout_framelayout_color5,
            R.color.ui_layout_framelayout_color6
    };
    final int[] names = new int[]{
            R.id.view01,
            R.id.view02,
            R.id.view03,
            R.id.view04,
            R.id.view05,
            R.id.view06
    };
    TextView[] views = new TextView[names.length];
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // 表明消息来自本程序所发送
            if (msg.what == 0x123) {
                for (int i = 0; i < names.length; i++) {
                    views[i].setBackgroundResource(colors[(i
                            + currentColor) % names.length]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_layout_framelayout);
        for (int i = 0; i < names.length; i++) {
            views[i] = (TextView) findViewById(names[i]);
        }
        // 定义一个线程周期性地改变currentColor变量值
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // 发送一条空消息通知系统改变6个TextView组件的背景色
                handler.sendEmptyMessage(0x123);
            }
        }, 0, 200);
    }
}