package com.samfdl.ui.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.samfdl.R;
import com.samfdl.ui.textview.Button1;

public class ActivityMenu extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // -------------向menu中添加子菜单-------------
        SubMenu prog = menu.addSubMenu("启动程序");
        // 设置菜单头的图标
        prog.setHeaderIcon(R.drawable.ui_toast_toast_tools);
        // 设置菜单头的标题
        prog.setHeaderTitle("选择您要启动的程序");
        // 添加菜单项
        MenuItem item = prog.add("查看Swift");
        //为菜单项设置关联的Activity
        item.setIntent(new Intent(this, Button1.class));
        return super.onCreateOptionsMenu(menu);
    }
}