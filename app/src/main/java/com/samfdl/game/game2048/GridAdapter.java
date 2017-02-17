package com.samfdl.game.game2048;

import java.lang.*;
import java.lang.Number;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.samfdl.R;

public class GridAdapter extends BaseAdapter {
    private Context context;

    private List<Number1> numberList = new ArrayList<Number1>();

    public GridAdapter(Context context, List<Number1> numberList) {
        this.context = context;
        this.numberList = numberList;
    }

    public int getCount() {
        return numberList.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(
                R.layout.game_game2048_item, null);

        Number1 number = numberList.get(position);
        TextView numberView = (TextView) convertView.findViewById(R.id.number);
        String numberS = "" + number.number;
        if ("0".equals(numberS)) {
            numberS = "";
        }
        numberView.setText(numberS);
        numberView.setBackgroundColor(number.bgColor);
//        numberView.setTextColor(number.textColor);
        numberView.setTextSize(number.textSize);
        return convertView;
    }
}