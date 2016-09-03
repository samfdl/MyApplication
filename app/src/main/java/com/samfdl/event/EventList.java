package com.samfdl.event;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.samfdl.R;
import com.samfdl.ui.dialog.DialogList;
import com.samfdl.ui.progressbar.ProgressBarList;
import com.samfdl.ui.toast.ToastList;
import com.samfdl.ui.viewanimator.ViewAnimatorList;
import com.samfdl.ui.webview.WebView;

public class EventList extends AppCompatActivity {
    private ListView lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_baseadapter);

        lv = (ListView) findViewById(R.id.myList);
        BaseAdapter mAdapter = new EventListAdapter(this);//得到一个MyAdapter对象
        lv.setAdapter(mAdapter);//为ListView绑定Adapter
        /**为ListView添加点击事件*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(EventList.this, ControlPlane.class);
                        break;
                    case 1:
                        intent = new Intent(EventList.this, SendSms.class);
                        break;
                    case 2:
                        intent = new Intent(EventList.this, Ball.class);
                        break;
                    case 3:
                        intent = new Intent(EventList.this, SystemStatus.class);
                        break;
                    case 4:
                        intent = new Intent(EventList.this, ChangeConfig.class);
                        break;
                    case 5:
                        intent = new Intent(EventList.this, Handler1.class);
                        break;
                    case 6:
                        intent = new Intent(EventList.this, ProgressBarList.class);
                        break;
                    case 7:
                        intent = new Intent(EventList.this, ViewAnimatorList.class);
                        break;
                    case 8:
                        intent = new Intent(EventList.this, ToastList.class);
                        break;
                    case 9:
                        intent = new Intent(EventList.this, DialogList.class);
                        break;
                    case 10:
                        intent = new Intent(EventList.this, WebView.class);
                        break;
                    default:
                        intent = new Intent(EventList.this, ControlPlane.class);
                }
                startActivity(intent);
            }
        });
    }
}