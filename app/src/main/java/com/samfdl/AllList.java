package com.samfdl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.samfdl.activity.ActivityList;
import com.samfdl.event.EventList;
import com.samfdl.intent.IntentList;
import com.samfdl.res.ResList;
import com.samfdl.ui.UIList;
import com.samfdl.web.WebList;

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
                        intent = new Intent(AllList.this, ActivityList.class);
                        break;
                    case 1:
                        intent = new Intent(AllList.this, UIList.class);
                        break;
                    case 2:
                        intent = new Intent(AllList.this, EventList.class);
                        break;
                    case 3:
                        intent = new Intent(AllList.this, IntentList.class);
                        break;
                    case 4:
                        intent = new Intent(AllList.this, ResList.class);
                        break;
                    case 5:
                        intent = new Intent(AllList.this, WebList.class);
                        break;
                    default:
                        intent = new Intent(AllList.this, ActivityList.class);
                }
                startActivity(intent);
            }
        });
    }
}