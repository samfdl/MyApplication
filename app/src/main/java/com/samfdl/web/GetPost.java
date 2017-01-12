package com.samfdl.web;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.samfdl.R;

public class GetPost extends AppCompatActivity {
    Button get, post;
    TextView show;
    // 代表服务器响应的字符串
    String response;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                // 设置show组件显示服务器响应
                show.setText(response);
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_getpost);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        get = (Button) findViewById(R.id.get);
        post = (Button) findViewById(R.id.post);
        show = (TextView) findViewById(R.id.show);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        response = GetPostUtil.sendGet(
                                "http://192.168.1.88:8888/abc/a.jsp"
                                , null);
                        // 发送消息通知UI线程更新UI组件
                        handler.sendEmptyMessage(0x123);
                    }
                }.start();
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        response = GetPostUtil.sendPost(
                                "http://192.168.1.88:8888/abc/login.jsp"
                                , "name=crazyit.org&pass=leegang");
                    }
                }.start();
                // 发送消息通知UI线程更新UI组件
                handler.sendEmptyMessage(0x123);
            }
        });
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