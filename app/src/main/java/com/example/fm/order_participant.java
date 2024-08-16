package com.example.fm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class order_participant extends Activity {
    Button btnout;
    Button btnOK;
    ListView listView0;
    order_ListItemAdapater adapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_participants);

        TextView minm = (TextView) findViewById(R.id.txtminmoney00);
        TextView feem = (TextView) findViewById(R.id.ttxtfeemoney00);
        TextView arrive = (TextView) findViewById(R.id.txtarrivaltime00);
        TextView name = (TextView) findViewById(R.id.txtname00);
        TextView name2 = (TextView) findViewById(R.id.txtname);
        TextView oder = (TextView) findViewById(R.id.txtoder);

        profile p = new profile();
        String email = p.getEmail();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");
        myRef.orderByChild("id").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    users user = childDataSnapshot.getValue(users.class);
                    String nickname = user.getNickname();
                    name.setText(nickname + " 님(참여자)");
                    name2.setText(nickname);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnout = (Button) findViewById(R.id.btnout);
        btnOK = (Button) findViewById(R.id.btnoderok);
        listView0 = findViewById(R.id.listView0);

        String time = p.getTime();

        myRef = database.getReference("Recruitment");
        myRef.orderByChild("time").equalTo(time).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    recruitment list = childDataSnapshot.getValue(recruitment.class);
                    String mPri = list.getMin_price();
                    String pri = list.getPrice();
                    minm.setText(mPri);
                    feem.setText(pri);

                    String now = getTime();
                    arrive.setText(now);

                    String orderName = list.getName();
                    adapater = new order_ListItemAdapater();
                    adapater.addItem(new ListItem(orderName+"(주문자)",R.drawable.harry1,"승인"));
                    listView0.setAdapter(adapater);
                    adapater.getListViewSize(listView0);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oder.setText("승인");

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("Recruitment");

                String mname = name2.getText().toString();
                String moder = oder.getText().toString();
                profile p = new profile();
                String time = p.getTime();

                HashMap<Object, String> participant = new HashMap<>();
                participant.put("name", mname);
                participant.put("oder", moder);

                reference.child(time).child("participant").setValue(participant);
            }
        });
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile p = new profile();
                String time = p.getTime();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("Recruitment");
                reference.child(time).child("participant").child("oder").setValue(null);
                reference.child(time).child("participant").child("name").setValue(null);

                Intent intent = new Intent(order_participant.this, role_selection.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private String getTime(){
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");

        // 현재 시간에 50분 추가
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, 50);
        String getTime = dateFormat.format(calendar.getTime());
        return getTime;
    }
}
