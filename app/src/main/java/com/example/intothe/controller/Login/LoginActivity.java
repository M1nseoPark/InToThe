package com.example.intothe.controller.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.amitshekhar.DebugDB;
import com.example.intothe.controller.MainActivity;
import com.example.intothe.model.UserDBHelper;
import com.example.intothe.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;   // 파이어베이스 인증 처리
    private DatabaseReference mDatabaseRef;   // 실시간 데이터베이스

    public static String userName;   // 로그인 한 사용자 이름
    public static String userId;   // 로그인 한 사용자의 아이디

    private ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DebugDB.getAddressLog();

//        ReportDBHelper myDb2 = new ReportDBHelper(LoginActivity.this);
//        SQLiteDatabase db2 = myDb2.getWritableDatabase();
//        db2.execSQL("DELETE FROM report2 WHERE _id=10");
//        db2.execSQL("DELETE FROM report2 WHERE _id=11");

        UserDBHelper myDb = new UserDBHelper(LoginActivity.this);
        SQLiteDatabase db = myDb.getReadableDatabase();

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("InToThe");

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 로그인 요청
                String strEmail = binding.etEmail.getText().toString();
                String strPwd = binding.etPwd.getText().toString();

                mFirebaseAuth.signInWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 로그인 성공
                            Cursor cursor = db.rawQuery("select * from user where email = ?", new String[]{strEmail});
                            while(cursor.moveToNext()){
                                userId = String.valueOf(cursor.getInt(0));
                                userName = cursor.getString(1);
                            }
                            myDb.close();
                            db.close();
                            cursor.close();

                            RegisterActivity.userId = LoginActivity.userId;
                            Log.v("test", RegisterActivity.userId);

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();   // 현재 액티비티 파괴
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "로그인에 실패하셨습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 회원가입 화면으로 이동
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}