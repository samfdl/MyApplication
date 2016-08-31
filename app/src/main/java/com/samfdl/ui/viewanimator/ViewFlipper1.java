package com.samfdl.ui.viewanimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ViewFlipper;

import com.samfdl.R;

public class ViewFlipper1 extends AppCompatActivity {
    private ViewFlipper viewFlipper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_viewanimator_viewflipper);
        viewFlipper = (ViewFlipper) findViewById(R.id.details);
    }

    public void prev(View source) {
        viewFlipper.setInAnimation(this, R.anim.ui_viewanimator_viewswitcher_slide_in_right);
        viewFlipper.setOutAnimation(this, R.anim.ui_viewanimator_viewswitcher_slide_out_left);
        // 显示上一个组件
        viewFlipper.showPrevious();
        // 停止自动播放
        viewFlipper.stopFlipping();
    }

    public void next(View source) {
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        // 显示下一个组件
        viewFlipper.showNext();
        // 停止自动播放
        viewFlipper.stopFlipping();
    }

    public void auto(View source) {
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        // 开始自动播放
        viewFlipper.startFlipping();
    }
}