package com.example.fm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class order_user_menu_list extends Activity {
    TextView LL_box1, LL_box2, LL_box3, LL_box4, LL_box5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_menu_list);

        TextView mminDB = (TextView)findViewById(R.id.Minimum_amount_DB);
        TextView mdeliveryDB = (TextView)findViewById(R.id.Delivery_cost_DB);
        String minDB = mminDB.getText().toString().trim();
        String deliveryDB = mdeliveryDB.getText().toString().trim();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("temp");

        HashMap<Object, String> temp = new HashMap<>();


        TextView mjjajang = (TextView)findViewById(R.id.text1);
        TextView mjjajangP = (TextView)findViewById(R.id.text2);
        String jjajang = mjjajang.getText().toString().trim();
        String jjajangP = mjjajangP.getText().toString().trim();

        TextView mtangsu = (TextView)findViewById(R.id.text3);
        TextView mtangsuP = (TextView)findViewById(R.id.text4);
        String tangsu = mtangsu.getText().toString().trim();
        String tangsuP = mtangsuP.getText().toString().trim();

        TextView mbocc = (TextView)findViewById(R.id.text5);
        TextView mboccP = (TextView)findViewById(R.id.text6);
        String bocc = mbocc.getText().toString().trim();
        String boccP = mboccP.getText().toString().trim();

        TextView mjjam = (TextView)findViewById(R.id.text7);
        TextView mjjamP = (TextView)findViewById(R.id.textView14);
        String jjam = mjjam.getText().toString().trim();
        String jjamP = mjjamP.getText().toString().trim();

        TextView mkimchi = (TextView)findViewById(R.id.text8);
        TextView mkimchiP = (TextView)findViewById(R.id.text9);
        String kimchi = mkimchi.getText().toString().trim();
        String kimchiP = mkimchiP.getText().toString().trim();


        LL_box1 = (TextView) findViewById(R.id.box);
        LL_box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(order_user_menu_list.this, orderer_payment_basket_screen.class);

                temp.put("menu", jjajang);
                temp.put("price", jjajangP);
                reference.setValue(temp);

                intent.putExtra("menu", jjajang);
                intent.putExtra("price", jjajangP);
                intent.putExtra("minDB", minDB);
                intent.putExtra("deliveryDB", deliveryDB);

                startActivity(intent);
                finish();
            }
        });

        LL_box2 = (TextView) findViewById(R.id.box2);
        LL_box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(order_user_menu_list.this, orderer_payment_basket_screen.class);

                temp.put("menu", tangsu);
                temp.put("price", tangsuP);
                reference.setValue(temp);

                intent.putExtra("menu", tangsu);
                intent.putExtra("price", tangsuP);
                intent.putExtra("minDB", minDB);
                intent.putExtra("deliveryDB", deliveryDB);

                startActivity(intent);
                finish();
            }
        });

        LL_box3 = (TextView) findViewById(R.id.box3);
        LL_box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(order_user_menu_list.this, orderer_payment_basket_screen.class);

                temp.put("menu", bocc);
                temp.put("price", boccP);
                reference.setValue(temp);

                intent.putExtra("menu", bocc);
                intent.putExtra("price", boccP);
                intent.putExtra("minDB", minDB);
                intent.putExtra("deliveryDB", deliveryDB);

                startActivity(intent);
                finish();
            }
        });

        LL_box4 = (TextView) findViewById(R.id.box4);
        LL_box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(order_user_menu_list.this, orderer_payment_basket_screen.class);

                temp.put("menu", jjam);
                temp.put("price", jjamP);
                reference.setValue(temp);

                intent.putExtra("menu", jjam);
                intent.putExtra("price", jjamP);
                intent.putExtra("minDB", minDB);
                intent.putExtra("deliveryDB", deliveryDB);

                startActivity(intent);
                finish();
            }
        });

        LL_box5 = (TextView) findViewById(R.id.box5);
        LL_box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(order_user_menu_list.this, orderer_payment_basket_screen.class);

                temp.put("menu", kimchi);
                temp.put("price", kimchiP);
                reference.setValue(temp);

                intent.putExtra("menu", kimchi);
                intent.putExtra("price", kimchiP);
                intent.putExtra("minDB", minDB);
                intent.putExtra("deliveryDB", deliveryDB);

                startActivity(intent);
                finish();
            }
        });
    }
}
