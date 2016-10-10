package com.samfdl.graphics;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.samfdl.R;

import java.util.Timer;
import java.util.TimerTask;

// 有点问题
public class MoveBack extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    class MyView extends View {
        // 记录背景位图的实际高度
        final int BACK_HEIGHT = 1700;
        // 背景图片
        private Bitmap back;
        private Bitmap plane;
        // 定义图片的宽度
        final int WIDTH = 640;
        final int HEIGHT = 880;
        private Matrix matrix = new Matrix();
        // 背景图片的开始位置
        private int startY = BACK_HEIGHT - HEIGHT;

        public MyView(Context context) {
            super(context);
            back = BitmapFactory.decodeResource(context.getResources(),
                    R.drawable.graphics_moveback_back_img);
            // 获取窗口管理器
            WindowManager windowManager = getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            // 获得屏幕的宽度
            float screenWidth = metrics.widthPixels;
            // 获取图片的缩放比例
            float scale = screenWidth / WIDTH;
            matrix.setScale(scale, scale);
            plane = BitmapFactory.decodeResource(context.getResources(),
                    R.drawable.event_controlplane_plane);
            final Handler handler = new Handler() {
                public void handleMessage(Message msg) {
                    if (msg.what == 0x123) {
                        // 重新开始移动
                        if (startY <= 3) {
                            startY = BACK_HEIGHT - HEIGHT;
                        } else {
                            startY -= 3;
                        }
                    }
                    invalidate();
                }
            };
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.sendEmptyMessage(0x123);
                }
            }, 0, 100);
        }

        @Override
        public void onDraw(Canvas canvas) {
            // 根据原始位图和缩放Matrix创建新图片
            Bitmap bitmap2 = Bitmap
                    .createBitmap(back, 0, startY, WIDTH, HEIGHT, matrix, false); // ①
            // 绘制新位图
            canvas.drawBitmap(bitmap2, 0, 0, null);
            // 绘制飞机
            canvas.drawBitmap(plane, 320, 700, null);
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