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

public class Popup_food extends Activity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //배경 투명하게
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_food);

        getdata();
    }

    private void getdata() {
        //UI 객체생성
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);

        //데이터 가져오기
        Intent intent = getIntent();
        String data01 = intent.getStringExtra("data1");
        String data02 = intent.getStringExtra("data2");
        String data03 = intent.getStringExtra("data3");
        String data04 = intent.getStringExtra("data4");
        String data05 = intent.getStringExtra("data5");
        String data06 = intent.getStringExtra("data6");
        String data07 = intent.getStringExtra("data7");
        String data08 = intent.getStringExtra("data8");

        button1.setText(data01);
        button2.setText(data02);
        button3.setText(data03);
        button4.setText(data04);
        button5.setText(data05);
        button6.setText(data06);
        button7.setText(data07);
        button8.setText(data08);
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
    public void mOnClose03(View v){
        Intent intent03 = getIntent();
        String data03 = intent03.getStringExtra("data3");

        Intent intent = new Intent();
        intent.putExtra("result", data03);
        setResult(RESULT_OK, intent);

        finish();
    }
    public void mOnClose04(View v){
        Intent intent04 = getIntent();
        String data04 = intent04.getStringExtra("data4");

        Intent intent = new Intent();
        intent.putExtra("result", data04);
        setResult(RESULT_OK, intent);

        finish();
    }
    public void mOnClose05(View v){
        Intent intent05= getIntent();
        String data05 = intent05.getStringExtra("data5");

        Intent intent = new Intent();
        intent.putExtra("result", data05);
        setResult(RESULT_OK, intent);

        finish();
    }
    public void mOnClose06(View v){
        Intent intent06 = getIntent();
        String data06 = intent06.getStringExtra("data6");

        Intent intent = new Intent();
        intent.putExtra("result", data06);
        setResult(RESULT_OK, intent);

        finish();
    }
    public void mOnClose07(View v){
        Intent intent07 = getIntent();
        String data07 = intent07.getStringExtra("data7");

        Intent intent = new Intent();
        intent.putExtra("result", data07);
        setResult(RESULT_OK, intent);

        finish();
    }
    public void mOnClose08(View v){
        Intent intent08 = getIntent();
        String data08 = intent08.getStringExtra("data8");

        Intent intent = new Intent();
        intent.putExtra("result", data08);
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