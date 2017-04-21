package com.samfdl.diy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.samfdl.R;

public class AudioRecord2Wav extends AppCompatActivity {
    AudioRecord2WavUtil audioUtil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diy_audiorecord2wav);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        audioUtil = AudioRecord2WavUtil.getInstance();

        Button start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                audioUtil.startRecord();
                audioUtil.recordData();
                findViewById(R.id.stop).setEnabled(true);
            }
        });
        final Button stop = (Button) findViewById(R.id.stop);
        stop.setEnabled(false);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audioUtil.stopRecord();
                audioUtil.convertWaveFile();
                stop.setEnabled(false);
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