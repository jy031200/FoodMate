package com.example.fm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StorelistActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button btn_change;
    //private TextView TV_box1,TV_box2,TV_box3,TV_box4,TV_box5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderer_store_list);

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

        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
        btn_change=findViewById(R.id.btnchange);
        tabLayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter=new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new fragment1(), "일식");
        vpAdapter.addFragment(new fragment2(), "중식");
        vpAdapter.addFragment(new fragment3(), "양식");
        vpAdapter.addFragment(new fragment4(), "한식");
        vpAdapter.addFragment(new fragment5(), "분식");
        vpAdapter.addFragment(new fragment6(), "야식");
        vpAdapter.addFragment(new fragment7(), "패스트푸드");
        vpAdapter.addFragment(new fragment8(), "디저트");

//        Typeface typeFace = Typeface.createFromAsset(getAssets(),"bmjua_ttf.ttf"); //asset > fonts 폴더 내 폰트파일 적용
//        vpAdapter.setTypeface(typeFace);
        viewPager.setAdapter(vpAdapter);

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StorelistActivity.this, participant_popup.class);
                startActivity(intent);
            }
        });
    }
}