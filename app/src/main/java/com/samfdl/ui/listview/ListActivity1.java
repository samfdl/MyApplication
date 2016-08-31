package com.samfdl.ui.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.samfdl.R;

public class ListActivity1 extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 无须使用布局文件
        String[] arr = { "孙悟空", "猪八戒", "唐僧" };
        // 创建ArrayAdapter对象
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,
                arr);
        // 设置该窗口显示列表
        setListAdapter(adapter);
    }
}