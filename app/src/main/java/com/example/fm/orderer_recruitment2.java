package com.example.fm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class orderer_recruitment2 extends Activity {
    Button btn;
    Button btnchange;
    EditText mTitle, mContent;
    Spinner mCategory, mPurpose, mNum, mTerm;
    TextView mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderer_recruitment2);

        Intent receive_intent = getIntent();
        String request_spoon = receive_intent.getStringExtra("r_spoon");
        String request_side = receive_intent.getStringExtra("r_side");
        String request_ceo = receive_intent.getStringExtra("r_ceo");
        String request_rider = receive_intent.getStringExtra("r_rider");
        String payment = receive_intent.getStringExtra("payment");
        String restaurant = receive_intent.getStringExtra("restaurant");

        String minDB = receive_intent.getStringExtra("minDB");
        String deliveryDB = receive_intent.getStringExtra("deliveryDB");

        TextView nowName = (TextView)findViewById(R.id.name);
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
                    nowName.setText(nickname+"님(주문자)");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btn = (Button) findViewById(R.id.button2);
        btnchange = (Button) findViewById(R.id.btnchange);
        mTitle = (EditText) findViewById(R.id.textView15);
        mContent = (EditText) findViewById(R.id.editTextTextPersonName);
        mCategory = (Spinner) findViewById(R.id.spinner);
        mPurpose = (Spinner) findViewById(R.id.spinner2);
        mNum = (Spinner) findViewById(R.id.spinner3);
        mTerm = (Spinner) findViewById(R.id.spinner4);
        mName = (TextView) findViewById(R.id.name);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String category = mCategory.getSelectedItem().toString();
                String purpose = mPurpose.getSelectedItem().toString();
                String num = mNum.getSelectedItem().toString();
                String term = mTerm.getSelectedItem().toString();
                String title = mTitle.getText().toString().trim();
                String content = mContent.getText().toString().trim();
                String Name = mName.getText().toString().trim();

                String temp = Name;
                int idx = temp.indexOf("님");
                String name = temp.substring(0, idx);

                // 해쉬맵 테이블을 파이어베이스 데이터베이스에 저장
                HashMap<Object, String> recruitment = new HashMap<>();

                recruitment.put("request_spoon", request_spoon);
                recruitment.put("payment", payment);
                recruitment.put("request_side", request_side);
                recruitment.put("request_ceo", request_ceo);
                recruitment.put("request_rider", request_rider);
                recruitment.put("restaurant", restaurant);

                recruitment.put("min_price", minDB);
                recruitment.put("price", deliveryDB);

                String one = getTime();

                recruitment.put("title", title);
                recruitment.put("content", content);
                recruitment.put("category", category);
                recruitment.put("purpose", purpose);
                recruitment.put("num", num);
                recruitment.put("term", term);
                recruitment.put("name", name);
                recruitment.put("time", one);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("Recruitment");
                reference.child(one).setValue(recruitment);

                Intent intent = new Intent(orderer_recruitment2.this, order_orderer.class);
                intent.putExtra("title", title);
                intent.putExtra("time", one);
                startActivity(intent);
            }
        });

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(orderer_recruitment2.this, StorelistActivity.class);
                startActivity(intent);
            }
        });
    }

    private String getTime(){
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String getTime = dateFormat.format(date);
        return getTime;
    }
}
