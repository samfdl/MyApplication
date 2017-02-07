package com.samfdl;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by samsung on 2016/8/24.
 */
public class AllListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;//得到一个LayoutInfalter对象用来导入布局

    public AllListAdapter(Context context) {
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
        listItem.add("Activity 和 Fragment");
        listItem.add("界面 UI 控件");
        listItem.add("Service 后台进程");
        listItem.add("事件处理 Event");
        listItem.add("Intent 通信");
        listItem.add("资源 Res");
        listItem.add("数据存储");
        listItem.add("图形和动画");
        listItem.add("OpenGL");
        listItem.add("多媒体");
        listItem.add("硬件设备");
        listItem.add("网络");
        listItem.add("电话短信功能");
        listItem.add("手机桌面");
        listItem.add("自定义控件");
        listItem.add("地图服务");
        listItem.add("游戏 合金弹头");
        return listItem;
    }
}