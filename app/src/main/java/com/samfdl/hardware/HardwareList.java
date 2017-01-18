package com.samfdl.hardware;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.samfdl.AllList;
import com.samfdl.R;
import com.samfdl.phone.BlockList;
import com.samfdl.phone.GroupSend;
import com.samfdl.phone.MonitorPhone;
import com.samfdl.phone.MonitorSms;
import com.samfdl.phone.SendSms;

public class HardwareList extends AppCompatActivity {
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_baseadapter);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lv = (ListView) findViewById(R.id.myList);
        BaseAdapter mAdapter = new HardwareListAdapter(this);//得到一个MyAdapter对象
        lv.setAdapter(mAdapter);//为ListView绑定Adapter
        /**为ListView添加点击事件*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(HardwareList.this, Vibrator1.class);
                        break;
                    case 1:
                        intent = new Intent(HardwareList.this, Accelerometer.class);
                        break;
                    case 2:
                        intent = new Intent(HardwareList.this, BlockList.class);
                        break;
                    case 3:
                        intent = new Intent(HardwareList.this, SendSms.class);
                        break;
                    case 4:
                        intent = new Intent(HardwareList.this, GroupSend.class);
                        break;
                    case 5:
                        intent = new Intent(HardwareList.this, MonitorSms.class);
                        break;
                    default:
                        intent = new Intent(HardwareList.this, Vibrator1.class);
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, AllList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}