package com.example.hwanghyewon.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

public class Level6Activity extends MemorizationGame{

    private TextView textView;
    private EditText editText;
    private Handler mHandler;
    private int realAnswer;
    private int answer;
    private int score = 25;

    @Override
    public void onBackPressed(){
        Toast.makeText(getApplicationContext(),"게임 중에는 나갈 수 없습니다 ",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level6);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);

        realAnswer = makeRandomText(10);
        textView.setText(Integer.toString(realAnswer));
        mHandler = new Handler();

        mHandler.sendEmptyMessage(0);

        mHandler.postDelayed(runnable,4000);
        mHandler.postDelayed(runnable2,10000);

        mHandler.postDelayed(runnable,14000);
        mHandler.postDelayed(runnable2,20000);

        mHandler.postDelayed(runnable,24000);
        mHandler.postDelayed(runnable2,30000);

        mHandler.postDelayed(runnable,34000);
        mHandler.postDelayed(runnable2,40000);

        mHandler.postDelayed(runnable,44000);
        mHandler.postDelayed(runnable3,50000);

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
            compareAnswer(6);
            realAnswer = makeRandomText(10);
            textView.setText(Integer.toString(realAnswer));
            textView.setTextColor(BLACK);
        }
    };

    Runnable runnable3 = new Runnable() {
        @Override
        public void run() {
            compareAnswer(6);

            if(score<30){
                String val = Integer.toString(score);
                Toast.makeText(getApplicationContext(),"L O S E!\nYour Score: "+val,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(
                        getApplicationContext(),
                        ButtonActivity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent);
            }
            else{
                String val = Integer.toString(score);
                Toast.makeText(getApplicationContext(),"F I N A L \nS U C C E S S E !\nYour Score: "+val,Toast.LENGTH_LONG).show();
            }
        }
    };

    public int compareAnswer(int level) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "입력시간이 지났습니다", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            answer = Integer.parseInt(editText.getText().toString());
            if (answer == realAnswer) {
                score++;
                if (score != level * 5) {
                    String val = Integer.toString(score);
                    Toast.makeText(getApplicationContext(), "맞았습니다\nCurrent Score: " + val, Toast.LENGTH_SHORT).show();
                }
                return 1;
            } else {
                String val = Integer.toString(score);
                Toast.makeText(getApplicationContext(), "틀렸습니다\nCurrent Score: " + val, Toast.LENGTH_SHORT).show();
                return 0;
            }
        }
    }
}
