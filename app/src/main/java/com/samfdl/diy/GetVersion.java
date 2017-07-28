package com.samfdl.diy;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.samfdl.R;

public class GetVersion extends AppCompatActivity implements View.OnClickListener {
    private TextView version = null;
    private Button getAPP = null;
    private Button getSystem = null;
    private static final String TAG = "MainActivity";
    private static int clickCount = 0;//点击左边按钮的次数

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diy_getversion);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();

        getAPP.setOnClickListener(this);
        getSystem.setOnClickListener(this);
    }

    private void initView() {
        version = (TextView) findViewById(R.id.version);
        getAPP = (Button) findViewById(R.id.get_app);
        getSystem = (Button) findViewById(R.id.get_system);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_app:
                clickCount++;
                if (clickCount % 2 != 0) {
                    getAPPVersion();
                } else {
                    getCustomVersion();
                }
                break;

            case R.id.get_system:
                getSystemVersion();
                break;

            default:
                break;
        }
    }

    /**
     * 获取系统版本号
     */
    private void getSystemVersion() {
//		int sysVersion = android.os.Build.VERSION.SDK_INT;//获取sdk平台值,如19
        String sysVersion = android.os.Build.VERSION.RELEASE;//获取系统版本，如4.0.2

        Log.d(TAG, "sysVersion=" + sysVersion);
        setVersion(getString(R.string.diy_sys_version) + ":" + String.valueOf(sysVersion));
    }

    /**
     * 获取软件版本号
     */
    private void getAPPVersion() {
        PackageManager pm = this.getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo(this.getPackageName(), 0);
            int appVersion = pi.versionCode;
            Log.d(TAG, "appVersion=" + appVersion);
            setVersion(getString(R.string.diy_app_version) + ":" + String.valueOf(appVersion));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.e(TAG, "getAppVersion:" + e.getCause());
        }
    }

    /**
     * 获取自定义在meta-data节点下的版本号
     */
    private void getCustomVersion() {
        PackageManager pm = this.getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo(this.getPackageName(), 0);
            String appVersion = pi.versionName;
            Log.d(TAG, "appVersion=" + appVersion);
            setVersion(getString(R.string.diy_app_version) + ":" + String.valueOf(appVersion));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            Log.e(TAG, "getAppVersion:" + e.getCause());
        }
//        try {
//            ApplicationInfo ai = pm.getApplicationInfo(this.getPackageName(), PackageManager.GET_META_DATA);
//            String customVersion = ai.metaData.getString("SYSTEM_VERSION");
//            setVersion(getString(R.string.app_version) + ":" + customVersion);
//        } catch (NameNotFoundException e) {
//            e.printStackTrace();
//            Log.e(TAG, "getCustomVersion:" + e.getCause());
//        }
    }

    /**
     * 设置版本号
     *
     * @param ver 版本号
     */
    private void setVersion(String ver) {
        if (ver != null && (!"".equals(ver))) {
            version.setText(ver);
        } else {
            version.setText(getString(R.string.diy_error));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, DIYList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}