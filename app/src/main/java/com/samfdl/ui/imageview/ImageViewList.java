package com.samfdl.ui.imageview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.samfdl.R;

public class ImageViewList extends AppCompatActivity {
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_baseadapter);

        lv = (ListView) findViewById(R.id.myList);
        BaseAdapter mAdapter = new ImageViewAdapter(this);//得到一个MyAdapter对象
        lv.setAdapter(mAdapter);//为ListView绑定Adapter
        /**为ListView添加点击事件*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent;
                switch (arg2) {
                    case 0:
                        intent = new Intent(ImageViewList.this, ImageView1.class);
                        break;
                    case 1:
                        intent = new Intent(ImageViewList.this, ImageButton.class);
                        break;
                    case 2:
                        intent = new Intent(ImageViewList.this, QuickContactBadge1.class);
                        break;
                    default:
                        intent = new Intent(ImageViewList.this, ImageView1.class);
                }
                startActivity(intent);
            }
        });
    }
}