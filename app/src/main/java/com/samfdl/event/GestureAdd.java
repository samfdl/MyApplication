package com.samfdl.event;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.samfdl.R;

public class GestureAdd extends AppCompatActivity {
    EditText editText;
    GestureOverlayView gestureView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_gestureadd);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取文本编辑框
        editText = (EditText) findViewById(R.id.gesture_name);
        // 获取手势编辑视图
        gestureView = (GestureOverlayView)
                findViewById(R.id.gesture);
        // 设置手势的绘制颜色
        gestureView.setGestureColor(Color.RED);
        // 设置手势的绘制宽度
        gestureView.setGestureStrokeWidth(4);
        // 为gesture的手势完成事件绑定事件监听器
        gestureView.addOnGesturePerformedListener(
                new GestureOverlayView.OnGesturePerformedListener() {
                    @Override
                    public void onGesturePerformed(GestureOverlayView overlay,
                                                   final Gesture gesture) {
                        // 加载save.xml界面布局代表的视图
                        View saveDialog = getLayoutInflater().inflate(
                                R.layout.event_gestureadd_save, null);
                        // 获取saveDialog里的show组件
                        ImageView imageView = (ImageView) saveDialog
                                .findViewById(R.id.show);
                        // 获取saveDialog里的gesture_name组件
                        final EditText gestureName = (EditText) saveDialog
                                .findViewById(R.id.gesture_name);
                        // 根据Gesture包含的手势创建一个位图
                        Bitmap bitmap = gesture.toBitmap(128,
                                128, 10, 0xffff0000);
                        imageView.setImageBitmap(bitmap);
                        // 使用对话框显示saveDialog组件
                        new AlertDialog.Builder(GestureAdd.this)
                                .setView(saveDialog)
                                .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        // 获取指定文件对应的手势库
                                        GestureLibrary gestureLib = GestureLibraries
                                                .fromFile("/mnt/sdcard/mygestures");
                                        // 添加手势
                                        gestureLib.addGesture(gestureName.getText()
                                                .toString(), gesture);
                                        // 保存手势库
                                        gestureLib.save();
                                    }
                                }).setNegativeButton("取消", null).show();
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, EventList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}