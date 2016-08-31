package com.samfdl.ui.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.samfdl.R;

public class Spinner1 extends AppCompatActivity {
    Spinner spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_spinner);
        // 获取界面布局文件中的Spinner组件
        spinner = (Spinner) findViewById(R.id.spinner);
        String[] arr = {"孙悟空", "猪八戒", "唐僧"};
        // 创建ArrayAdapter对象
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,
                arr);
        // 为Spinner设置Adapter
        spinner.setAdapter(adapter);
    }
}