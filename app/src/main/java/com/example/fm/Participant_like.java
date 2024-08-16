package com.example.fm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Participant_like extends Activity {
    TextView box;
    Button btnchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participant_like);

        box = (TextView) findViewById(R.id.box);
        btnchange = (Button) findViewById(R.id.btnchange);

        box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Participant_like.this, Paritipants_application_form_screen.class);
                startActivity(intent);
                finish();
            }
        });

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Participant_like.this, StorelistActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}