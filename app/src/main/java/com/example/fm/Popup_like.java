package com.example.fm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Objects;

public class Popup_like  extends Activity {
    Button btnY;
    Button btnN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //배경 투명하게
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_like);

        btnY = (Button) findViewById(R.id.button3);
        btnN = (Button) findViewById(R.id.button4);

        btnY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Popup_like.this, Participant_like.class);
                startActivity(intent);
                finish();
            }
        });

        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               return;
            }
        });
    }
}
