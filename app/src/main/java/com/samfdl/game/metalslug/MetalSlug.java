package com.samfdl.game.metalslug;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.samfdl.R;
import com.samfdl.graphics.GraphicsList;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static com.samfdl.game.metalslug.Constant.STAGE_INIT;

public class MetalSlug extends Activity {
    // 定义主布局内的容器：FrameLayout
    public static FrameLayout mainLayout = null;
    // 主布局的布局参数
    public static FrameLayout.LayoutParams mainLP = null;
    // 定义资源管理的核心类
    public static Resources res = null;
    public static MetalSlug mainActivity = null;
    // 定义成员变量记录游戏窗口的宽度、高度
    public static int windowWidth;
    public static int windowHeight;
    // 游戏窗口的主游戏界面
    public static GameView mainView = null;

    // 播放背景音乐的MediaPlayer
    private MediaPlayer player;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainActivity = this;
        res = getResources();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        DisplayMetrics metric = new DisplayMetrics();
        // 获取屏幕高度、宽度
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        windowHeight = metric.heightPixels; // 屏幕高度
        windowWidth = metric.widthPixels; // 屏幕宽度

        // 加载main.xml界面设计文件
        setContentView(R.layout.game_metalslug);
        // 获取main.xml界面设计文件中ID为mainLayout的组件
        mainLayout = (FrameLayout) findViewById(R.id.mainLayout);
        // 创建GameView组件
        mainView = new GameView(this.getApplicationContext(), STAGE_INIT);
        mainLP = new FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
        mainLayout.addView(mainView, mainLP);

        // 播放背景音乐
        player = MediaPlayer.create(this, R.raw.game_metalslug_background);
        player.setLooping(true);
        player.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        // 当游戏暂停时，暂停播放背景音乐
        if (player != null && !player.isPlaying()) {
            player.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        // 当游戏恢复时，如果没有播放背景音乐，开始播放背景音乐
        if (player != null && player.isPlaying()) {
            player.pause();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, GraphicsList.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}