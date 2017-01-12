package com.samfdl.web;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;

import com.samfdl.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SimpleClient extends AppCompatActivity {
    EditText show;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_simpleclient);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        show = (EditText) findViewById(R.id.show);
        new Thread() {
            @Override
            public void run() {
                try {
                    // 建立连接到远程服务器的Socket
                    Socket socket = new Socket("192.168.1.88", 30000);  // ①
                    // 将Socket对应的输入流包装成BufferedReader
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    // 进行普通I/O操作
                    String line = br.readLine();
                    show.setText("来自服务器的数据：" + line);
                    // 关闭输入流、socket
                    br.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
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