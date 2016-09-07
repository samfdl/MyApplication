package com.samfdl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.samfdl.R;
import com.samfdl.ui.UIList;

public class FragmentLifeCycle extends AppCompatActivity {
    Button startActivity, addFragment, backFragment, replaceFragment, finish;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentlifecycle);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        startActivity = (Button) findViewById(R.id.startActivity);
        addFragment = (Button) findViewById(R.id.addFragment);
        backFragment = (Button) findViewById(R.id.backFragment);
        replaceFragment = (Button) findViewById(R.id.replaceFragment);
        finish = (Button) findViewById(R.id.finish);
        // 为startActivity按钮绑定事件监听器
        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                Intent intent = new Intent(FragmentLifeCycle.this, ActivityLifeCycle2.class);
                startActivity(intent);
            }
        });
        // 为addFragment按钮绑定事件监听器
        addFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                FragmentLifeCycleFragment fragment = new FragmentLifeCycleFragment();
                getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        // 为backFragment按钮绑定事件监听器
        backFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                FragmentLifeCycleFragment2 fragment = new FragmentLifeCycleFragment2();
                getFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack("aa")// 将替换前的Fragment添加到Back栈
                        .commit();
            }
        });
        // 为replaceFragment按钮绑定事件监听器
        replaceFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentLifeCycleFragment2 fragment = new FragmentLifeCycleFragment2();
                getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        // 为finish按钮绑定事件监听器
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View source) {
                // 结束该Activity
                FragmentLifeCycle.this.finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, ActivityList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}