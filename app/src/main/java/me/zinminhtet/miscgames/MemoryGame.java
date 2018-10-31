package me.zinminhtet.miscgames;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MemoryGame extends AppCompatActivity {

    private String[] btnNames;

    private Button[] buttons;

    private String[] words;

    private List<String> wordList;

    private Boolean isOneOpen = false;

    private Button chosenButton;

    private ArrayList<Integer> correctButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);

        startGame();


    }

    private void startGame() {

        chosenButton = null;
        isOneOpen = false;
        //initializing buttons
        buttons = new Button[16];
        buttons[0] = findViewById(R.id.btn1);
        buttons[1] = findViewById(R.id.btn2);
        buttons[2] = findViewById(R.id.btn3);
        buttons[3] = findViewById(R.id.btn4);
        buttons[4] = findViewById(R.id.btn5);
        buttons[5] = findViewById(R.id.btn6);
        buttons[6] = findViewById(R.id.btn7);
        buttons[7] = findViewById(R.id.btn8);
        buttons[8] = findViewById(R.id.btn9);
        buttons[9] = findViewById(R.id.btn10);
        buttons[10] = findViewById(R.id.btn11);
        buttons[11] = findViewById(R.id.btn12);
        buttons[12] = findViewById(R.id.btn13);
        buttons[13] = findViewById(R.id.btn14);
        buttons[14] = findViewById(R.id.btn15);
        buttons[15] = findViewById(R.id.btn16);

        // initialize word array
        words = new String[]{"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F", "G", "G", "H", "H"};
        wordList = Arrays.asList(words);
        Collections.shuffle(wordList);

        // declaring the button names
        for (int i = 1; i < 17; i++) {
            buttons[i - 1].setText(wordList.get(i - 1));
            buttons[i - 1].setTextColor(getResources().getColor(R.color.colorTilesText));
        }
    }

    public void btnClick(View view) {
        final Button btn = (Button) view;
        if (!correctButtons.contains(btn.getId())) {

            btn.setTextColor(getResources().getColor(R.color.colorShowTilesText));

            if (isOneOpen) {

                TextView triesTV = findViewById(R.id.tries);
                Integer tries = Integer.parseInt(triesTV.getText().toString());
                tries++;
                triesTV.setText(tries.toString());

                if (btn.getId() == chosenButton.getId()) {
                    btn.setTextColor(getResources().getColor(R.color.colorTilesText));
                    btn.setTextColor(getResources().getColor(R.color.colorTilesText));
                    chosenButton.setTextColor(getResources().getColor(R.color.colorTilesText));
                } else if (btn.getText().equals(chosenButton.getText())) {
                    correctButtons.add(btn.getId());
                    correctButtons.add(chosenButton.getId());

                    TextView marksTV = findViewById(R.id.marks);
                    Integer marks = Integer.parseInt(marksTV.getText().toString());
                    marks++;
                    marksTV.setText(marks.toString());

                    if (correctButtons.size() >= 16) {
                        Toast.makeText(this, "You Win!!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    btn.postDelayed(new Runnable() {
                        public void run() {
                            btn.setTextColor(getResources().getColor(R.color.colorTilesText));
                        }
                    }, 200);
                    chosenButton.setTextColor(getResources().getColor(R.color.colorTilesText));
                }
                chosenButton = null;
                isOneOpen = false;
            } else {
                chosenButton = btn;
                btn.setTextColor(getResources().getColor(R.color.colorShowTilesText));
                isOneOpen = true;
            }


        }
    }

    public void clickRestart(View view) {
        startGame();
    }
}
