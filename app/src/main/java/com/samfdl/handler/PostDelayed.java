package com.samfdl.handler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.samfdl.R;
import com.samfdl.graphics.GraphicsList;

public class PostDelayed extends AppCompatActivity {
    private ImageView imageView;

    private int[] images = {R.drawable.ui_listview_adapterviewflipper_baiyang,
            R.drawable.ui_listview_adapterviewflipper_sheshou,
            R.drawable.ui_listview_adapterviewflipper_shuangyu};

    private int index;

    private Handler handler = new Handler();
    private MyRunnable myRunnable = new MyRunnable();

    class MyRunnable implements Runnable {
        @Override
        public void run() {
            index++;
            index = index % 3;
            imageView.setImageResource(images[index]);
            handler.postDelayed(myRunnable, 1000);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handler_post);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = (ImageView) findViewById(R.id.imageView2);

        handler.postDelayed(myRunnable, 1000);
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