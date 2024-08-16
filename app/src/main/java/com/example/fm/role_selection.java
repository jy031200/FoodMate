package com.example.fm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class role_selection extends AppCompatActivity {
    Button btn_order;
    Button btn_participant;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.role_selection);

        Intent receive_intent = getIntent();
        String email = receive_intent.getStringExtra("email");

        btn_order = (Button) findViewById(R.id.btnorder);
        btn_participant = (Button) findViewById(R.id.btnparticipant);

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(role_selection.this, StorelistActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
                finish();
            }
        });

        btn_participant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(role_selection.this, participant_popup.class);
                intent.putExtra("email", email);
                startActivity(intent);
                finish();
            }
        });
    }
}