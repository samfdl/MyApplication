package com.samfdl.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.samfdl.R;

public class ActionData extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_actiondata);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button bn = (Button) findViewById(R.id.bn);
        // 为bn按钮添加一个监听器
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent
                Intent intent = new Intent();
                String data = "http://www.crazyit.org";
                // 根据指定字符串解析出Uri对象
                Uri uri = Uri.parse(data);
                // 为Intent设置Action属性
                intent.setAction(Intent.ACTION_VIEW);
                // 设置Data属性
                intent.setData(uri);
                startActivity(intent);
            }
        });
        Button edit = (Button) findViewById(R.id.edit);
        // 为edit按钮添加一个监听器
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent
                Intent intent = new Intent();
                // 为Intent设置Action属性（动作为：编辑）
                intent.setAction(Intent.ACTION_EDIT);
                String data = "content://com.android.contacts/contacts/1";
                // 根据指定字符串解析出Uri对象
                Uri uri = Uri.parse(data);
                // 设置Data属性
                intent.setData(uri);
                startActivity(intent);
            }
        });
        Button call = (Button) findViewById(R.id.call);
        // 为call按钮添加一个监听器
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent
                Intent intent = new Intent();
                // 为Intent设置Action属性（动作为：拨号）
                intent.setAction(Intent.ACTION_DIAL);
                String data = "tel:13800138000";
                // 根据指定字符串解析出Uri对象
                Uri uri = Uri.parse(data);
                // 设置Data属性
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, IntentList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}