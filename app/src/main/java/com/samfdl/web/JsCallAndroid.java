package com.samfdl.web;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.samfdl.R;

public class JsCallAndroid extends AppCompatActivity {
    WebView myWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_webview);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myWebView = (WebView) findViewById(R.id.show);
        // 此处为了简化编程，使用file协议加载本地assets目录下的HTML页面
        // 如果有需要，也可使用http协议加载远程网站的HTML页面
        myWebView.loadUrl("file:///android_asset/web_jscallandroid.html");
        // 获取WebView的设置对象
        WebSettings webSettings = myWebView.getSettings();
        // 开启JavaScript调用
        webSettings.setJavaScriptEnabled(true);
        // 将MyObject对象暴露给JavaScript脚本
        // 这样test.html页面中的JavaScript可以通过myObj来调用MyObject的方法
        myWebView.addJavascriptInterface(new JsCallAndroidObject(this), "myObj");
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