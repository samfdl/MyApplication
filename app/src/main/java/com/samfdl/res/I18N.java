package com.samfdl.res;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.samfdl.R;

public class I18N extends AppCompatActivity {
    TextView tvShow;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.res_i18n);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvShow = (TextView) findViewById(R.id.show);
        // 设置文本框所显示的文本
//        tvShow.setText(R.string.res_i18n_msg);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, ResList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}