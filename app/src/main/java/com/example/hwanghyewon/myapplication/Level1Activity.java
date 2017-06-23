package com.example.hwanghyewon.myapplication;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.WHITE;
import static com.example.hwanghyewon.myapplication.R.id.edit_query;
import static com.example.hwanghyewon.myapplication.R.id.textView;


public class Level1Activity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Handler mHandler;
    public int score;
    public int realAnswer;
    public int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);

        realAnswer = makeRandomText();
        textView.setText(Integer.toString(realAnswer));
        mHandler = new Handler();

        mHandler.sendEmptyMessage(0);

        mHandler.postDelayed(runnable,1000);
        mHandler.postDelayed(runnable2,6000);

        mHandler.postDelayed(runnable,7000);
        mHandler.postDelayed(runnable2,12000);

        mHandler.postDelayed(runnable,13000);
        mHandler.postDelayed(runnable2,18000);

        mHandler.postDelayed(runnable,19000);
        mHandler.postDelayed(runnable2,24000);

        mHandler.postDelayed(runnable,25000);
        mHandler.postDelayed(runnable3,26000);

    };


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                textView.setTextColor(WHITE);
            };
        };

     Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            compareAnswer();
            realAnswer = makeRandomText();
            textView.setText(Integer.toString(realAnswer));
            textView.setTextColor(BLACK);
        }
    };
    Runnable runnable3 = new Runnable() {
        @Override
        public void run() {
            textView.setTextColor(WHITE);
            if(score<5){
                String val = Integer.toString(score);
                Toast.makeText(getApplicationContext(),"L O S E!\nYour Score: "+val,Toast.LENGTH_LONG).show();
            }
            else{

            }
        }
    };


    private int compareAnswer(){
        answer = Integer.parseInt(editText.getText().toString());
        if(answer == realAnswer){
            score ++;
            String val = Integer.toString(score);
            Toast.makeText(getApplicationContext(),"맞았습니다\nCurrent Score: "+val,Toast.LENGTH_SHORT).show();
            return 1;
        }
        else{
            String val = Integer.toString(score);
            Toast.makeText(getApplicationContext(),"틀렸습니다\nCurrent Score: " +val,Toast.LENGTH_SHORT).show();
            return 0;
        }
    }


    public int makeRandomText() {
        Random random = new Random();

        double val[];
        double realAnswer = 0;
        val = new double[3];

        for (int i = 0; i < 3; i++) {
            int scan = random.nextInt(10);
            val[i] = scan;
        }

        for (int i = 0; i < 3; i++) {
            realAnswer = realAnswer + val[i] * Math.pow(10, val.length - (i + 1));

        }
        return (int) realAnswer;
    };

}
