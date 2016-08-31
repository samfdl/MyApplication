package com.samfdl.ui.listview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.samfdl.R;

public class BaseAdapterListView extends AppCompatActivity {
    ListView myList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_arrayadapter);
        myList = (ListView) findViewById(R.id.list1);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                // 指定一共包含40个选项
                return 40;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            // 重写该方法，该方法的返回值将作为列表项的ID
            @Override
            public long getItemId(int position) {
                return position;
            }

            // 重写该方法，该方法返回的View将作为列表框
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // 创建一个LinearLayout，并向其中添加两个组件
                LinearLayout line = new LinearLayout(BaseAdapterListView.this);
                line.setOrientation(LinearLayout.HORIZONTAL);
                ImageView image = new ImageView(BaseAdapterListView.this);
                image.setImageResource(R.mipmap.ic_launcher);
                TextView text = new TextView(BaseAdapterListView.this);
                text.setText("第" + (position + 1) + "个列表项");
                text.setTextSize(20);
                text.setTextColor(Color.RED);
                line.addView(image);
                line.addView(text);
                // 返回LinearLayout实例
                return line;
            }
        };
        myList.setAdapter(adapter);
    }
}