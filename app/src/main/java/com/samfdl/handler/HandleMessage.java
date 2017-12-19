package com.samfdl.handler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.samfdl.R;
import com.samfdl.graphics.GraphicsList;

public class HandleMessage extends AppCompatActivity implements View.OnClickListener {
    private Button button;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), "1", 1).show();
//            return false;
            // 置为true， 则下面的那个handleMessage不会再收到消息，不会再弹2toast
            return true;
        }
    }) {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), "2", 1).show();
        }
    };

    @Override
    public void onClick(View v) {
        handler.sendEmptyMessage(1);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_post);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);
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