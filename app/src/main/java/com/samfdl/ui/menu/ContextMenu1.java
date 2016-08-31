package com.samfdl.ui.menu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.samfdl.R;

// 长按txt，弹出菜单
public class ContextMenu1 extends AppCompatActivity {
    // 为每个菜单定义一个标识
    final int MENU1 = 0x111;
    final int MENU2 = 0x112;
    final int MENU3 = 0x113;
    private TextView txt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_menu_contextmenu);
        txt = (TextView) findViewById(R.id.txt);
        // 为文本框注册上下文菜单
        registerForContextMenu(txt); // ①
    }

    // 创建上下文菜单时触发该方法
    @Override
    public void onCreateContextMenu(ContextMenu menu, View source,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, MENU1, 0, "红色");
        menu.add(0, MENU2, 0, "绿色");
        menu.add(0, MENU3, 0, "蓝色");
        // 将三个菜单项设为单选菜单项
        menu.setGroupCheckable(0, true, true);
        //设置上下文菜单的标题、图标
        menu.setHeaderIcon(R.drawable.ui_toast_toast_tools);
        menu.setHeaderTitle("选择背景色");
    }

    // 上下文菜单的菜单项被单击时触发该方法
    @Override
    public boolean onContextItemSelected(MenuItem mi) {
        switch (mi.getItemId()) {
            case MENU1:
                mi.setChecked(true);
                txt.setBackgroundColor(Color.RED);
                break;
            case MENU2:
                mi.setChecked(true);
                txt.setBackgroundColor(Color.GREEN);
                break;
            case MENU3:
                mi.setChecked(true);
                txt.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }
}