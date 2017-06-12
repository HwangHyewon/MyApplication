package com.example.hwanghyewon.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

public class Level2Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(Integer.toString(makeRandomText()));
        mHandler.sendEmptyMessage(0);

        mHandler.postDelayed(runnable,5000);
    }

    //5초뒤에 글자가 안보이게 한다.
    Handler mHandler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            textView.setTextColor(WHITE);
            mHandler.sendEmptyMessageDelayed(0,5000);

            };

    };


    public int makeRandomText() {
        Random random = new Random();

        double val[];
        double realAnswer = 0;
        val = new double[4];

        for (int i = 0; i < 4; i++) {
            int scan = random.nextInt(10);
            val[i] = scan;
        }

        for (int i = 0; i < 4; i++) {
            realAnswer = realAnswer + val[i] * Math.pow(10, val.length - (i + 1));

        }
        return (int) realAnswer;
    };

}
