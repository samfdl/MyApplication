package com.samfdl.diy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.samfdl.R;

public class Chinese2Spell extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diy_chinese2spell);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final EditText input = (EditText) findViewById(R.id.input);
        final TextView pinyin = (TextView) findViewById(R.id.pinyin);

        Button bn = (Button) findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hanzi = input.getText().toString();
                String pionyin = Chinese2SpellUtil.getPinYin(hanzi);
                pinyin.setText(pionyin);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, DIYList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}