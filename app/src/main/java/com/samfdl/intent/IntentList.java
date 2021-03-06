package com.samfdl.intent;

import android.content.ComponentName;
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

public class IntentList extends AppCompatActivity {
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_baseadapter);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lv = (ListView) findViewById(R.id.myList);
        BaseAdapter mAdapter = new IntentListAdapter(this);//得到一个MyAdapter对象
        lv.setAdapter(mAdapter);//为ListView绑定Adapter
        /**为ListView添加点击事件*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent();
                        // 创建一个ComponentName对象
                        ComponentName comp = new ComponentName(IntentList.this, ComponentAttribute.class);
                        // 为Intent设置Component属性
                        intent.setComponent(comp);
                        break;
                    case 1:
                        intent = new Intent();
                        // 为Intent设置Action属性（属性值就是一个普通字符串）
                        intent.setAction(ActionAttribute.CRAZYIT_ACTION);
                        break;
                    case 2:
                        intent = new Intent();
                        // 设置Action属性
                        intent.setAction(ActionCategoryAttribute.CRAZYIT_ACTION);
                        // 添加Category属性
                        intent.addCategory(ActionCategoryAttribute.CRAZYIT_CATEGORY);
                        break;
                    case 3:
                        intent = new Intent(IntentList.this, SystemAction.class);
                        break;
                    case 4:
                        // 创建Intent对象
                        intent = new Intent();
                        // 为Intent设置Action、Category属性
                        intent.setAction(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        break;
                    case 5:
                        intent = new Intent(IntentList.this, DataTypeOverride.class);
                        break;
                    case 6:
                        intent = new Intent(IntentList.this, DataTypeAttribute.class);
                        break;
                    case 7:
                        intent = new Intent(IntentList.this, ActionData.class);
                        break;
                    case 8:
                        intent = new Intent(IntentList.this, IntentTab.class);
                        break;
                    default:
                        intent = new Intent(IntentList.this, ComponentAttribute.class);
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