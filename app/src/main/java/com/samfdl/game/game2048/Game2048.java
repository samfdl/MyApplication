package com.samfdl.game.game2048;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.samfdl.R;
import com.samfdl.game.GameList;
import com.samfdl.game.metalslug.*;

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static com.samfdl.game.game2048.Constant.NUMBERVIEW_SIZE;
import static com.samfdl.game.game2048.Constant.SPACE;
import static com.samfdl.game.metalslug.Constant.STAGE_INIT;

public class Game2048 extends AppCompatActivity {
    private List<Number1> numberList = new ArrayList<Number1>();

    private Number1[][] Numbers = new Number1[4][4];

    private GridView grid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_game2048);
        // 添加返回按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        for (int i = 0; i < 16; i++) {
            Number1 number = new Number1();
            numberList.add(number);
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Numbers[i][j] = new Number1();
            }
        }

        grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(new GridAdapter(this, numberList));

        // 创建GameView组件
        final NumberView numberView = new NumberView(this);
        numberView.setBackgroundColor(R.color.colorAccent);
        FrameLayout.LayoutParams numberViewLP = new FrameLayout.LayoutParams(NUMBERVIEW_SIZE, NUMBERVIEW_SIZE);
        numberViewLP.setMargins(SPACE, SPACE, 0, 0);
        FrameLayout gridLayout = (FrameLayout) findViewById(R.id.gridLayout);
        gridLayout.addView(numberView, numberViewLP);
        gridLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                numberView.onTouchEvent(event);
                return false;
            }
        });
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