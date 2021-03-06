package com.samfdl.res;

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
 * Created by samfdl on 2016/9/11.
 */
public class ResListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;//得到一个LayoutInfalter对象用来导入布局

    public ResListAdapter(Context context) {
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
        listItem.add("颜色、尺寸资源");
        listItem.add("数组资源");
        listItem.add("颜色状态列表 selector");
        listItem.add("卷轴 ClipDrawable");
        listItem.add("AnimationDrawable");
        listItem.add("属性动画");
        listItem.add("原始 XML 资源");
        listItem.add("主题资源");
        listItem.add("属性资源");
        listItem.add("使用原生资源 raw asserts");
        listItem.add("国际化资源");
        listItem.add("Dpi");
        listItem.add("自适应屏幕尺寸");
        return listItem;
    }
}