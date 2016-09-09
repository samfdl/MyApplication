package com.samfdl.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class DataTypeAttributeSchemeHostPortPath extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tv = new TextView(this);
        tv.setText("指定Scheme、Host、Port、Path匹配的Activity");
        tv.setTextSize(30);
        setContentView(tv);
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