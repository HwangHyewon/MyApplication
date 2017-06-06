package com.example.hwanghyewon.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button a = (Button)findViewById(R.id.button1);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(
                        getApplicationContext(),
                        Level1Activity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent1); // 다음 화면으로 넘어간다
            }
        });

        Button b = (Button)findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(
                        getApplicationContext(),
                        Level2Activity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent2); // 다음 화면으로 넘어간다
            }
        });


        Button c = (Button)findViewById(R.id.button3);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(
                        getApplicationContext(),
                        Level3Activity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent3); // 다음 화면으로 넘어간다
            }
        });

        Button d = (Button)findViewById(R.id.button4);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(
                        getApplicationContext(),
                        Level4Activity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent4); // 다음 화면으로 넘어간다
            }
        });

        Button e = (Button)findViewById(R.id.button5);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(
                        getApplicationContext(),
                        Level5Activity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent5); // 다음 화면으로 넘어간다
            }
        });

        Button f = (Button)findViewById(R.id.button6);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(
                        getApplicationContext(),
                        Level6Activity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent6); // 다음 화면으로 넘어간다
            }
        });
    }
}
