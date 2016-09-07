package com.samfdl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.samfdl.activity.ActivityList;
import com.samfdl.event.EventList;
import com.samfdl.ui.UIList;
import com.samfdl.ui.textview.TextViewList;

public class AllList extends AppCompatActivity {
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_baseadapter);

        lv = (ListView) findViewById(R.id.myList);
        BaseAdapter mAdapter = new AllListAdapter(this);//得到一个MyAdapter对象
        lv.setAdapter(mAdapter);//为ListView绑定Adapter
        /**为ListView添加点击事件*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(AllList.this, UIList.class);
                        break;
                    case 1:
                        intent = new Intent(AllList.this, EventList.class);
                        break;
                    case 2:
                        intent = new Intent(AllList.this, ActivityList.class);
                        break;
                    case 3:
                        intent = new Intent(AllList.this, TextViewList.class);
                        break;
                    default:
                        intent = new Intent(AllList.this, UIList.class);
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, UIList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}