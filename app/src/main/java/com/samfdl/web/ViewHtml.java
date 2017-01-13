package com.samfdl.web;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;

import com.samfdl.R;

public class ViewHtml extends AppCompatActivity {
    WebView show;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_webview);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取程序中的WebView组件
        show = (WebView) findViewById(R.id.show);
        StringBuilder sb = new StringBuilder();
        // 拼接一段HTML代码
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> 欢迎您 </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h2> 欢迎您访问<a href=\"http://www.crazyit.org\">"
                + "疯狂Java联盟</a></h2>");
        sb.append("</body>");
        sb.append("</html>");
        // 使用简单的loadData方法会导致乱码，可能是Android API的Bug
        // show.loadData(sb.toString() , "text/html" , "utf-8");
        // 加载、并显示HTML代码
        show.loadDataWithBaseURL(null, sb.toString()
                , "text/html", "utf-8", null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, WebList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}