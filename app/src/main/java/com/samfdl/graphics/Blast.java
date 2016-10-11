package com.samfdl.graphics;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.samfdl.R;

import java.lang.reflect.Field;

public class Blast extends AppCompatActivity {
    private MyView myView;
    private AnimationDrawable anim;
    private MediaPlayer bomb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 使用FrameLayout布局管理器，它允许组件自己控制位置
        FrameLayout frame = new FrameLayout(this);
        setContentView(frame);
        // 设置使用背景
        frame.setBackgroundResource(R.drawable.event_controlplane_back);
        // 加载音效
        bomb = MediaPlayer.create(this, R.raw.res_rawres_bomb);
        myView = new MyView(this);
        // 设置myView用于显示blast动画
        myView.setBackgroundResource(R.anim.graphics_blast);
        // 设置myView默认为隐藏
        myView.setVisibility(View.INVISIBLE);
        // 获取动画对象
        anim = (AnimationDrawable) myView.getBackground();
        frame.addView(myView);
        frame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View source, MotionEvent event) {
                // 只处理按下事件（避免每次产生两个动画效果）
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // 先停止动画播放
                    anim.stop();
                    float x = event.getX();
                    float y = event.getY();
                    // 控制myView的显示位置
                    myView.setLocation((int) y - 40, (int) x - 20);
                    myView.setVisibility(View.VISIBLE);
                    // 启动动画
                    anim.start();
                    // 播放音效
                    bomb.start();
                }
                return false;
            }
        });
    }

    // 定义一个自定义View，该自定义View用于播放“爆炸”效果
    class MyView extends ImageView {
        public MyView(Context context) {
            super(context);
        }

        // 定义一个方法，该方法用于控制MyView的显示位置
        public void setLocation(int top, int left) {
            this.setFrame(left, top, left + 40, top + 40);
        }

        // 重写该方法，控制如果动画播放到最后一帧时，隐藏该View
        @Override
        protected void onDraw(Canvas canvas) { // ①
            try {
                Field field = AnimationDrawable.class
                        .getDeclaredField("mCurFrame");
                field.setAccessible(true);
                // 获取anim动画的当前帧
                int curFrame = field.getInt(anim);
                // 如果已经到了最后一帧
                if (curFrame == anim.getNumberOfFrames() - 1) {
                    // 让该View隐藏
                    setVisibility(View.INVISIBLE);
                }
            } catch (Exception e) {
            }
            super.onDraw(canvas);
        }
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