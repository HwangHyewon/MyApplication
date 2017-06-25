package com.example.hwanghyewon.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

public class Level1Activity extends MemorizationGame{

    private TextView textView;
    private EditText editText;
    private Handler mHandler;
    private int realAnswer;
    private int answer;
    private int score = 0;

    @Override
    public void onBackPressed(){
        Toast.makeText(getApplicationContext(),"게임 중에는 나갈 수 없습니다 ",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);


        realAnswer = makeRandomText(3);
        textView.setText(Integer.toString(realAnswer));
        mHandler = new Handler();

        mHandler.sendEmptyMessage(0);

        mHandler.postDelayed(runnable,2000);
        mHandler.postDelayed(runnable2,6000);

        mHandler.postDelayed(runnable,8000);
        mHandler.postDelayed(runnable2,12000);

        mHandler.postDelayed(runnable,14000);
        mHandler.postDelayed(runnable2,18000);

        mHandler.postDelayed(runnable,20000);
        mHandler.postDelayed(runnable2,24000);

        mHandler.postDelayed(runnable,26000);
        mHandler.postDelayed(runnable3,30000);

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
            compareAnswer(1);
            realAnswer = makeRandomText(3);
            textView.setText(Integer.toString(realAnswer));
            textView.setTextColor(BLACK);
        }
    };
    Runnable runnable3 = new Runnable() {
        @Override
        public void run() {
            compareAnswer(1);

            if(score<5){
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
                Intent intent1 = new Intent(
                        getApplicationContext(),
                        Level2Activity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent1);
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
