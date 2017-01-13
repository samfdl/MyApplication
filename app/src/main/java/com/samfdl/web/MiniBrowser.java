package com.samfdl.web;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

import com.samfdl.R;

public class MiniBrowser extends AppCompatActivity {
    EditText url;
    WebView show;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_minibrowser);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取页面中文本框、WebView组件
        url = (EditText) findViewById(R.id.url);
        show = (WebView) findViewById(R.id.show);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            String urlStr = url.getText().toString();
            // 加载、并显示urlStr对应的网页
            show.loadUrl(urlStr);
            return true;
        }
        return false;
    }

    public void load(View source) {
        String urlStr = url.getText().toString();
        // 加载、并显示urlStr对应的网页
        show.loadUrl(urlStr);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, WebList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}