package com.example.hwanghyewon.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.KeyEvent;
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
    public boolean onKeyDown(int keyCode, KeyEvent event){
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                new AlertDialog.Builder(this)
                        .setTitle("종료")
                        .setMessage("홈 화면으로 돌아갑니다\n종료하시겠습니까?")
                        .setPositiveButton("예",new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int whichButton){
                                Intent intent2 = new Intent(
                                        getApplicationContext(),
                                        ButtonActivity.class); // 다음 넘어갈 클래스 지정
                                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent2);
                            }
                        })
                        .setNegativeButton("아니오",null).show();
                return false;
            default:
                return false;
        }
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

        mHandler.postDelayed(runnable,2500);
        mHandler.postDelayed(runnable2,8000);

        mHandler.postDelayed(runnable,10000);
        mHandler.postDelayed(runnable2,15000);

        mHandler.postDelayed(runnable,17000);
        mHandler.postDelayed(runnable2,22000);

        mHandler.postDelayed(runnable,24000);
        mHandler.postDelayed(runnable2,29000);

        mHandler.postDelayed(runnable,31000);
        mHandler.postDelayed(runnable3,36000);

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
                Toast.makeText(getApplicationContext(),"L O S E!Your Score: " + val,Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(
                        getApplicationContext(),
                        ButtonActivity.class); // 다음 넘어갈 클래스 지정
                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
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