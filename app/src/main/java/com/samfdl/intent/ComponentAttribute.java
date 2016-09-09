package com.samfdl.intent;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;

import com.samfdl.R;

public class ComponentAttribute extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_componentattribute);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EditText show = (EditText) findViewById(R.id.show);
        // 获取该Activity对应的Intent的Component属性
        ComponentName comp = getIntent().getComponent();
        // 显示该ComponentName对象的包名、类名
        show.setText("组件包名为：" + comp.getPackageName()
                + "\n组件类名为：" + comp.getClassName());
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