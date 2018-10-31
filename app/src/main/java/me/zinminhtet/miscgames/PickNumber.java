package me.zinminhtet.miscgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class PickNumber extends AppCompatActivity {

    private Integer theNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_number);
        generateRandom();
    }

    public void generateRandom(){
        TextView hint = findViewById(R.id.textHint);
        hint.setText("##");
        Random r = new Random();
        theNumber = r.nextInt(1000);
        Log.i("Number", theNumber.toString());
    }

    public void btnGo(View view) {
        EditText userInput = findViewById(R.id.userInput);
        Integer userInputInt = Integer.parseInt(userInput.getText().toString());
        TextView hint = findViewById(R.id.textHint);

        if(userInputInt.equals(theNumber)){
            Toast.makeText(this, "You are right!", Toast.LENGTH_LONG).show();
            generateRandom();
        }
        else if(userInputInt > theNumber){
            hint.setText("Lower!!");
        }
        else{
            hint.setText("Higher!!");
        }
    }
}
