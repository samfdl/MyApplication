package com.samfdl.ui.imageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.QuickContactBadge;

import com.samfdl.R;

public class QuickContactBadge1 extends AppCompatActivity {
    QuickContactBadge badge;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_imageview_quickcontactbadge);
        // 获取QuickContactBadge组件
        badge = (QuickContactBadge) findViewById(R.id.badge);
        // 将QuickContactBadge组件与特定电话号码对应的联系人建立关联
        badge.assignContactFromPhone("020-88888888", false);
    }
}