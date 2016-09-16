package com.samfdl.res;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.samfdl.R;

public class AnimationDrawable1 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.res_animationdrawable);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ImageView image = (ImageView) findViewById(R.id.image);
        // 加载动画资源
        final Animation anim = AnimationUtils.loadAnimation(this,
                R.anim.res_animationdrawable_my_anim);
        // 设置动画结束后保留结束状态
        anim.setFillAfter(true); // ①
        Button bn = (Button) findViewById(R.id.bn);
        if (bn != null) {
            bn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // 开始动画
                    image.startAnimation(anim);
                }
            });
        }
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