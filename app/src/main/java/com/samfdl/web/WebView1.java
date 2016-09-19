package com.samfdl.web;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.samfdl.R;

import java.lang.reflect.Method;

public class WebView1 extends AppCompatActivity {
    EditText url;
    Button bn;
    WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_webview);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // 获取页面中文本框、WebView组件
        webView = (WebView) findViewById(R.id.show);
        webView.setWebViewClient(new WebViewClient() {
            // 在点击请求的是链接时才会调用，重写此方法返回true表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边。
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Toast.makeText(WebView1.this, "shouldOverrideUrlLoading: " + url, Toast.LENGTH_SHORT).show();
                return super.shouldOverrideUrlLoading(view, url);
            }

            // 在页面加载开始时调用。
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Toast.makeText(WebView1.this, "onPageStarted: " + url, Toast.LENGTH_SHORT).show();
                super.onPageStarted(view, url, favicon);
            }

            // 在页面加载结束时调用。
            @Override
            public void onPageFinished(WebView view, String url) {
                Toast.makeText(WebView1.this, "onPageFinished: " + url, Toast.LENGTH_SHORT).show();
                super.onPageFinished(view, url);
            }

            // 重写此方法可以让webview处理https请求。未验证
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                Toast.makeText(WebView1.this, "onReceivedSslError: " + url, Toast.LENGTH_SHORT).show();
                super.onReceivedSslError(view, handler, error);
            }

            // 通知应用程序有个自动登录的帐号过程
            @Override
            public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
                Toast.makeText(WebView1.this, "onReceivedLoginRequest: " + url, Toast.LENGTH_SHORT).show();
                super.onReceivedLoginRequest(view, realm, account, args);
            }

            // 当浏览器访问制定的网址发生错误时会通知我们应用程序，比如网络错误。
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Toast.makeText(WebView1.this, "onReceivedError: " + url, Toast.LENGTH_SHORT).show();
                super.onReceivedError(view, request, error);
            }

            // 通知应用程序可以将当前的url存储在数据库中，意味着当前的访问url已经生效并被记录在内核当中。
            // 这个函数在网页加载过程中只会被调用一次。注意网页前进后退并不会回调这个函数。
            @Override
            public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
                Toast.makeText(WebView1.this, "doUpdateVisitedHistory: " + url, Toast.LENGTH_SHORT).show();
                super.doUpdateVisitedHistory(view, url, isReload);
            }
        });
        try {
            //禁用硬件加速
            Method method = WebView.class.getMethod("setLayerType", int.class, Paint.class);
            method.setAccessible(true);
            method.invoke(webView, 1, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                webView.getSettings().setBlockNetworkImage(false);
            }
        }, 1000);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webView.getSettings().setBlockNetworkImage(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setSaveFormData(false);
        webView.getSettings().setLoadsImagesAutomatically(true);
        // http请求的时候，模拟为火狐的UA会造成实时公交那边的页面存在问题，所以模拟iPhone的ua来解决这个问题
        String user_agent = "Mozilla/5.0 (Macintosh; U; PPC Mac OS X; en) AppleWebKit/124 (KHTML, like Gecko) Safari/125.1";
        webView.getSettings().setUserAgentString(user_agent);

        /* Enable zooming */
        webView.getSettings().setSupportZoom(false);
        webView.loadUrl("http://www.yongche.com/touch/index.php");
//        webView.loadUrl("http://xw.qq.com/index.htm");
    }

    // Back 键的按下事件
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
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