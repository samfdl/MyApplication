package com.samfdl.graphics;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.samfdl.R;

import java.util.ArrayList;

/**
 * Created by samfdl on 2016/9/08.
 */
public class GraphicsListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;//得到一个LayoutInfalter对象用来导入布局

    public GraphicsListAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return getData().size();//返回数组的长度
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //观察convertView随ListView滚动情况
        Log.v("MyListViewBase", "getView " + position + " " + convertView);
        if (convertView == null) {
            //如果写成这样，就会造成layout 设置行高失效
            //view = mInflater.inflate(R.layout.list_item_, null);
            convertView = mInflater.inflate(R.layout.ui_listview_arrayadapter_item, parent, false);
            holder = new ViewHolder();
            /**得到各个控件的对象*/
            holder.title = (TextView) convertView.findViewById(R.id.TextView);
            convertView.setTag(holder);//绑定ViewHolder对象
        } else {
            holder = (ViewHolder) convertView.getTag();//取出ViewHolder对象
        }
        /**设置TextView显示的内容，即我们存放在动态数组中的数据*/
        holder.title.setText(getData().get(position));

        return convertView;
    }

    /**
     * 存放控件
     */
    public final class ViewHolder {
        public TextView title;
    }

    /**
     * 添加一个得到数据的方法，方便使用
     */
    private ArrayList<String> getData() {
        /**为动态数组添加数据*/
        ArrayList<String> listItem = new ArrayList<>();
        listItem.add("Bitmap");
        listItem.add("Canvas");
        listItem.add("Path");
        listItem.add("PathText");
        listItem.add("画图板");
        listItem.add("弹球游戏");
        listItem.add("图片倾斜");
        listItem.add("移动游戏背景");
        listItem.add("可揉动的图片");
        listItem.add("使用 Shader 填充图形");
        listItem.add("逐帧动画 熊猫");
        listItem.add("逐帧动画 在指定点爆炸");
        listItem.add("补间动画 旋转的花");
        listItem.add("蝴蝶飞舞");
        listItem.add("自定义补间动画");
        listItem.add("ObjectAnimator属性动画");
        listItem.add("大珠小珠落玉盘");
        listItem.add("鱼儿水中游");
        return listItem;
    }
}