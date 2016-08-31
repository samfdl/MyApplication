package com.samfdl.ui.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.samfdl.R;

public class AutoCompleteTextView1 extends AppCompatActivity {
    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mauto;
    // 定义字符串数组，作为提示的文本
    String[] books = new String[]{"疯狂Java讲义", "疯狂Ajax讲义", "疯狂XML讲义", "疯狂Workflow讲义"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_autocompletetextview);
        // 创建一个ArrayAdapter，封装数组
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, books);
        actv = (AutoCompleteTextView) findViewById(R.id.auto);
        // 设置Adapter
        actv.setAdapter(aa);
        mauto = (MultiAutoCompleteTextView) findViewById(R.id.mauto);
        // 设置Adapter
        mauto.setAdapter(aa);
        // 为MultiAutoCompleteTextView设置分隔符
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}