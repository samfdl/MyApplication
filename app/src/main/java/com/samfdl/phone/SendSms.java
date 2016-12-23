package com.samfdl.phone;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.samfdl.R;

public class SendSms extends AppCompatActivity {
    EditText number, content;
    Button send;
    SmsManager sManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_sendsms);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取SmsManager
        sManager = SmsManager.getDefault();
        // 获取程序界面上的两个文本框和按钮
        number = (EditText) findViewById(R.id.number);
        content = (EditText) findViewById(R.id.content);
        send = (Button) findViewById(R.id.send);
        // 为send按钮的单击事件绑定监听器
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // 创建一个PendingIntent对象
                PendingIntent pi = PendingIntent.getActivity(
                        SendSms.this, 0, new Intent(), 0);
                // 发送短信
                sManager.sendTextMessage(number.getText().toString(),
                        null, content.getText().toString(), pi, null);
                // 提示短信发送完成
                Toast.makeText(SendSms.this, "短信发送完成", 8000).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, PhoneList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}