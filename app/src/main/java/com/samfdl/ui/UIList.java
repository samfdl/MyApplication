package com.samfdl.ui;

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
import com.samfdl.ui.actionbar.ActionBarList;
import com.samfdl.ui.dialog.DialogList;
import com.samfdl.ui.imageview.ImageViewList;
import com.samfdl.ui.layout.Layout;
import com.samfdl.ui.listview.ListViewList;
import com.samfdl.ui.menu.MenuList;
import com.samfdl.ui.progressbar.ProgressBarList;
import com.samfdl.ui.textview.TextViewList;
import com.samfdl.ui.toast.ToastList;
import com.samfdl.ui.viewanimator.ViewAnimatorList;
import com.samfdl.ui.webview.WebView;

public class UIList extends AppCompatActivity {
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_baseadapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lv = (ListView) findViewById(R.id.myList);
        BaseAdapter mAdapter = new UIListAdapter(this);//得到一个MyAdapter对象
        lv.setAdapter(mAdapter);//为ListView绑定Adapter
        /**为ListView添加点击事件*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(UIList.this, ActionBarList.class);
                        break;
                    case 1:
                        intent = new Intent(UIList.this, MenuList.class);
                        break;
                    case 2:
                        intent = new Intent(UIList.this, Layout.class);
                        break;
                    case 3:
                        intent = new Intent(UIList.this, TextViewList.class);
                        break;
                    case 4:
                        intent = new Intent(UIList.this, ImageViewList.class);
                        break;
                    case 5:
                        intent = new Intent(UIList.this, ListViewList.class);
                        break;
                    case 6:
                        intent = new Intent(UIList.this, ProgressBarList.class);
                        break;
                    case 7:
                        intent = new Intent(UIList.this, ViewAnimatorList.class);
                        break;
                    case 8:
                        intent = new Intent(UIList.this, ToastList.class);
                        break;
                    case 9:
                        intent = new Intent(UIList.this, DialogList.class);
                        break;
                    case 10:
                        intent = new Intent(UIList.this, WebView.class);
                        break;
                    default:
                        intent = new Intent(UIList.this, Layout.class);
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