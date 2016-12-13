package com.samfdl.io;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.Toast;

import com.samfdl.R;

public class Gesture1 extends AppCompatActivity implements GestureDetector.OnGestureListener {
    // 定义手势检测器实例
    GestureDetector detector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //创建手势检测器
        detector = new GestureDetector(this, this);
    }

    //将该Activity上的触碰事件交给GestureDetector处理
    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return detector.onTouchEvent(me);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        Toast.makeText(this, "onDown"
                , Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2
            , float velocityX, float velocityY) {
        Toast.makeText(this, "onFling"
                , Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast.makeText(this, "onLongPress"
                , Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2
            , float distanceX, float distanceY) {
        Toast.makeText(this, "onScroll",
                Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Toast.makeText(this, "onShowPress"
                , Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Toast.makeText(this, "onSingleTapUp"
                , Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, IOList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}