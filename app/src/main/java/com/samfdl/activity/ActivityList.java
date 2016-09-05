package com.samfdl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.samfdl.R;
import com.samfdl.event.EventList;
import com.samfdl.ui.imageview.ImageViewList;
import com.samfdl.ui.layout.Layout;
import com.samfdl.ui.textview.TextViewList;

public class ActivityList extends AppCompatActivity {
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_baseadapter);

        lv = (ListView) findViewById(R.id.myList);
        BaseAdapter mAdapter = new ActivityListAdapter(this);//得到一个MyAdapter对象
        lv.setAdapter(mAdapter);//为ListView绑定Adapter
        /**为ListView添加点击事件*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(ActivityList.this, LauncherActivity1.class);
                        break;
                    case 1:
                        intent = new Intent(ActivityList.this, EventList.class);
                        break;
                    case 2:
                        intent = new Intent(ActivityList.this, Layout.class);
                        break;
                    case 3:
                        intent = new Intent(ActivityList.this, TextViewList.class);
                        break;
                    case 4:
                        intent = new Intent(ActivityList.this, ImageViewList.class);
                        break;

                    default:
                        intent = new Intent(ActivityList.this, LauncherActivity1.class);
                }
                startActivity(intent);
            }
        });
    }
}