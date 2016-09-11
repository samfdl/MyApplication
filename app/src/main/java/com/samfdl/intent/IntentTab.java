package com.samfdl.intent;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TabHost;

import com.samfdl.R;

// Tab 位置有点问题
public class IntentTab extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_intenttab);

        // 获取该Activity里面的TabHost组件
        TabHost tabHost = getTabHost();
        // 使用Intent添加第一个Tab页面
        tabHost.addTab(
                tabHost.newTabSpec("tab1").setIndicator("已接电话", getResources().getDrawable(R.mipmap.ic_launcher))
                        .setContent(new Intent(this, IntentTabBeCalled.class)));
        // 使用Intent添加第二个Tab页面
        tabHost.addTab(
                tabHost.newTabSpec("tab1").setIndicator("呼出电话").setContent(new Intent(this, IntentTabCalled.class)));
        // 使用Intent添加第三个Tab页面
        tabHost.addTab(
                tabHost.newTabSpec("tab1").setIndicator("未接电话").setContent(new Intent(this, IntentTabNoCall.class)));
    }
}