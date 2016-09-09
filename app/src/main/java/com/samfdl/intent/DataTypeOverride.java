package com.samfdl.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.samfdl.R;

public class DataTypeOverride extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_datatypeoverride);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void overrideType(View source) {
        Intent intent = new Intent();
        // 先为Intent设置Type属性
        intent.setType("abc/xyz");
        // 再为Intent设置Data属性，覆盖Type属性
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/test"));
        Toast.makeText(this, intent.toString(), Toast.LENGTH_LONG).show();
    }

    public void overrideData(View source) {
        Intent intent = new Intent();
        // 先为Intent设置Data属性
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/mypath"));
        // 再为Intent设置Type属性，覆盖Data属性
        intent.setType("abc/xyz");
        Toast.makeText(this, intent.toString(), Toast.LENGTH_LONG).show();
    }

    public void dataAndType(View source) {
        Intent intent = new Intent();
        // 同时设置Intent的Data、Type属性
        intent.setDataAndType(Uri.parse("lee://www.fkjava.org:8888/mypath"),
                "abc/xyz");
        Toast.makeText(this, intent.toString(), Toast.LENGTH_LONG).show();
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