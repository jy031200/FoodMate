package com.example.fm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class participants_payment_basket_screen extends Activity {
    Button btnmore;
    Button btnok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participants_payment_basket_screen);

        btnmore = findViewById(R.id.button9);
        btnok = findViewById(R.id.button11);

        btnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participants_payment_basket_screen.this, participants_user_menu_list.class);
                startActivity(intent);
                finish();
            }
        });

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participants_payment_basket_screen.this, order_participant.class);
                startActivity(intent);
                finish();
            }
        });
    }
}