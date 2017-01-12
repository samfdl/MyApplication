package com.samfdl.web;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.samfdl.R;

public class MultiThreadClient extends AppCompatActivity {
    // 定义界面上的两个文本框
    EditText input;
    TextView show;
    // 定义界面上的一个按钮
    Button send;
    Handler handler;
    // 定义与服务器通信的子线程
    MultiThreadClientThread clientThread;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_multithreadclient);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        input = (EditText) findViewById(R.id.input);
        send = (Button) findViewById(R.id.send);
        show = (TextView) findViewById(R.id.show);
        handler = new Handler() // ②
        {
            @Override
            public void handleMessage(Message msg) {
                // 如果消息来自于子线程
                if (msg.what == 0x123) {
                    // 将读取的内容追加显示在文本框中
                    show.append("\n" + msg.obj.toString());
                }
            }
        };
        clientThread = new MultiThreadClientThread(handler);
        // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
        new Thread(clientThread).start(); // ①
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // 当用户按下发送按钮后，将用户输入的数据封装成Message
                    // 然后发送给子线程的Handler
                    Message msg = new Message();
                    msg.what = 0x345;
                    msg.obj = input.getText().toString();
                    clientThread.revHandler.sendMessage(msg);
                    // 清空input文本框
                    input.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
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