package com.samfdl.hardware;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.samfdl.R;

import java.util.List;

public class LocationProviders extends AppCompatActivity {
    ListView providers;
    LocationManager lm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hardware_locationproviders);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        providers = (ListView) findViewById(R.id.providers);
        // 获取系统的LocationManager对象
        lm = (LocationManager) getSystemService(
                Context.LOCATION_SERVICE);
        // 获取系统所有的LocationProvider的名称
        List<String> providerNames = lm.getAllProviders();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                providerNames);
        // 使用ListView来显示所有可用的LocationProvider
        providers.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, HardwareList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}