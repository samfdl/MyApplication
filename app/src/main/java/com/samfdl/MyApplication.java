package com.samfdl;

import android.app.Application;
import android.util.Log;

import com.iflytek.cloud.SpeechUtility;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by samfdl on 2017/4/3.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("mytoken", "ddd");
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.d("mytoken", deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
            }
        });

        SpeechUtility.createUtility(this, "appid=58eb1bc6");
    }
}