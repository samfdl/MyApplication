package com.samfdl.res;

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

public class ResList extends AppCompatActivity {
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_baseadapter);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lv = (ListView) findViewById(R.id.myList);
        BaseAdapter mAdapter = new ResListAdapter(this);//得到一个MyAdapter对象
        lv.setAdapter(mAdapter);//为ListView绑定Adapter
        /**为ListView添加点击事件*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(ResList.this, ValuesRes.class);
                        break;
                    case 1:
                        intent = new Intent(ResList.this, ArrayRes1.class);
                        break;
                    case 2:
                        intent = new Intent(ResList.this, StateListDrawable1.class);
                        break;
                    case 3:
                        intent = new Intent(ResList.this, ClipDrawable1.class);
                        break;
                    case 4:
                        intent = new Intent(ResList.this, AnimationDrawable1.class);
                        break;
                    case 5:
                        intent = new Intent(ResList.this, PropertyAnimation.class);
                        break;
                    case 6:
                        intent = new Intent(ResList.this, XmlRes1.class);
                        break;
                    case 7:
                        intent = new Intent(ResList.this, StyleRes1.class);
                        break;
                    case 8:
                        intent = new Intent(ResList.this, AttributeRes.class);
                        break;
                    case 9:
                        intent = new Intent(ResList.this, RawRes1.class);
                        break;
                    case 10:
                        intent = new Intent(ResList.this, I18N.class);
                        break;
                    case 11:
                        intent = new Intent(ResList.this, Dpi.class);
                        break;
                    case 12:
                        intent = new Intent(ResList.this, ScreenSize.class);
                        break;
                    default:
                        intent = new Intent(ResList.this, ValuesRes.class);
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