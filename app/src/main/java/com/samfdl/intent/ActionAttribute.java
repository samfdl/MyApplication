package com.samfdl.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;

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

        EditText show = (EditText) findViewById(R.id.show);
        // 获取该Activity对应的Intent的Action属性
        String action = getIntent().getAction();
        // 显示Action属性
        show.setText("Action为：" + action);
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