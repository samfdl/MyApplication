package com.samfdl.event;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.samfdl.R;

import java.io.File;
import java.util.Locale;

public class Speech extends AppCompatActivity {
    TextToSpeech tts;
    EditText editText;
    Button speech;
    Button record;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_speech);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 初始化TextToSpeech对象
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                // 如果装载TTS引擎成功
                if (status == TextToSpeech.SUCCESS) {
                    Toast.makeText(Speech.this, "TTS成功。", Toast.LENGTH_SHORT).show();
                    // 设置使用美式英语朗读
                    int result = tts.setLanguage(Locale.SIMPLIFIED_CHINESE);
                    // 如果不支持所设置的语言
                    if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE
                            && result != TextToSpeech.LANG_AVAILABLE) {
                        Toast.makeText(Speech.this, "TTS暂时不支持这种语言的朗读。", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Speech.this, "TTS不成功。", Toast.LENGTH_SHORT).show();
                }
            }
        });
        editText = (EditText) findViewById(R.id.txt);
        speech = (Button) findViewById(R.id.speech);
        record = (Button) findViewById(R.id.record);
        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(Speech.this, "TTS开始。v" + editText.getText().toString(), Toast.LENGTH_SHORT).show();
                // 执行朗读
                tts.speak(editText.getText().toString(),
                        TextToSpeech.QUEUE_ADD, null, "speech");
            }
        });
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // 将朗读文本的音频记录到指定文件
                tts.synthesizeToFile(editText.getText().toString(), null,
                        new File("/mnt/sdcard/sound.wav"), "record");
                Toast.makeText(Speech.this, "声音记录成功！"
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onPause() {
        // 关闭TextToSpeech对象
        if (tts != null) {
            tts.shutdown();
        }
        super.onPause();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, EventList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}