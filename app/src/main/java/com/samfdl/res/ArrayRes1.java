package com.samfdl.res;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.samfdl.R;

public class ArrayRes1 extends AppCompatActivity {
    // 获取系统定义的数组资源
    String[] texts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.res_arrayres);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        texts = getResources().getStringArray(R.array.res_valuesres_string_arr);
        // 创建一个BaseAdapter对象
        BaseAdapter ba = new BaseAdapter() {
            @Override
            public int getCount() {
                // 指定一共包含9个选项
                return texts.length;
            }

            @Override
            public Object getItem(int position) {
                // 返回指定位置的文本
                return texts[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            // 重写该方法，该方法返回的View将作为的GridView的每个格子
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView text = new TextView(ArrayRes1.this);
                Resources res = ArrayRes1.this.getResources();
                // 使用尺度资源来设置文本框的高度、宽度
                text.setWidth((int) res.getDimension(R.dimen.res_arrayres_cell_width));
                text.setHeight((int) res.getDimension(R.dimen.res_arrayres_cell_height));
                // 使用字符串资源设置文本框的内容
                text.setText(texts[position]);
                TypedArray icons = res.obtainTypedArray(R.array.res_valuesres_plain_arr);
                // 使用颜色资源来设置文本框的背景色
                text.setBackground(icons.getDrawable(position));
                text.setTextSize(20);
                return text;
            }
        };
        GridView grid = (GridView) findViewById(R.id.grid01);
        // 为GridView设置Adapter
        grid.setAdapter(ba);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, ResList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}