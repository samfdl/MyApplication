package com.samfdl.res;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.samfdl.R;

public class PropertyAnimation extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_actionbar_tabnav);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        // 添加MyAnimationView组件
        container.addView(new MyAnimationView(this));
    }

    public class MyAnimationView extends View {
        public MyAnimationView(Context context) {
            super(context);
            // 加载动画资源
            ObjectAnimator colorAnim = (ObjectAnimator) AnimatorInflater
                    .loadAnimator(PropertyAnimation.this, R.animator.res_propertyanimation_color_anim);
            colorAnim.setEvaluator(new ArgbEvaluator());
            // 对该View本身应用属性动画
            colorAnim.setTarget(this);
            // 开始指定动画
            colorAnim.start();
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