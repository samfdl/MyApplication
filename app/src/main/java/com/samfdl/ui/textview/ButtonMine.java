package com.samfdl.ui.textview;

import android.content.Context;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.Toast;

public class ButtonMine extends Button {
    public ButtonMine(Context context, AttributeSet set) {
        super(context, set);
        System.out.println("ButtonMine");
    }

    // 不明白干啥用的
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("ButtonMineddddddddddddddddddd");
        Toast toast = Toast.makeText(getContext(), "简单的提示信息"
                // 设置该Toast提示信息的持续时间
                , Toast.LENGTH_SHORT);
        toast.show();
        super.onKeyDown(keyCode, event);
        // 返回true，表明该事件不会向外扩散
        return true;
    }
}
