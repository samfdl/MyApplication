package com.samfdl.ui.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.samfdl.R;

public class ArrayAdapterListView extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_arrayadapter);
        ListView list1 = (ListView) findViewById(R.id.list1);
        // 定义一个数组
        String[] arr1 = { "孙悟空", "猪八戒", "牛魔王" };
        // 将数组包装为ArrayAdapter
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.ui_listview_arrayadapter_item1, arr1);
        // 为ListView设置Adapter
        list1.setAdapter(adapter1);
    }
}