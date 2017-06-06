package com.example.hwanghyewon.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;


public class Level3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);

        TextView textView = (TextView) findViewById(R.id.textView);
        //이걸로 뷰를 생성해서 선언하고
        textView.setText(Integer.toString(makeRandomText()));

        //test라는 아이디를 가짐. 셋텍스트에 보여줄 텍스트를 넣어줌
        // 랜덤으로 뽑은 숫자들은 보여줄 텍스트의 새로운 변수로 생성한다


        Timer timer = new Timer();
        TimerTask myTask = new TimerTask() {
            @Override
            public void run() {
                

            }
        };
    };








    public int makeRandomText() {
        Random random = new Random();

        double val[];
        double realAnswer = 0;
        val = new double[5];

        for (int i = 0; i < 5; i++) {
            int scan = random.nextInt(10);
            val[i] = scan;
        }

        for (int i = 0; i < 5; i++) {
            realAnswer = realAnswer + val[i] * Math.pow(10, val.length - (i + 1));

        }
        return (int) realAnswer;
    };



}


