package com.example.fm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Objects;

public class Popup_goal extends Activity {

    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //배경 투명하게
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_goal);

        getdata();
    }

    private void getdata() {
    //UI 객체생성
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        //데이터 가져오기
        Intent intent = getIntent();
        String data01 = intent.getStringExtra("data1");
        String data02 = intent.getStringExtra("data2");

        button1.setText(data01);
        button2.setText(data02);
    }

    //확인 버튼 클릭
    public void mOnClose01(View v){
        Intent intent01 = getIntent();
        String data01 = intent01.getStringExtra("data1");

        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("result",data01);
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }
    public void mOnClose02(View v){
        Intent intent02 = getIntent();
        String data02 = intent02.getStringExtra("data2");

        Intent intent = new Intent();
        intent.putExtra("result", data02);
        setResult(RESULT_OK, intent);

        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }
}