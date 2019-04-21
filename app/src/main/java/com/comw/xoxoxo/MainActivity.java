package com.comw.xoxoxo;

import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// START NEW GAME

/*
0. Empty
1. Open the player selection menu;
2. Select players;
3. Pass players to following view
 */

public class MainActivity extends AppCompatActivity {

    private ViewPager slideViewPager;
    private LinearLayout slideDots;
    private SliderAdapter sliderAdapter;

    String playerOne;
    String playerTwo;

    String winner = "";
    boolean gameActive = true;
    String[] boardState = {"empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty", "empty"};
    int winningCombos[][] = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    static List<String> players = new ArrayList<>();
    int counter = 1;

    public void selectCharacter(View view) {

        //TODO: Limit # of players to two

        Log.i("Selected", "name");
        ImageView character = (ImageView) view;
        character.setClickable(false);
        String player = character.getTag().toString();

        players.add(player);
        Log.i("Players", Arrays.toString(players.toArray()));
        if(players.size() == 2) {
            setContentView(R.layout.activity_main);
        }
    }

    public void dropPinIn (View view) {

        Log.i("onClick", "Clicked");
        ImageView pin = (ImageView) view;
        pin.setTranslationY(-1500);
        int tappedSpace = Integer.parseInt(pin.getTag().toString());

        playerOne = players.get(0);
        playerTwo = players.get(1);
        String currentPlayer;

        if(boardState[tappedSpace].equals("empty") && gameActive) {
//            if(playerOne.equals(currentPlayer)) {
            if(counter%2 == 0) {
                currentPlayer = playerTwo;
                switch(playerTwo) {
                    case "bubbles":
                        pin.setImageResource(R.drawable.bubbles);
                        break;
                    case "zee":
                        pin.setImageResource(R.drawable.zee);
                        break;
                    case "newt":
                        pin.setImageResource(R.drawable.newt);
                        break;
                    case "fuse":
                        pin.setImageResource(R.drawable.fuse);
                        break;
//                case "zee":
//                    pin.setImageResource(R.drawable.zee);
//                    break;
//                case "zee":
//                    pin.setImageResource(R.drawable.zee);
//                    break;
//                case "zee":
//                    pin.setImageResource(R.drawable.zee);
//                    break;
                }
                pin.animate().translationYBy(1500).setDuration(300);
                boardState[tappedSpace] = currentPlayer;
//                currentPlayer = playerOne;
            } else {
                currentPlayer = playerOne;
                switch(playerOne) {
                    case "bubbles":
                        pin.setImageResource(R.drawable.bubbles);
                        break;
                    case "zee":
                        pin.setImageResource(R.drawable.zee);
                        break;
                    case "newt":
                        pin.setImageResource(R.drawable.newt);
                        break;
                    case "fuse":
                        pin.setImageResource(R.drawable.fuse);
                        break;
//                case "zee":
//                    pin.setImageResource(R.drawable.zee);
//                    break;
//                case "zee":
//                    pin.setImageResource(R.drawable.zee);
//                    break;
//                case "zee":
//                    pin.setImageResource(R.drawable.zee);
//                    break;
                }
                pin.animate().translationYBy(1500).setDuration(300);
                boardState[tappedSpace] = currentPlayer;
//                currentPlayer = playerTwo;
            }

//            boardState[tappedSpace] = currentPlayer;
            counter ++;
            Log.i("gameBoard", Arrays.toString(boardState));
//            pin.animate().translationYBy(1500).setDuration(300);
            for (int[] winningCombo : winningCombos) {
                if (boardState[winningCombo[0]] == boardState[winningCombo[1]] && boardState[winningCombo[1]] == boardState[winningCombo[2]] && !boardState[winningCombo[0]].equals("empty")) {
                    gameActive = false;

                    if (playerTwo.equals(currentPlayer)) {
                        winner = playerOne;
                    } else {
                        winner = playerTwo;
                    }
                    Toast.makeText(this, String.format("The winner is %s", winner), Toast.LENGTH_SHORT).show();
                    Button playAgain = findViewById(R.id.playAgainButton);
                    playAgain.setVisibility(View.VISIBLE);
                }
            }
        }

    }

//    public void startNewGame (View view) {
//        Button playAgain = findViewById(R.id.playAgainButton);
//        playAgain.setVisibility(View.INVISIBLE);
//        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);
//
//        for(int i = 0; i < gridLayout.getChildCount(); i++){
//            ImageView child = (ImageView) gridLayout.getChildAt(i);
//            child.setImageDrawable(null);
//        }
//        player = "x";
//        gameActive = true;
//        for(int i = 0; i < boardState.length; i++) {
//            boardState[i] = "empty";
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.slide_layout);
        slideViewPager = findViewById(R.id.slideViewPager);
        slideDots = findViewById(R.id.slideDots);

        sliderAdapter = new SliderAdapter(this);
        slideViewPager.setAdapter(sliderAdapter);
    }
}
