package com.samfdl.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.samfdl.R;

public class DataTypeAttribute extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_datatypeattribute);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void scheme(View source) {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.crazyit.org:1234/test"));
        startActivity(intent);
    }

    public void schemeHostPort(View source) {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/test"));
        startActivity(intent);
    }

    public void schemeHostPath(View source) {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.fkjava.org:1234/mypath"));
        startActivity(intent);
    }

    public void schemeHostPortPath(View source) {
        Intent intent = new Intent();
        // 只设置Intent的Data属性
        intent.setData(Uri.parse("lee://www.fkjava.org:8888/mypath"));
        startActivity(intent);
    }

    public void schemeHostPortPathType(View source) {
        Intent intent = new Intent();
        // 同时设置Intent的Data、Type属性
        intent.setDataAndType(Uri.parse("lee://www.fkjava.org:8888/mypath")
                , "abc/xyz");
        startActivity(intent);
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