package com.samfdl.ui.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.samfdl.R;

public class DialogTheme extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_dialog_dialogtheme);
        Button bn = (Button) findViewById(R.id.bn);
        // 为按钮绑定事件监听器
        if (bn != null) {
            bn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // 结束该Activity
                    finish();
                }
            });
        }
    }
}