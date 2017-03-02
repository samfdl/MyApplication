package com.samfdl.diy;

import android.content.Context;
import android.net.Uri;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.samfdl.R;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by samfdl on 2017/2/28.
 */

public class DiyToast1 {
    private Context mContext;

    private Toast toast;
    private View mView;
    private VideoView videoView;

    public int width;
    public int height;

    private boolean isShow = false;

    private Object mTN;
    private Method show;
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams params;

    private int lastX;
    private int lastY;

    public DiyToast1(Context context) {
        this.mContext = context;

        if (toast == null) {
            toast = new Toast(context);
        }
        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflate.inflate(R.layout.diy_diytoast_float_tips, null);

        // 获取界面上VideoView组件
        videoView = (VideoView) mView.findViewById(R.id.video);
        // 创建MediaController对象
        MediaController mController = new MediaController(context);
        String uri = "android.resource://" + context.getPackageName() + "/" + R.raw.pyy;
        videoView.setVideoURI(Uri.parse(uri));
        // 设置videoView与mController建立关联
        videoView.setMediaController(mController);  // ②
        // 设置mController与videoView建立关联
        mController.setMediaPlayer(videoView);  // ③
        // 让VideoView获取焦点
//        videoView.requestFocus();
        videoView.start();
        // 获取界面上VideoView组件
        Button button = (Button) mView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "打电话", Toast.LENGTH_SHORT).show();
            }
        });
        Button back = (Button) mView.findViewById(R.id.move);
        final FrameLayout frameLayout = (FrameLayout) mView.findViewById(R.id.activity_main);
        final FrameLayout.MarginLayoutParams layoutParams = (FrameLayout.MarginLayoutParams) frameLayout.getLayoutParams();
        back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int x = (int) event.getRawX();
                int y = (int) event.getRawY();

                int left, top;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;

                    case MotionEvent.ACTION_MOVE:
                        left = layoutParams.leftMargin + x - lastX;
                        top = layoutParams.topMargin + y - lastY;

                        layoutParams.leftMargin = left;
                        layoutParams.topMargin = top;
                        frameLayout.setLayoutParams(layoutParams);
                        frameLayout.requestLayout();
                        break;
                    case MotionEvent.ACTION_UP:
                        layoutParams.leftMargin = 2000;
                        layoutParams.topMargin = 2000;
                        frameLayout.setLayoutParams(layoutParams);
                        frameLayout.requestLayout();
                        videoView.pause();
                        mWindowManager.removeView(mView);
                        isShow = false;
                        break;
                }
                lastX = x;
                lastY = y;
                return true;
            }
        });

        toast.setView(mView);
    }

    public void show() {
        if (isShow) {
            return;
        }

        try {
            Field tnField = toast.getClass().getDeclaredField("mTN");
            tnField.setAccessible(true);
            mTN = tnField.get(toast);
            show = mTN.getClass().getMethod("show");

            Field tnParamsField = mTN.getClass().getDeclaredField("mParams");
            tnParamsField.setAccessible(true);
            params = (WindowManager.LayoutParams) tnParamsField.get(mTN);
            params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                    | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

            params.width = width;
            params.height = height;

            /**调用tn.show()之前一定要先设置mNextView*/
            Field tnNextViewField = mTN.getClass().getDeclaredField("mNextView");
            tnNextViewField.setAccessible(true);
            tnNextViewField.set(mTN, toast.getView());

            mWindowManager = (WindowManager) mContext.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        toast.setGravity(Gravity.CENTER, 0, 0);
        try {
            show.invoke(mTN);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        isShow = true;
    }
}