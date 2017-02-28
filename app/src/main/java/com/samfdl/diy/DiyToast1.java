package com.samfdl.diy;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.samfdl.R;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by samfdl on 2017/2/24.
 */

public class DiyToast1 implements View.OnTouchListener {
    private Context mContext;
    private Toast toast;

    private View mView;
    int width;
    int height;
    private boolean isShow = false;

    private Object mTN;
    private Method show;
    private WindowManager mWM;
    private WindowManager.LayoutParams params;

    public DiyToast1(Context context, int width, int height) {
        this.mContext = context;
        this.width = width;
        this.height = height;
        if (toast == null) {
            toast = new Toast(mContext);
        }
        LayoutInflater inflate = (LayoutInflater)
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflate.inflate(R.layout.diy_diytoast_float_tips, null);

        // 获取界面上VideoView组件
        VideoView videoView = (VideoView) mView.findViewById(R.id.video);
        // 创建MediaController对象
        MediaController mController = new MediaController(mContext);
        String uri = "android.resource://" + mContext.getPackageName() + "/" + R.raw.pyy;
        videoView.setVideoURI(Uri.parse(uri));
        // 设置videoView与mController建立关联
        videoView.setMediaController(mController);  // ②
        // 设置mController与videoView建立关联
        mController.setMediaPlayer(videoView);  // ③
        // 让VideoView获取焦点
        videoView.requestFocus();
        videoView.start();
        // 获取界面上VideoView组件
        Button button = (Button) mView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "打电话", Toast.LENGTH_SHORT).show();
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

            mWM = (WindowManager) mContext.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            mWM.updateViewLayout(toast.getView(), params);  //刷新显示
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

    private float mTouchStartX;
    private float mTouchStartY;
    private float x;
    private float y;

    private void updateViewPosition() {
        //更新浮动窗口位置参数
        params.x = (int) (x - mTouchStartX);
        params.y = (int) (y - mTouchStartY);
        mWM.updateViewLayout(toast.getView(), params);  //刷新显示
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //获取相对屏幕的坐标，即以屏幕左上角为原点
        x = event.getRawX();
        y = event.getRawY();
        Log.i("currP", "currX" + x + "====currY" + y);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:    //捕获手指触摸按下动作
                //获取相对View的坐标，即以此View左上角为原点
                mTouchStartX = event.getX();
                mTouchStartY = event.getY();
                Log.i("startP", "startX" + mTouchStartX + "====startY" + mTouchStartY);
                break;
            case MotionEvent.ACTION_MOVE:   //捕获手指触摸移动动作
                updateViewPosition();
                break;
            case MotionEvent.ACTION_UP:    //捕获手指触摸离开动作
                updateViewPosition();
                break;
        }
        return true;
    }
}