package com.samfdl.ui.progressbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.samfdl.R;

public class RatingBar1 extends AppCompatActivity {
    ImageView image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_progressbar_ratingbar);
        image = (ImageView) findViewById(R.id.image);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            // 当星级评分条的评分发生改变时触发该方法
            @Override
            public void onRatingChanged(RatingBar arg0, float rating,
                                        boolean fromUser) {
                // 动态改变图片的透明度，其中255是星级评分条的最大值
                // 5个星星就代表最大值255
                image.setImageAlpha((int) (rating * 255 / 5));
            }
        });
    }
}