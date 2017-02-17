package com.samfdl.game.game2048;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;

import com.samfdl.R;
import com.samfdl.game.GameList;

import java.util.ArrayList;
import java.util.List;

public class Game2048 extends AppCompatActivity {
    private static final int[] ss = {0, 0, 0, 0, 0, 2, 4, 8, 16, 32, 64, 128,
            256, 512, 1024, 2048};

    private List<Number1> numberList = new ArrayList<Number1>();

    private GridView grid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_game2048);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        for (int i = 0; i < 16; i++) {
            Number1 number = new Number1();
            number.setNumber(ss[i]);
            numberList.add(number);
        }

        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(new GridAdapter(this, numberList));
//        game.setOnTouchListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, GameList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}