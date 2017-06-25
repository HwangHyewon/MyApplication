package com.example.hwanghyewon.myapplication;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;

public class MemorizationGame extends AppCompatActivity {
	private int answer; // editText에서 받아온 값을 저장
	public int score; // 각 레벨 별로 시작하는 점수 지정
	private int level;
	//public boolean stopRun = false;

	//레벨 과 각 레벨에 대한 시작 점수
	public MemorizationGame(int level){
		this.level = level;
		this.score = (level-1) * 5;
	}
	//원하는 범위만큼의 랜덤 숫자 생성
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
	//각 레벨에서 게임하는 도중 취소버튼을 눌렀을 경우 종료여부를 물음
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		switch(keyCode){
			case KeyEvent.KEYCODE_BACK:
				//stopRun = true;
				new AlertDialog.Builder(this)
						.setTitle("종료")
						.setMessage("홈 화면으로 돌아갑니다\n종료하시겠습니까?")
						.setPositiveButton("예",new DialogInterface.OnClickListener(){
							public void onClick(DialogInterface dialog, int whichButton){
								Intent intent2 = new Intent(
										getApplicationContext(),
										ButtonActivity.class); // 다음 넘어갈 클래스 지정
								intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//stack정리
								startActivity(intent2);
							}
						})
						.setNegativeButton("아니오",null).show();
				return false;
			default:
				return false;
		}
	}
	//랜덤으로 생성된 실제 숫자값과 사용자가 입력한 값을 비교
	public int compareAnswer(int realAnswer, EditText editText) {
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


