package com.samfdl.ui.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.samfdl.R;

public class AdapterViewFlipper1 extends AppCompatActivity {
    int[] imageIds = new int[]{R.drawable.ui_listview_adapterviewflipper_shuangzi, R.drawable.ui_listview_adapterviewflipper_shuangyu, R.drawable.ui_listview_adapterviewflipper_chunv, R.drawable.ui_listview_adapterviewflipper_tiancheng,
            R.drawable.ui_listview_adapterviewflipper_tianxie, R.drawable.ui_listview_adapterviewflipper_sheshou, R.drawable.ui_listview_adapterviewflipper_juxie, R.drawable.ui_listview_adapterviewflipper_shuiping, R.drawable.ui_listview_adapterviewflipper_shizi,
            R.drawable.ui_listview_adapterviewflipper_baiyang, R.drawable.ui_listview_adapterviewflipper_jinniu, R.drawable.ui_listview_adapterviewflipper_mojie};
    private AdapterViewFlipper flipper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_adapterviewflipper);
        flipper = (AdapterViewFlipper) findViewById(R.id.flipper);
        // 创建一个BaseAdapter对象，该对象负责提供Gallery所显示的列表项
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            // 该方法返回的View代表了每个列表项
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // 创建一个ImageView
                ImageView imageView = new ImageView(AdapterViewFlipper1.this);
                imageView.setImageResource(imageIds[position]);
                // 设置ImageView的缩放类型
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                // 为imageView设置布局参数
                imageView.setLayoutParams(
                        new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(adapter);
    }

    public void prev(View source) {
        // 显示上一个组件
        flipper.showPrevious();
        // 停止自动播放
        flipper.stopFlipping();
    }

    public void next(View source) {
        // 显示下一个组件。
        flipper.showNext();
        // 停止自动播放
        flipper.stopFlipping();
    }

    public void auto(View source) {
        // 开始自动播放
        flipper.startFlipping();
    }
}