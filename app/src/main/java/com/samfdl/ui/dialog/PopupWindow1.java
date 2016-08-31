package com.samfdl.ui.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.samfdl.R;

//有问题，待解决
public class PopupWindow1 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_dialog_popupwindow);
        // 装载R.layout.popup对应的界面布局
        View root = this.getLayoutInflater().inflate(R.layout.ui_dialog_popupwindow_popup, null);
        // 创建PopupWindow对象
        final PopupWindow popup = new PopupWindow(root, 560, 720);
        Button button = (Button) findViewById(R.id.bn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 以下拉方式显示
                // popup.showAsDropDown(v);
                //将PopupWindow显示在指定位置
                popup.showAtLocation(findViewById(R.id.bn),
                        Gravity.CENTER, 20, 20);
            }
        });
        // 获取PopupWindow中的“关闭”按钮
        root.findViewById(R.id.close).setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // 关闭PopupWindow
                        popup.dismiss(); // ①
                    }
                });
    }
}