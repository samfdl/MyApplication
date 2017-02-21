package com.samfdl.game.game2048;

import com.samfdl.R;

public class Number1 {
    public int number = 0;
    public int bgColor = R.color.game_game2048_bg_null;
    public int textColor = R.color.game_game2048_bg_null;
    public int textSize = 40;

    public void setNumber(int number) {
        this.number = number;
        switch (number) {
            case 0:
                bgColor = R.color.game_game2048_bg_null;
                textSize = 40;
                break;
            case 2:
                bgColor = R.color.game_game2048_bg_2;
                textSize = 40;
                break;
            case 4:
                bgColor = R.color.game_game2048_bg_4;
                textSize = 40;
                break;
            case 8:
                bgColor = R.color.game_game2048_bg_8;
                textSize = 40;
                break;
            case 16:
                bgColor = R.color.game_game2048_bg_16;
                textSize = 40;
                break;
            case 32:
                bgColor = R.color.game_game2048_bg_32;
                textSize = 40;
                break;
            case 64:
                bgColor = R.color.game_game2048_bg_64;
                textSize = 40;
                break;
            case 128:
                bgColor = R.color.game_game2048_bg_128;
                textSize = 30;
                break;
            case 256:
                bgColor = R.color.game_game2048_bg_256;
                textSize = 30;
                break;
            case 512:
                bgColor = R.color.game_game2048_bg_512;
                textSize = 30;
                break;
            case 1024:
                bgColor = R.color.game_game2048_bg_1024;
                textSize = 20;
                break;
            case 2048:
                bgColor = R.color.game_game2048_text_bg;
                textSize = 20;
                break;
            default:
                bgColor = R.color.game_game2048_text_bg;
                textSize = 20;
                break;
        }
    }
}
