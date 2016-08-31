package com.samfdl.ui.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.samfdl.R;

public class DialogList extends AppCompatActivity {
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_baseadapter);

        lv = (ListView) findViewById(R.id.myList);
        BaseAdapter mAdapter = new DialogAdapter(this);//得到一个MyAdapter对象
        lv.setAdapter(mAdapter);//为ListView绑定Adapter
        /**为ListView添加点击事件*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent;
                switch (arg2) {
                    case 0:
                        intent = new Intent(DialogList.this, AlertDialog1.class);
                        break;
                    case 1:
                        intent = new Intent(DialogList.this, DialogTheme.class);
                        break;
                    case 2:
                        intent = new Intent(DialogList.this, PopupWindow1.class);
                        break;
                    case 3:
                        intent = new Intent(DialogList.this, DatePickerDialog1.class);
                        break;
                    case 4:
                        intent = new Intent(DialogList.this, ProgressDialog1.class);
                        break;
                    default:
                        intent = new Intent(DialogList.this, AlertDialog1.class);
                }
                startActivity(intent);
            }
        });
    }
}