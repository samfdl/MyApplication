package com.samfdl.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.samfdl.R;

public class Fragment1 extends AppCompatActivity implements FragmentBookList.Callbacks {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    // 实现Callbacks接口必须实现的方法
    @Override
    public void onItemSelected(Integer id) {
        // 创建Bundle，准备向Fragment传入参数
        Bundle arguments = new Bundle();
        arguments.putInt(FragmentBookDetail.ITEM_ID, id);
        // 创建BookDetailFragment对象
        FragmentBookDetail fragment = new FragmentBookDetail();
        // 向Fragment传入参数
        fragment.setArguments(arguments);
        // 使用fragment替换book_detail_container容器当前显示的Fragment
        getFragmentManager().beginTransaction()
                .replace(R.id.book_detail_container, fragment)
                .commit();  // ①
    }
}