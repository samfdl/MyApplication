package com.samfdl.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.samfdl.R;

// 应该修改成触屏事件
public class ControlPlane extends AppCompatActivity {
    // 定义飞机的移动速度
    private int speed = 10;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 创建PlaneView组件
        final ControlPlaneView planeView = new ControlPlaneView(this);
        setContentView(planeView);
        planeView.setBackgroundResource(R.drawable.event_controlplane_back);
        // 获取窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        // 获得屏幕宽和高
        display.getMetrics(metrics);
        // 设置飞机的初始位置
        planeView.currentX = metrics.widthPixels / 2;
        planeView.currentY = metrics.heightPixels / 2;
        // 为planeView组件的键盘事件绑定监听器
        planeView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 当前组件的currentX、currentY两个属性
                planeView.currentX = event.getX();
                planeView.currentY = event.getY();
                // 通知改组件重绘
                planeView.invalidate();
                // 返回true表明处理方法已经处理该事件
                return true;
            }
        });
    }
}