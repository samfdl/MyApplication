package com.samfdl.res;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.samfdl.R;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class XmlRes1 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_asynctask);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取bn按钮，并为该按钮绑定事件监听器
        Button bn = (Button) findViewById(R.id.bn);
        if (bn != null) {
            bn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    // 根据XML资源的ID获取解析该资源的解析器
                    // XmlResourceParser是XmlPullParser的子类
                    XmlResourceParser xrp = getResources().getXml(R.xml.res_xmlres_books);
                    try {
                        StringBuilder sb = new StringBuilder("");
                        // 还没有到XML文档的结尾处
                        while (xrp.getEventType()
                                != XmlResourceParser.END_DOCUMENT) {
                            // 如果遇到了开始标签
                            if (xrp.getEventType() ==
                                    XmlResourceParser.START_TAG) {
                                // 获取该标签的标签名
                                String tagName = xrp.getName();
                                // 如果遇到book标签
                                if (tagName.equals("book")) {
                                    // 根据属性名来获取属性值
                                    String bookName = xrp
                                            .getAttributeValue(null, "price");
                                    sb.append("价格：");
                                    sb.append(bookName);
                                    // 根据属性索引来获取属性值
                                    String bookPrice = xrp
                                            .getAttributeValue(1);
                                    sb.append("	出版日期：");
                                    sb.append(bookPrice);
                                    sb.append(" 书名：");
                                    // 获取文本节点的值
                                    sb.append(xrp.nextText());
                                }
                                sb.append("\n");
                            }
                            // 获取解析器的下一个事件
                            xrp.next(); // ①
                        }
                        TextView show = (TextView) findViewById(R.id.show);
                        show.setText(sb.toString());
                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, ResList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}