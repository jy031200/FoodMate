package com.example.fm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class participants_store_list extends Activity {
    TextView box;
    TextView food;
    TextView people;
    TextView goal;
    TextView time;
    Button btnchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participants_store_list);

        box = (TextView) findViewById(R.id.box);
        food = (TextView) findViewById(R.id.textView10);
        people = (TextView) findViewById(R.id.textView11);
        goal = (TextView) findViewById(R.id.textView12);
        time = (TextView) findViewById(R.id.textView13);
        btnchange = (Button) findViewById(R.id.btnchange);

//        Intent intent = getIntent();
//        String data01 = intent.getStringExtra("text01");
//        String data02 = intent.getStringExtra("text02");
//        String data03 = intent.getStringExtra("text03");
//        String data04 = intent.getStringExtra("text04");
//
//        food.setText(data01);
//        people.setText(data02);
//        goal.setText(data03);
//        time.setText(data04);

        box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participants_store_list.this, Paritipants_application_form_screen.class);
                startActivity(intent);
                finish();
            }
        });

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participants_store_list.this, StorelistActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
