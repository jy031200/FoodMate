package com.example.fm;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class orderer_payment_basket_screen extends Activity {
    Button btn_addmenu, btn_create_recruitment;
    ListView listView;
    ListItemAdapater adapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderer_payment_basket_screen);

        CheckBox mRequest_spoon = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox mRequest_side = (CheckBox) findViewById(R.id.checkBox2);
        EditText mRequest_ceo = (EditText) findViewById(R.id.editTextText3);
        EditText mRequest_rider = (EditText) findViewById(R.id.editTextText4);
        Spinner mPayment = (Spinner) findViewById(R.id.textView46);
        TextView mRestaurant = (TextView) findViewById(R.id.textView33);

        Intent receive_intent = getIntent();
        String menu = receive_intent.getStringExtra("menu");
        String price = receive_intent.getStringExtra("price");
        String minDB = receive_intent.getStringExtra("minDB");
        String deliveryDB = receive_intent.getStringExtra("deliveryDB");

        TextView nowName = (TextView)findViewById(R.id.textView32);
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

        btn_addmenu = findViewById(R.id.btn_addmenu);
        btn_create_recruitment = findViewById(R.id.btn_create_recruitment);


        listView = findViewById(R.id.listView);
        adapater = new ListItemAdapater();
        listView.setAdapter(adapater);

        adapater.addItem(new ListItem(menu,price,minDB,deliveryDB));
        adapater.addItem(new ListItem("","","",""));

        adapater.notifyDataSetChanged();
        adapater.getListViewSize(listView);


        btn_addmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(orderer_payment_basket_screen.this, order_user_menu_list.class);
                startActivity(intent);
                finish();
            }
        });

        btn_create_recruitment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String request_spoon = mRequest_spoon.getText().toString();
                String request_side = mRequest_side.getText().toString();
                String request_ceo = mRequest_ceo.getText().toString();
                String request_rider = mRequest_rider.getText().toString();
                String payment = mPayment.getSelectedItem().toString();
                String restaurant = mRestaurant.getText().toString();

                Intent intent = new Intent(orderer_payment_basket_screen.this, orderer_recruitment2.class);
                intent.putExtra("r_spoon", request_spoon);
                intent.putExtra("r_side", request_side);
                intent.putExtra("r_ceo", request_ceo);
                intent.putExtra("r_rider", request_rider);
                intent.putExtra("payment", payment);
                intent.putExtra("restaurant", restaurant);

                intent.putExtra("minDB", minDB);
                intent.putExtra("deliveryDB", deliveryDB);
                startActivity(intent);
            }
        });
    }
}