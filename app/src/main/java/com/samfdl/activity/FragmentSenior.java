package com.samfdl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.samfdl.R;

public class FragmentSenior extends AppCompatActivity implements FragmentBookList.Callbacks {
    // 定义一个旗标，用于标识该应用是否支持大屏幕
    private boolean mTwoPane;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 指定加载R.layout.activity_book_list对应的界面布局文件
        // 但实际上该应用会根据屏幕分辨率加载不同的界面布局文件
        setContentView(R.layout.activity_fragmentsenior);
        // 如果加载的界面布局文件中包含ID为book_detail_container的组件
        if (findViewById(R.id.book_detail_container) != null) {
            mTwoPane = true;
            ((FragmentBookList) getFragmentManager()
                    .findFragmentById(R.id.book_list))
                    .setActivateOnItemClick(true);
        }
    }

    @Override
    public void onItemSelected(Integer id) {
        if (mTwoPane) {
            // 创建Bundle，准备向Fragment传入参数
            Bundle arguments = new Bundle();
            arguments.putInt(FragmentBookDetail.ITEM_ID, id);
            // 创建BookDetailFragment对象
            FragmentBookDetail fragment = new FragmentBookDetail();
            // 向Fragment传入参数
            fragment.setArguments(arguments);
            // 使用fragment替换book_detail_container容器当前显示的Fragment
            getFragmentManager().beginTransaction()
                    .replace(R.id.book_detail_container, fragment).commit();
        } else {
            // 创建启动BookDetailActivity的Intent
            Intent detailIntent = new Intent(this, FragmentActivityBookDetail.class);
            // 设置传给BookDetailActivity的参数
            detailIntent.putExtra(FragmentBookDetail.ITEM_ID, id);
            // 启动Activity
            startActivity(detailIntent);
        }
    }
}