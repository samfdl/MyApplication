package com.samfdl.game.game2048;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import static com.samfdl.game.game2048.Constant.MOVE_SPACE;
import static com.samfdl.game.game2048.Constant.SPACE;

/**
 * Created by samsung on 2017/2/20.
 */

public class NumberView extends TextView {
    // 保存当前Android应用的主Context
    private Context mainContext = null;

    private float startx;// down事件发生时，手指相对于view左上角x轴的距离
    private float starty;// down事件发生时，手指相对于view左上角y轴的距离
    private float endx; // move事件发生时，手指相对于view左上角x轴的距离
    private float endy; // move事件发生时，手指相对于view左上角y轴的距离
    private int left; // NumberView左边缘相对于父控件的距离
    private int top; // NumberView上边缘相对于父控件的距离
    private int right; // NumberView右边缘相对于父控件的距离
    private int bottom; // NumberView底边缘相对于父控件的距离
    private int hor; // 触摸情况下，手指在x轴方向移动的距离
    private int ver; // 触摸情况下，手指在y轴方向移动的距离

    public NumberView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public NumberView(Context context) {
        super(context);

        mainContext = context;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(mainContext, "isIdBindingSupport" + event, Toast.LENGTH_SHORT).show();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 手指刚触摸到屏幕的那一刻，手指相对于View左上角水平和竖直方向的距离:startX startY
                startx = event.getX();
                starty = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                // 手指停留在屏幕或移动时，手指相对与View左上角水平和竖直方向的距离:endX endY
                endx = event.getX();
                endy = event.getY();
                // 获取此时刻 View的位置。
                left = getLeft();
                top = getTop();
                right = getRight();
                bottom = getBottom();
                // 手指移动的水平距离
                hor = (int) (endx - startx);
                // 手指移动的竖直距离
                ver = (int) (endy - starty);
                // 当手指在水平或竖直方向上发生移动时，重新设置View的位置（layout方法）
                int move = 0;
                if (Math.abs(hor) > Math.abs(ver)) {
                    if (hor > 0 && left == SPACE) {
                        move = MOVE_SPACE;
                    } else if (hor < 0 && left != SPACE) {
                        move = -MOVE_SPACE;
                    }
                    left += move;
                    right += move;
                } else {
                    if (ver > 0 && top == SPACE) {
                        move = MOVE_SPACE;
                    } else if (ver < 0 && top != SPACE) {
                        move = -MOVE_SPACE;
                    }
                    top += move;
                    bottom += move;
                }
                layout(left, top, right, bottom);
                break;
        }
        return true;
    }
}