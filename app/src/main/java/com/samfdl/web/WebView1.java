package com.samfdl.web;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.samfdl.R;

// 有问题，需要解决
public class WebView1 extends AppCompatActivity {
    EditText url;
    Button bn;
    WebView show;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_webview);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取页面中文本框、WebView组件
        url = (EditText) findViewById(R.id.url);
        bn = (Button) findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlStr = url.getText().toString();
                // 加载、并显示urlStr对应的网页
                Toast toast = Toast.makeText(WebView1.this
                        , "简单的提示信息"
                        , Toast.LENGTH_SHORT);
                toast.show();
                show.loadUrl(urlStr);
            }
        });
        show = (WebView) findViewById(R.id.show);
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