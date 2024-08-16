package com.example.fm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Paritipants_application_form_screen extends Activity {
    Button btnstor;
    Button btnpart;
    Button btnchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participants_application_form_screen);

        Intent receive_intent = getIntent();
        String text = receive_intent.getStringExtra("text");

        btnstor = (Button) findViewById(R.id.Storage);
        btnpart = (Button) findViewById(R.id.participate);
        btnchange = (Button) findViewById(R.id.btnchange);

        TextView mName = (TextView) findViewById(R.id.textView18);
        TextView mRestaurant = (TextView) findViewById(R.id.textView20);
        TextView mTitle = (TextView) findViewById(R.id.textView17);
        TextView mMinP = (TextView) findViewById(R.id.textView29);
        TextView mPurpose = (TextView) findViewById(R.id.textView35);
        TextView mNum = (TextView) findViewById(R.id.textView42);
        TextView mTerm = (TextView) findViewById(R.id.textView45);
        TextView mContent = (TextView) findViewById(R.id.textView25);
        TextView mTime = (TextView) findViewById(R.id.v28);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Recruitment");
        myRef.orderByChild("title").equalTo(text).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    recruitment list = childDataSnapshot.getValue(recruitment.class);
                    String name = list.getName();
                    String restaurant = list.getRestaurant();
                    String title = list.getTitle();
                    String minP = list.getMin_price();
                    String purpose = list.getPurpose();
                    String num = list.getNum();
                    String term = list.getNum();
                    String content = list.getContent();
                    String time = list.getTime();
                    mName.setText(name);
                    mRestaurant.setText(restaurant);
                    mTitle.setText(title);
                    mMinP.setText(minP);
                    mPurpose.setText(purpose);
                    mNum.setText(num);
                    mTerm.setText(term);
                    mContent.setText(content);
                    mTime.setText(time);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        TextView nowName = (TextView)findViewById(R.id.name);
        profile p = new profile();
        String email = p.getEmail();
        myRef = database.getReference("Users");
        myRef.orderByChild("id").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    users user = childDataSnapshot.getValue(users.class);
                    String nickname = user.getNickname();
                    nowName.setText(nickname+"님(참여자)");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Paritipants_application_form_screen.this, StorelistActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnstor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Paritipants_application_form_screen.this, Popup_like.class);
                startActivity(intent);
            }
        });

        btnpart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = mTime.getText().toString();
                profile p = new profile();
                p.time = time;

                Intent intent = new Intent(Paritipants_application_form_screen.this, Popup_participant.class);
                startActivity(intent);
            }
        });
    }
}
