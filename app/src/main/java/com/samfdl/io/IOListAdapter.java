package com.samfdl.io;

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
 * Created by samfdl on 2016/12/7.
 */
public class IOListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;//得到一个LayoutInfalter对象用来导入布局

    public IOListAdapter(Context context) {
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
        listItem.add("参数存储 SharedPreferences");
        listItem.add("文件 File");
        listItem.add("SD卡存储");
        listItem.add("SD卡文件浏览器");
        listItem.add("Database 数据库");
        listItem.add("英文生词本 DatabaseHelper");
        listItem.add("第一个 Resolver");
        listItem.add("英文生词本 ContentProvider");
        listItem.add("访问系统联系人");
        return listItem;
    }
}