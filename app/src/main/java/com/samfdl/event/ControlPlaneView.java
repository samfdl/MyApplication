package com.samfdl.event;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.samfdl.R;

public class ControlPlaneView extends View {
    public float currentX;
    public float currentY;
    Bitmap plane;

    public ControlPlaneView(Context context) {
        super(context);
        // 定义飞机图片
        plane = BitmapFactory.decodeResource(context.getResources(), R.drawable.event_controlplane_plane);
        setFocusable(true);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 创建画笔
        Paint p = new Paint();
        // 绘制飞机
        canvas.drawBitmap(plane, currentX, currentY, p);
    }
}