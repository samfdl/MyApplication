package com.samfdl.handler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.samfdl.R;
import com.samfdl.graphics.GraphicsList;

public class PostRunnable extends AppCompatActivity {
    private TextView textView;
    private Handler handler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_post);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView = (TextView) findViewById(R.id.textView2);

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("Runnable");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, GraphicsList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}