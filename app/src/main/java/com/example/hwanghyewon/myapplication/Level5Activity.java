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

public class Level5Activity extends MemorizationGame{
    private TextView textView;
    private EditText editText;
    private Handler mHandler;

    private int realAnswer;
    public static int level = 5;

    public Level5Activity(){
        super(level);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public int compareAnswer(int realAnswer, EditText editText){
        return super.compareAnswer(realAnswer, editText);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level5);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);

        realAnswer = makeRandomText(9);
        textView.setText(Integer.toString(realAnswer));
        mHandler = new Handler();
        mHandler.sendEmptyMessage(0);

        start();
    };

    public void start(){
        //if(!stopRun) {
        mHandler.postDelayed(runnable, 1500);
        mHandler.postDelayed(runnable2, 6000);
        //}
        //if(!stopRun) {
        mHandler.postDelayed(runnable, 7000);
        mHandler.postDelayed(runnable2, 11000);
        //}
        //if(!stopRun) {
        mHandler.postDelayed(runnable, 12000);
        mHandler.postDelayed(runnable2, 16000);
        //}
        //if(!stopRun) {
        mHandler.postDelayed(runnable, 17000);
        mHandler.postDelayed(runnable2, 21000);
        //}
        //else if(!stopRun){
        mHandler.postDelayed(runnable, 22000);
        mHandler.postDelayed(runnable3, 26000);
        //}
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            textView.setTextColor(WHITE);
        };
    };

    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            compareAnswer(realAnswer,editText);
            realAnswer = makeRandomText(9);
            textView.setText(Integer.toString(realAnswer));
            textView.setTextColor(BLACK);
        }
    };

    Runnable runnable3 = new Runnable() {
        @Override
        public void run() {
            compareAnswer(realAnswer,editText);

            if(score<(level*5)){
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
                Intent intent5 = new Intent(
                        getApplicationContext(),
                        Level6Activity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent5);
            }
        }
    };

}
