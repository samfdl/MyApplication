package com.samfdl.activity;

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
 * Created by samsung on 2016/8/24.
 */
public class ActivityListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;//得到一个LayoutInfalter对象用来导入布局

    public ActivityListAdapter(Context context) {
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
        listItem.add("LauncherActivity");
        listItem.add("ExpandableListActivity");
        listItem.add("PreferenceActivity");
        listItem.add("启动 Activity");
        listItem.add("Bundle 传递注册信息");
        listItem.add("Start Activity for result");
        listItem.add("Activity 生命周期");
        listItem.add("标准加载模式");
        listItem.add("SingleTop 栈顶单例模式");
        listItem.add("SingleTask Task内单例模式");
        listItem.add("SingleInstance 全局单例模式");
        listItem.add("隐式Intent");
        listItem.add("Fragment");
        listItem.add("Fragment 兼顾屏幕分辨率");
        listItem.add("Fragment 生命周期");
        return listItem;
    }
}