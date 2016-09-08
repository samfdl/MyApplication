package com.samfdl.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.samfdl.R;

public class ComponentAttribute extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_componentattribute);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button bn = (Button) findViewById(R.id.bn);
        // 为bn按钮绑定事件监听器
        if (bn != null) {
            bn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // 创建一个ComponentName对象
                    ComponentName comp = new ComponentName(ComponentAttribute.this,
                            ComponentAttribute2.class);
                    Intent intent = new Intent();
                    // 为Intent设置Component属性
                    intent.setComponent(comp);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, IntentList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}