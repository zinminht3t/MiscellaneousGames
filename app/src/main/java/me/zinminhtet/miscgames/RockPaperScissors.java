package me.zinminhtet.miscgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RockPaperScissors extends AppCompatActivity {

    private String computerItem;

    private List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        items = new ArrayList<>();
        items.add("Rock");
        items.add("Paper");
        items.add("Scissor");

        startGame();
    }

    private void startGame() {
        ImageView img = findViewById(R.id.imagersp);
        img.setImageDrawable(getResources().getDrawable(R.drawable.rps));
        img.setMaxHeight(200);
        Collections.shuffle(items);
        computerItem = items.get(0);
    }


    public void btnRock(View view) {


        ImageView img = findViewById(R.id.imagersp);

        if(computerItem.equals("Rock")){
            img.setImageDrawable(getResources().getDrawable(R.drawable.rock));

        }
        else if(computerItem.equals("Paper")){
            img.setImageDrawable(getResources().getDrawable(R.drawable.paper));

        }
        else{
            img.setImageDrawable(getResources().getDrawable(R.drawable.scissor));
        }

        Button btnRock = findViewById(R.id.btnRock);
        Button btnPaper = findViewById(R.id.btnPaper);
        Button btnScissor = findViewById(R.id.btnScissor);
        Button btn = (Button) view;

        String humanItem;


        if(btn.getId() == btnRock.getId()){
            humanItem = "Rock";
        }
        else if(btn.getId() == btnPaper.getId()){
            humanItem = "Paper";
        }
        else{
            humanItem = "Scissor";
        }

        if(humanItem.equals(computerItem)){
            Toast.makeText(this, "Same!", Toast.LENGTH_SHORT).show();
        }
        else if(CheckWin(humanItem)){
            TextView humanmark = findViewById(R.id.humanmark);
            Integer currentHumanMark = Integer.parseInt(humanmark.getText().toString());
            currentHumanMark++;
            humanmark.setText(currentHumanMark.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startGame();
            Toast.makeText(this, "You win!", Toast.LENGTH_SHORT).show();
        }
        else{
            TextView computermark = findViewById(R.id.computermark);
            Integer currentComputerMark = Integer.parseInt(computermark.getText().toString());
            currentComputerMark++;
            computermark.setText(currentComputerMark.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startGame();
            Toast.makeText(this, "Computer win!", Toast.LENGTH_SHORT).show();
        }

    }


    public boolean CheckWin(String HumanItem){

        if(!HumanItem.equals(computerItem)){
            return WinItem(computerItem).equals(HumanItem);
        }

        return false;

    }

    public String WinItem(String item){
        switch(item){
            case "Paper":
                return "Scissor";
            case "Rock":
                return "Paper";
            case "Scissor":
                return "Rock";
        }
        return "";
    }
}
