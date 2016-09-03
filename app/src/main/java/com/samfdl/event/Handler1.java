package com.samfdl.event;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.samfdl.R;

import java.util.Timer;
import java.util.TimerTask;

public class Handler1 extends AppCompatActivity {
    // 定义周期性显示的图片的ID
    int[] imageIds = new int[]{R.drawable.ui_viewanimator_viewflipper_java, R.drawable.ui_viewanimator_viewflipper_javaee, R.drawable.event_handler_ajax, R.drawable.ui_viewanimator_viewflipper_android,
            R.drawable.ui_toast_notification_swift};
    int currentImageId = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_handler);
        final ImageView show = (ImageView) findViewById(R.id.show);
        final Handler myHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // 如果该消息是本程序所发送的
                if (msg.what == 0x1233) {
                    // 动态地修改所显示的图片
                    if (show != null) {
                        show.setImageResource(imageIds[currentImageId++ % imageIds.length]);
                    }
                }
            }
        };
        // 定义一个计时器，让该计时器周期性地执行指定任务
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // 发送空消息
                myHandler.sendEmptyMessage(0x1233);
            }
        }, 0, 1200);
    }
}