package com.samfdl.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.samfdl.R;

public class ActionAttribute extends AppCompatActivity {
    public final static String CRAZYIT_ACTION =
            "com.samfdl.intent.action.CRAZYIT_ACTION";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_componentattribute);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button bn = (Button) findViewById(R.id.bn);
        bn.setText("启动指定Action、默认Category对应的Activity");
        // 为bn按钮绑定事件监听器
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // 创建Intent对象
                Intent intent = new Intent();
                // 为Intent设置Action属性（属性值就是一个普通字符串）
                intent.setAction(ActionAttribute.CRAZYIT_ACTION);
                startActivity(intent);
            }
        });
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