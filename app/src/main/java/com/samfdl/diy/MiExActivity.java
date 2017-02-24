package com.samfdl.diy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.samfdl.R;

public class MiExActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        Toast.makeText(this,"ddfdfas",Toast.LENGTH_SHORT).show();
        MiExToast miToast = new MiExToast(getApplicationContext());
        miToast.setDuration(MiExToast.LENGTH_ALWAYS);
//        miToast.setAnimations(R.style.anim_view);
        miToast.show();
    }
}