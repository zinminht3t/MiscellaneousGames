package me.zinminhtet.miscgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }

    public void btnCalculate(View view) {

        EditText tiped = findViewById(R.id.tiped);
        EditText totaled = findViewById(R.id.totaled);

        if(tiped.getText().toString() != "" || totaled.getText().toString() != ""){

            Double tip = Double.parseDouble(tiped.getText().toString());
            Integer total = Integer.parseInt(totaled.getText().toString());

            Double resulttip = (total * 0.01) * tip;
            Double resulttotal = total + resulttip;

            TextView tiptv = findViewById(R.id.tiptv);
            TextView totaltv = findViewById(R.id.totaltv);

            tiptv.setText("Tip: $" + resulttip);
            totaltv.setText("Total: $" + resulttotal);
        }

    }
}
