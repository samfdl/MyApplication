package com.samfdl.game.metalslug;

/**
 * Created by samsung on 2017/2/17.
 */

public class Constant {
    // 代表场景不改变的常量
    public static final int STAGE_NO_CHANGE = 0;
    // 代表初始化场景的常量
    public static final int STAGE_INIT = 1;
    // 代表登录场景的常量
    public static final int STAGE_LOGIN = 2;
    // 代表游戏场景的常量
    public static final int STAGE_GAME = 3;
    // 代表失败场景的常量
    public static final int STAGE_LOSE = 4;
    // 代表退出场景的常量
    public static final int STAGE_QUIT = 99;
    // 代表错误场景的常量
    public static final int STAGE_ERROR = 255;

    // 步骤：初始化
    public static final int INIT = 1;
    // 步骤：逻辑
    public static final int LOGIC = 2;
    // 步骤：清除
    public static final int CLEAN = 3;
    // 步骤：画
    public static final int PAINT = 4;
}