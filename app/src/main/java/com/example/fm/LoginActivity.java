package com.example.fm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    Button mLogin;
    TextView mRegister;
    EditText mId, mPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        firebaseAuth = FirebaseAuth.getInstance();

        // 버튼 등록
        mId= findViewById(R.id.id);
        mPassword= findViewById(R.id.password);
        mLogin= findViewById(R.id.btnlogin);
        mRegister= findViewById(R.id.btnregister);

        // 가입 버튼이 눌리면
        mRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        // 로그인 버튼이 눌리면
        mLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = mId.getText().toString().trim();
                profile p = new profile();
                p.email = email;

                String password = mPassword.getText().toString().trim();
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(LoginActivity.this, role_selection.class);
                                    intent.putExtra("email", email);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(LoginActivity.this,"로그인 오류",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    }
}