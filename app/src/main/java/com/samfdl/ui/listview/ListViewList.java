package com.samfdl.ui.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.samfdl.R;

public class ListViewList extends AppCompatActivity {
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_baseadapter);

        lv = (ListView) findViewById(R.id.myList);
        BaseAdapter mAdapter = new ListViewAdapter(this);//得到一个MyAdapter对象
        lv.setAdapter(mAdapter);//为ListView绑定Adapter
        /**为ListView添加点击事件*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(ListViewList.this, SimpleListView.class);
                        break;
                    case 1:
                        intent = new Intent(ListViewList.this, ArrayAdapterListView.class);
                        break;
                    case 2:
                        intent = new Intent(ListViewList.this, ListActivity1.class);
                        break;
                    case 3:
                        intent = new Intent(ListViewList.this, SimpleAdapterListView.class);
                        break;
                    case 4:
                        intent = new Intent(ListViewList.this, BaseAdapterListView.class);
                        break;
                    case 5:
                        intent = new Intent(ListViewList.this, AutoCompleteTextView1.class);
                        break;
                    case 6:
                        intent = new Intent(ListViewList.this, GridView1.class);
                        break;
                    case 7:
                        intent = new Intent(ListViewList.this, ExpandableListView1.class);
                        break;
                    case 8:
                        intent = new Intent(ListViewList.this, Spinner1.class);
                        break;
                    case 9:
                        intent = new Intent(ListViewList.this, AdapterViewFlipper1.class);
                        break;
                    case 10:
                        intent = new Intent(ListViewList.this, StackView1.class);
                        break;
                    default:
                        intent = new Intent(ListViewList.this, SimpleListView.class);
                }
                startActivity(intent);
            }
        });
    }
}