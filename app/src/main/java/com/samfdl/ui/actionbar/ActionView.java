package com.samfdl.ui.actionbar;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

import com.samfdl.R;

public class ActionView extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_textview_button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator = new MenuInflater(this);
        // 状态R.menu.menu_main对应的菜单，并添加到menu中
        inflator.inflate(R.menu.ui_actionbar_actionview_menu_main, menu);
        return true;
    }
}