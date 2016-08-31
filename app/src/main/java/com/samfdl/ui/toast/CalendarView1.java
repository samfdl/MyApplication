package com.samfdl.ui.toast;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.Toast;

import com.samfdl.R;

public class CalendarView1 extends AppCompatActivity {
    CalendarView cv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_toast_calendarview);
        cv = (CalendarView) findViewById(R.id.calendarView);
        // 为CalendarView组件的日期改变事件添加事件监听器
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                // 使用Toast显示用户选择的日期
                Toast.makeText(CalendarView1.this,
                        "你生日是" + year + "年" + month + "月"
                                + dayOfMonth + "日",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}