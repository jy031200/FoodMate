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

public class participant_popup extends Activity {

    TextView txtResult01;
    TextView txtResult02;
    TextView txtResult03;
    TextView txtResult04;
    Button button01;
    Button button02;
    Button button03;
    Button button04;
    Button btnchange;
    Button btndetail;
    Button btn_map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participants_default_screen);

        txtResult01 = (TextView)findViewById(R.id.hashfood); // 음식 카테고리 버튼 데이터 출력
        txtResult02 = (TextView)findViewById(R.id.hashper); // 모집 인원 버튼 데이터 출력
        txtResult03 = (TextView)findViewById(R.id.hashgoal); // 모집 목적 버튼 데이터 출력
        txtResult04 = (TextView)findViewById(R.id.hashtime); // 모집 기한 버튼 데이터 출력
        button01 = (Button) findViewById(R.id.food);
        button02 = (Button) findViewById(R.id.Personnel);
        button03 = (Button) findViewById(R.id.goal);
        button04 = (Button) findViewById(R.id.time);
        btnchange = (Button) findViewById(R.id.btnchange);
        btndetail = (Button) findViewById(R.id.DetailList) ;
        btn_map = (Button) findViewById(R.id.btn_map) ;

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
                    nowName.setText(nickname+"님(참여자)");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btndetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participant_popup.this, Popup_detail2.class);
                intent.putExtra("email", email);
                startActivity(intent);
                finish();
            }
        });

        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participant_popup.this, participants_map.class);
                startActivity(intent);
            }
        });

        btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participant_popup.this, StorelistActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });

        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participant_popup.this, Popup_food.class);
                intent.putExtra("data1", "일식");
                intent.putExtra("data2", "중식");
                intent.putExtra("data3", "양식");
                intent.putExtra("data4", "한식");
                intent.putExtra("data5", "분식");
                intent.putExtra("data6", "야식");
                intent.putExtra("data7", "패스트푸드");
                intent.putExtra("data8", "디저트");
                startActivityForResult(intent,1);
            }
        });

        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participant_popup.this, Popup_person.class);
                startActivityForResult(intent,2);
            }
        });

        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participant_popup.this, Popup_goal.class);
                intent.putExtra("data1", "배달비 나눔");
                intent.putExtra("data2", "음식 나눔");
                startActivityForResult(intent,3);
            }
        });

        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(participant_popup.this, Popup_time.class);
                startActivityForResult(intent,4);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            String result = data.getStringExtra("result");
            if(requestCode == 1){
                txtResult01.setText("#"+result);
            }
            else if(requestCode == 2){
                txtResult02.setText("#"+result+"인");
            }
            else if(requestCode == 3){
                txtResult03.setText("#"+result);
            }
            else if(requestCode == 4){
                txtResult04.setText("#"+result+"시");
            }
        }
        finish();
    }
}
