package com.samfdl.ui.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.samfdl.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridView1 extends AppCompatActivity {
    GridView grid;
    ImageView imageView;
    int[] imageIds = new int[]{R.drawable.ui_listview_gridview_bomb5, R.drawable.ui_listview_gridview_bomb6, R.drawable.ui_listview_gridview_bomb7, R.drawable.ui_listview_gridview_bomb8,
            R.drawable.ui_listview_gridview_bomb9, R.drawable.ui_listview_gridview_bomb10, R.drawable.ui_listview_gridview_bomb11, R.drawable.ui_listview_gridview_bomb12, R.drawable.ui_listview_gridview_bomb13,
            R.drawable.ui_listview_gridview_bomb14, R.drawable.ui_listview_gridview_bomb15, R.drawable.ui_listview_gridview_bomb16};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_gridview);
        // 创建一个List对象，List对象的元素是Map
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < imageIds.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        // 获取显示图片的ImageView
        imageView = (ImageView) findViewById(R.id.imageView);
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems
                // 使用/layout/cell.xml文件作为界面布局
                , R.layout.ui_listview_gridview_item, new String[]{"image"}, new int[]{R.id.image1});
        grid = (GridView) findViewById(R.id.grid01);
        // 为GridView设置Adapter
        grid.setAdapter(simpleAdapter);
        // 添加列表项被选中的监听器
        grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 显示当前被选中的图片
                imageView.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // 添加列表项被单击的监听器
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 显示被单击的图片
                imageView.setImageResource(imageIds[position]);
            }
        });
    }
}