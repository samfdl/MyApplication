package com.samfdl.handler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.samfdl.R;
import com.samfdl.graphics.GraphicsList;

public class SendMessage extends AppCompatActivity {
    private TextView textView;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            textView.setText("" + msg.arg1 + "-" + msg.arg2 + " " + msg.obj);
        }
    };

    class Person {
        public int age;
        public String name;

        @Override
        public String toString() {
            return "name =" + name + " age = " + age;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_post);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView = (TextView) findViewById(R.id.textView2);

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
//                    Message message = new Message();
                    Message message = handler.obtainMessage();
                    message.arg1 = 88;
                    message.arg2 = 100;
                    Person person = new Person();
                    person.name = "nate";
                    person.age = 18;
                    message.obj = person;
//                    handler.sendMessage(message);
                    message.sendToTarget();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, GraphicsList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}