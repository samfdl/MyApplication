package com.samfdl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.samfdl.activity.ActivityList;
import com.samfdl.diy.DIYList;
import com.samfdl.event.EventList;
import com.samfdl.graphics.GraphicsList;
import com.samfdl.hardware.HardwareList;
import com.samfdl.intent.IntentList;
import com.samfdl.io.IOList;
import com.samfdl.media.MediaList;
import com.samfdl.phone.PhoneList;
import com.samfdl.res.ResList;
import com.samfdl.service.ServiceList;
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
                        intent = new Intent(AllList.this, ServiceList.class);
                        break;
                    case 3:
                        intent = new Intent(AllList.this, EventList.class);
                        break;
                    case 4:
                        intent = new Intent(AllList.this, IntentList.class);
                        break;
                    case 5:
                        intent = new Intent(AllList.this, ResList.class);
                        break;
                    case 6:
                        intent = new Intent(AllList.this, IOList.class);
                        break;
                    case 7:
                        intent = new Intent(AllList.this, GraphicsList.class);
                        break;
                    case 8:
                        intent = new Intent(AllList.this, MediaList.class);
                        break;
                    case 9:
                        intent = new Intent(AllList.this, HardwareList.class);
                        break;
                    case 10:
                        intent = new Intent(AllList.this, WebList.class);
                        break;
                    case 11:
                        intent = new Intent(AllList.this, PhoneList.class);
                        break;
                    case 12:
                        intent = new Intent(AllList.this, DIYList.class);
                        break;
                    default:
                        intent = new Intent(AllList.this, ActivityList.class);
                }
                startActivity(intent);
            }
        });
    }
}