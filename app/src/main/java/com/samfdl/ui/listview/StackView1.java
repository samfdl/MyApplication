package com.samfdl.ui.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import com.samfdl.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackView1 extends AppCompatActivity {
    StackView stackView;
    int[] imageIds = new int[]{
            R.drawable.ui_listview_gridview_bomb5, R.drawable.ui_listview_gridview_bomb6, R.drawable.ui_listview_gridview_bomb7
            , R.drawable.ui_listview_gridview_bomb8, R.drawable.ui_listview_gridview_bomb9, R.drawable.ui_listview_gridview_bomb10
            , R.drawable.ui_listview_gridview_bomb11, R.drawable.ui_listview_gridview_bomb12, R.drawable.ui_listview_gridview_bomb13
            , R.drawable.ui_listview_gridview_bomb14, R.drawable.ui_listview_gridview_bomb15, R.drawable.ui_listview_gridview_bomb16
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_stackview);
        stackView = (StackView) findViewById(R.id.mStackView);
        // 创建一个List对象，List对象的元素是Map
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageIds.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems
                // 使用/layout/cell.xml文件作为界面布局
                , R.layout.ui_listview_gridview_item, new String[]{"image"},
                new int[]{R.id.image1});
        stackView.setAdapter(simpleAdapter);
    }

    public void prev(View view) {
        // 显示上一个组件
        stackView.showPrevious();
    }

    public void next(View view) {
        // 显示下一个组件
        stackView.showNext();
    }
}