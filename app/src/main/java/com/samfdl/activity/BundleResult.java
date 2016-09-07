package com.samfdl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.samfdl.R;
import com.samfdl.activity.model.Person;

public class BundleResult extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundleresult);
        TextView name = (TextView) findViewById(R.id.name);
        TextView passwd = (TextView) findViewById(R.id.passwd);
        TextView gender = (TextView) findViewById(R.id.gender);
        // 获取启动该Activity的Intent
        Intent intent = getIntent();
        // 直接通过Intent取出它所携带的Bundle数据包中的数据
        Person p = (Person) intent.getSerializableExtra("person");
        if (name != null) {
            name.setText("您的用户名为：" + p.getName());
        }
        if (passwd != null) {
            passwd.setText("您的密码为：" + p.getPasswd());
        }
        if (gender != null) {
            gender.setText("您的性别为：" + p.getGender());
        }
    }
}