package com.example.hwanghyewon.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

public class Level4Activity extends MemorizationGame{

    private TextView textView;
    private EditText editText;
    private Handler mHandler;
    private int realAnswer;
    private int answer;
    private int score = 15;

    @Override
    public void onBackPressed(){
        Toast.makeText(getApplicationContext(),"게임 중에는 나갈 수 없습니다 ",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);

        realAnswer = makeRandomText(8);
        textView.setText(Integer.toString(realAnswer));
        mHandler = new Handler();

        mHandler.sendEmptyMessage(0);

        mHandler.postDelayed(runnable,3000);
        mHandler.postDelayed(runnable2,8000);

        mHandler.postDelayed(runnable,11000);
        mHandler.postDelayed(runnable2,16000);

        mHandler.postDelayed(runnable,19000);
        mHandler.postDelayed(runnable2,24000);

        mHandler.postDelayed(runnable,27000);
        mHandler.postDelayed(runnable2,32000);

        mHandler.postDelayed(runnable,34000);
        mHandler.postDelayed(runnable3,38000);

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
            compareAnswer(4);
            realAnswer = makeRandomText(8);
            textView.setText(Integer.toString(realAnswer));
            textView.setTextColor(BLACK);
        }
    };

    Runnable runnable3 = new Runnable() {
        @Override
        public void run() {
            compareAnswer(4);

            if(score<20){
                String val = Integer.toString(score);
                Toast.makeText(getApplicationContext(),"L O S E!\nYour Score: "+val,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(
                        getApplicationContext(),
                        ButtonActivity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent);
            }
            else{
                String val = Integer.toString(score);
                Toast.makeText(getApplicationContext(),"S U C C E S S E !\nYour Score: "+val,Toast.LENGTH_LONG).show();
                Intent intent4 = new Intent(
                        getApplicationContext(),
                        Level5Activity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent4);
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