package com.example.fm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class participants_user_menu_list extends Activity {
    TextView LL_box1, LL_box2, LL_box3, LL_box4, LL_box5;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_menu_list);

        name = (TextView) findViewById(R.id.store_name);

        LL_box1 = (TextView) findViewById(R.id.box);
        LL_box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participants_user_menu_list.this, order_participant.class);
                startActivity(intent);
                finish();
            }
        });

        LL_box2 = (TextView) findViewById(R.id.box2);
        LL_box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participants_user_menu_list.this, order_participant.class);
                startActivity(intent);
                finish();
            }
        });

        LL_box3 = (TextView) findViewById(R.id.box3);
        LL_box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participants_user_menu_list.this, order_participant.class);
                startActivity(intent);
                finish();
            }
        });

        LL_box4 = (TextView) findViewById(R.id.box4);
        LL_box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participants_user_menu_list.this, order_participant.class);
                startActivity(intent);
                finish();
            }
        });

        LL_box5 = (TextView) findViewById(R.id.box5);
        LL_box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participants_user_menu_list.this, order_participant.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
