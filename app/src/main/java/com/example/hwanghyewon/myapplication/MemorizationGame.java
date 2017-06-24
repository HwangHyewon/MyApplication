package com.example.hwanghyewon.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;


public class MemorizationGame extends AppCompatActivity {

	public int makeRandomText(int num) {
		Random random = new Random();

		double val[];
		double realAnswer = 0;
		val = new double[num];

		for (int i = 0; i < num; i++) {
			int scan = random.nextInt(10);
			val[i] = scan;
		}

		for (int i = 0; i < num; i++) {
			realAnswer = realAnswer + val[i] * Math.pow(10, val.length - (i + 1));

		}
		return (int) realAnswer;
	};


}


