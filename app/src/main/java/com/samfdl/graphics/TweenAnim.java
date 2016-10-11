package com.samfdl.graphics;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.samfdl.R;

import java.util.Timer;
import java.util.TimerTask;

public class TweenAnim extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphics_tweenanim);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ImageView flower = (ImageView) findViewById(R.id.flower);
        // 加载第一份动画资源
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.graphics_tweenanim_anim);
        // 设置动画结束后保留结束状态
        anim.setFillAfter(true);
        // 加载第二份动画资源
        final Animation reverse = AnimationUtils.loadAnimation(this,
                R.anim.graphics_tweenanim_reverse);
        // 设置动画结束后保留结束状态
        reverse.setFillAfter(true);
        Button bn = (Button) findViewById(R.id.bn);
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x123) {
                    flower.startAnimation(reverse);
                }
            }
        };
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                flower.startAnimation(anim);
                // 设置3.5秒后启动第二个动画
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0x123);
                    }
                }, 3500);
            }
        });
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