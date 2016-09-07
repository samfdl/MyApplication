package com.samfdl.ui.actionbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.samfdl.R;
import com.samfdl.ui.UIList;

public class ActionBarList extends AppCompatActivity {
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_baseadapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lv = (ListView) findViewById(R.id.myList);
        BaseAdapter mAdapter = new ActionBarAdapter(this);//得到一个MyAdapter对象
        lv.setAdapter(mAdapter);//为ListView绑定Adapter
        /**为ListView添加点击事件*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent;
                switch (arg2) {
                    case 0:
                        intent = new Intent(ActionBarList.this, ActionBar1.class);
                        break;
                    case 1:
                        intent = new Intent(ActionBarList.this, ActionItem.class);
                        break;
                    case 2:
                        intent = new Intent(ActionBarList.this, ActionHome.class);
                        break;
                    case 3:
                        intent = new Intent(ActionBarList.this, ActionView.class);
                        break;
                    case 4:
                        intent = new Intent(ActionBarList.this, TabNav.class);
                        break;
                    case 5:
                        intent = new Intent(ActionBarList.this, SwipeNav.class);
                        break;
                    case 6:
                        intent = new Intent(ActionBarList.this, DropDownNav.class);
                        break;
                    default:
                        intent = new Intent(ActionBarList.this, ActionBar1.class);
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