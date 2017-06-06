package com.example.hwanghyewon.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class Level5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level5);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(Integer.toString(makeRandomText()));
    }


    public int makeRandomText() {
        Random random = new Random();

        double val[];
        double realAnswer = 0;
        val = new double[8];

        for (int i = 0; i < 8; i++) {
            int scan = random.nextInt(10);
            val[i] = scan;
        }

        for (int i = 0; i < 8; i++) {
            realAnswer = realAnswer + val[i] * Math.pow(10, val.length - (i + 1));

        }
        return (int) realAnswer;
    };

}
