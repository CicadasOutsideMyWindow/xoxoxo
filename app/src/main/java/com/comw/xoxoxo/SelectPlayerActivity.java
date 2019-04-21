package com.comw.xoxoxo;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SelectPlayerActivity {

    String[] players = {"empty", "empty"};

    public String selectCharacter(View view) {
        Log.i("Selected", "name");
        ImageView character = (ImageView) view;
        character.setClickable(false);

        return character.getTag().toString();
    }

//    public String[] setPlayers(String player) {
//
//
//        for (int i=0; i < players.length; i++) {
//            if("empty".equals(players[i])) {
//                player = selectCharacter(view);
//                players[i] = player;
//            }
//        }
//
//
//        return players;
//    }

}
