package com.example.hwanghyewon.myapplication;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static com.example.hwanghyewon.myapplication.R.id.textView;


public class Level1Activity extends AppCompatActivity {
    TextView textView;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(Integer.toString(makeRandomText()));
        mHandler.sendEmptyMessage(0);


    }

    //int answer = Integer.parseInt(editText.getText().toString());

    //5초마다 textview에 보이는 숫자가 바뀐다.
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {

            textView.setText(Integer.toString(makeRandomText()));
            mHandler.sendEmptyMessageDelayed(0, 5000);

        }
    };



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
