package com.example.fm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Random;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    EditText mNickname, mId, mPassword, mName, mAddress, mPhonenum, rNum;
    Button mNext, mNum, mNok;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        // 파이어베이스 접근 설정
        firebaseAuth = FirebaseAuth.getInstance();

        mNickname= findViewById(R.id.rnickname);
        mId= findViewById(R.id.rid);
        mPassword= findViewById(R.id.rpassword);
        mName= findViewById(R.id.rname);
        mAddress= findViewById(R.id.raddress);
        mPhonenum= findViewById(R.id.rphonenum);
        mNext= findViewById(R.id.btnnext);

        mNum = findViewById(R.id.btnnum);
        rNum = findViewById(R.id.rnum);
        mNok = findViewById(R.id.btnok);

        //인증번호 받기 버튼 클릭 시 난수 생성
        mNum.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //랜덤 기본 함수, 0~100000 사이
                Random rnd = new Random();
                int num1 = rnd.nextInt(100000);

                //랜덤숫자를 인증번호 텍스트뷰에 대입
                rNum.setText(Integer.toString(num1));
            }
        }));

        //인증번호 확인 버튼 처리
        mNok.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this, "인증번호 확인 완료", Toast.LENGTH_SHORT).show();
                mNok.requestFocus();
                return;
            }
        }));

        // 가입 버튼 클릭 리스너 -> 파이어베이스에 데이터를 저장 (파이어베이슷 user로 접근)
        mNext.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 가입 정보 가져오기
                final String email = mId.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                //닉네임 공백 판별
                if(mNickname.getText().toString().length() == 0){
                    Toast.makeText(RegisterActivity.this, "닉네임을 입력하세요", Toast.LENGTH_SHORT).show();
                    mNickname.requestFocus();
                    return;
                }

                //아이디 공백 판별
                if(mId.getText().toString().length() == 0) {
                    Toast.makeText(RegisterActivity.this, "아이디를 입력하세요", Toast.LENGTH_SHORT).show();
                    mId.requestFocus();
                    return;
                }


                //비밀번호 공백 판별
                if(mPassword.getText().toString().length() == 0){
                    Toast.makeText(RegisterActivity.this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
                    mPassword.requestFocus();
                    return;
                }

                //비밀번호 6자리 이상 판별
                if(mPassword.getText().toString().length() < 6){
                    Toast.makeText(RegisterActivity.this, "비밀번호 6자리 이상 입력하세요", Toast.LENGTH_SHORT).show();
                    mPassword.requestFocus();
                    return;
                }

                //닉네임 공백 판별
                if(mName.getText().toString().length() == 0){
                    Toast.makeText(RegisterActivity.this, "이름을 입력하세요", Toast.LENGTH_SHORT).show();
                    mName.requestFocus();
                    return;
                }


                //주소 공백 판별
                if(mAddress.getText().toString().length() == 0){
                    Toast.makeText(RegisterActivity.this, "주소를 입력하세요", Toast.LENGTH_SHORT).show();
                    mAddress.requestFocus();
                    return;
                }

                // 파이어베이스에 신규계정 등록
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // 가입 성공시
                        if(task.isSuccessful()){
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            String id = user.getEmail();
                            String uid = user.getUid();
                            String nickname = mNickname.getText().toString().trim();
                            String name = mName.getText().toString().trim();
                            String address = mAddress.getText().toString().trim();
                            String phonenum = mPhonenum.getText().toString().trim();

                            // 해쉬맵 테이블을 파이어베이스 데이터베이스에 저장
                            HashMap<Object, String> hashMap = new HashMap<>();

                            hashMap.put("uid", uid);
                            hashMap.put("id", id);
                            hashMap.put("nickname", nickname);
                            hashMap.put("name", name);
                            hashMap.put("address", address);
                            hashMap.put("phonenum", phonenum);

                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference reference = database.getReference("Users");
                            reference.child(uid).setValue(hashMap);

                            // 가입 성공시 화면 이동
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(RegisterActivity.this,"회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(RegisterActivity.this,"회원가입에 실패하셨습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }));
    }

}