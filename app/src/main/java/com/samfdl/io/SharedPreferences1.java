package com.samfdl.io;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.samfdl.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedPreferences1 extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.io_sharedpreferences);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取只能被本应用程序读、写的SharedPreferences对象
        preferences = getSharedPreferences("count", MODE_PRIVATE);
        editor = preferences.edit();
        Button read = (Button) findViewById(R.id.read);
        Button write = (Button) findViewById(R.id.write);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // 读取字符串数据
                String time = preferences.getString("time", null);
                // 读取int类型的数据
                int randNum = preferences.getInt("random", 0);
                String result = time == null ? "您暂时还未写入数据" : "写入时间为："
                        + time + "\n上次生成的随机数为：" + randNum;
                // 使用Toast提示信息
                Toast.makeText(SharedPreferences1.this, result
                        , Toast.LENGTH_SHORT).show();
            }
        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 "
                        + "hh:mm:ss");
                // 存入当前时间
                editor.putString("time", sdf.format(new Date()));
                // 存入一个随机数
                editor.putInt("random", (int) (Math.random() * 100));
                // 提交所有存入的数据
                editor.commit();
            }
        });

        preferences = getSharedPreferences("count"
                , MODE_PRIVATE);
        // 读取SharedPreferences里的count数据
        int count = preferences.getInt("count", 0);
        // 显示程序以前使用的次数
        Toast.makeText(this, "程序以前被使用了" + count + "次。"
                , Toast.LENGTH_LONG).show();
        SharedPreferences.Editor editor = preferences.edit();
        // 存入数据
        editor.putInt("count", ++count);
        // 提交修改
        editor.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, IOList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}