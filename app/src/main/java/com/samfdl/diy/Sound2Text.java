package com.samfdl.diy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.samfdl.R;

public class Sound2Text extends AppCompatActivity implements View.OnClickListener {
    private EditText mResultText;
    private SoundToText mSoundToText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diy_sound2text);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.iat_recognize).setOnClickListener(this);
        mResultText = ((EditText) findViewById(R.id.iat_text));

        mSoundToText = new SoundToText(this, mResultText);
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

    @Override
    public void onClick(View v) {
        mSoundToText.begin();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSoundToText.finish();
    }
}