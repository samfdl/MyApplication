package com.samfdl.ui.listview;

/**
 * Created by Administrator on 2017/8/8.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.samfdl.R;

import java.util.ArrayList;

public class MultiRecyclerViewAdapter extends Adapter<ViewHolder> {
    public static enum ITEM_TYPE {
        ITEM_TYPE_IMAGE, ITEM_TYPE_TEXT
    }

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private ArrayList<String> mTitle;

    public MultiRecyclerViewAdapter(Context context, ArrayList<String> titles) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
        mTitle = titles;
    }

    @Override
    public int getItemCount() {
        return mTitle == null ? 0 : mTitle.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal() : ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).mTextView.setText(mTitle.get(position));

        } else if (holder instanceof ImageViewHolder) {

            ((ImageViewHolder) holder).text.setText(mTitle.get(position));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal()) {
            return new ImageViewHolder(mLayoutInflater.inflate(R.layout.ui_listview_multirecyclerview_item, parent, false));
        } else {
            return new TextViewHolder(mLayoutInflater.inflate(R.layout.ui_listview_multirecyclerview_item2, parent, false));
        }
    }

    public static class TextViewHolder extends ViewHolder {
        protected static final String TAG = "TextViewHolder";

        TextView mTextView;

        public TextViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Log.d(TAG, "TextViewHolder" + getPosition());
                }
            });
        }
    }

    public static class ImageViewHolder extends ViewHolder {
        protected static final String TAG = "ImageViewHolder";

        ImageView mImage;
        TextView text;

        public ImageViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);
            itemView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Log.d(TAG, "ImageViewHolder" + getPosition());
                }
            });
        }
    }
}