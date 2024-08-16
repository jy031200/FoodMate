package com.example.fm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class order_orderer extends Activity {
    Button btnorder;
    ListView listView0;
    order_ListItemAdapater adapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_orderer);
        btnorder = (Button) findViewById(R.id.btnorderok);
        listView0 = findViewById(R.id.listView0);

        TextView minm = (TextView) findViewById(R.id.txtminmoney00);
        TextView feem = (TextView) findViewById(R.id.ttxtfeemoney00);
        TextView arrive = (TextView) findViewById(R.id.txtarrivaltime00);
        TextView name = (TextView) findViewById(R.id.txtname00);
        TextView name2 = (TextView) findViewById(R.id.txtname);
        TextView oder = (TextView) findViewById(R.id.txtoder);

        Intent receive_intent = getIntent();
        String title = receive_intent.getStringExtra("title");
        String time = receive_intent.getStringExtra("time");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Recruitment");
        myRef.orderByChild("title").equalTo(title).addListenerForSingleValueEvent(new ValueEventListener() {

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
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        profile p = new profile();
        String email = p.getEmail();
        myRef = database.getReference("Users");
        myRef.orderByChild("id").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    users user = childDataSnapshot.getValue(users.class);
                    String nickname = user.getNickname();
                    name.setText(nickname + " 님(주문자)");
                    name2.setText(nickname);
                    oder.setText("승인");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        myRef = database.getReference("Recruitment");
//        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    recru_par list = snapshot.getValue(recru_par.class);
//                    String name = list.getName();
//                    String oder = list.getOder();
//                    adapater = new order_ListItemAdapater();
//                    adapater.addItem(new ListItem(name,R.drawable.harry1,oder));
//                    listView0.setAdapter(adapater);
//                    adapater.notifyDataSetChanged();
//                    adapater.getListViewSize(listView0);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(order_orderer.this, order_Receipt_.class);
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
