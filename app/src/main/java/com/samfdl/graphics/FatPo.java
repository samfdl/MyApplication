package com.samfdl.graphics;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.samfdl.R;

// 有点问题
public class FatPo extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphics_fatpo);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取两个按钮
        Button play = (Button) findViewById(R.id.play);
        Button stop = (Button) findViewById(R.id.stop);
        ImageView imageView = (ImageView) findViewById(R.id.anim);
        // 获取AnimationDrawable动画对象
        final AnimationDrawable anim = (AnimationDrawable) imageView
                .getBackground();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 开始播放动画
                anim.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 停止播放动画
                anim.stop();
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