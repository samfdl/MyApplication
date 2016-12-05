package com.samfdl.graphics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ListView;

import com.samfdl.R;

public class ListViewTween extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_simple);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取ListView组件
        ListView list = (ListView) findViewById(R.id.list);
        WindowManager windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrice = new DisplayMetrics();
        // 获取屏幕的宽和高
        display.getMetrics(metrice);
        // 设置对ListView组件应用动画
        list.setAnimation(new ListViewTweenAnimation(metrice.xdpi / 2, metrice.ydpi / 2,
                3500));
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