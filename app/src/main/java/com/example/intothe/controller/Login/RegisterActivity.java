package com.example.intothe.controller.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.amitshekhar.DebugDB;
import com.example.intothe.databinding.ActivityRegisterBinding;
import com.example.intothe.model.FaceDBHelper;
import com.example.intothe.model.ReportDBHelper;
import com.example.intothe.model.ResultDBHelper;
import com.example.intothe.model.UserDBHelper;
import com.example.intothe.model.UserAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;   // 파이어베이스 인증 처리
    private DatabaseReference mDatabaseRef;   // 실시간 데이터베이스
    public static String userId;   // 회원가입한 사용자의 아이디

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DebugDB.getAddressLog();

        UserDBHelper myDb = new UserDBHelper(RegisterActivity.this);
        SQLiteDatabase db = myDb.getReadableDatabase();

        // 파이어베이스
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference();

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 회원가입 처리 시작
                String strEmail = binding.etEmail.getText().toString().trim();
                String strPwd = binding.etPwd.getText().toString().trim();
                String strName = binding.etName.getText().toString().trim();
                String strBirth = binding.etBirth.getText().toString().trim();


                // FirebaseAuth 진행
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (strEmail.isEmpty()) {
                            Toast.makeText(RegisterActivity.this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
                        }
                        else if (strPwd.isEmpty()) {
                            Toast.makeText(RegisterActivity.this, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                        }
                        else if (strName.isEmpty()) {
                            Toast.makeText(RegisterActivity.this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                        }
                        else if (strBirth.isEmpty()) {
                            Toast.makeText(RegisterActivity.this, "생년월일을 입력해주세요", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            if (task.isSuccessful()) {
                                FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();

                                UserAccount account = new UserAccount();
                                account.setIdToken(firebaseUser.getUid());
                                account.setEmailId(firebaseUser.getEmail());
                                account.setPassword(strPwd);
                                account.setUserName(strName);
                                account.setUserBirth(strBirth);

                                // setValue : database에 삽입
                                mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
                                myDb.addBook(strName, strEmail, strBirth, null, null, null, null);

                                // ResultDB, FaceDB 생성
                                Cursor cursor = db.rawQuery("select * from user where email = ?", new String[]{strEmail});
                                while(cursor.moveToNext()){
                                    userId = String.valueOf(cursor.getInt(0));
                                }
                                ReportDBHelper myDb2 = new ReportDBHelper(RegisterActivity.this);
                                SQLiteDatabase db2 = myDb2.getWritableDatabase();
                                FaceDBHelper myDb3 = new FaceDBHelper(RegisterActivity.this);
                                SQLiteDatabase db3 = myDb3.getWritableDatabase();
                                ResultDBHelper myDb4 = new ResultDBHelper(RegisterActivity.this);
                                SQLiteDatabase db4 = myDb3.getWritableDatabase();
                                myDb2.onCreate(db2);
                                myDb3.onCreate(db3);
                                myDb4.onCreate(db4);

                                Toast.makeText(RegisterActivity.this, "회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show();

                                // 로그인 화면으로 이동
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(RegisterActivity.this, "회원가입에 실패하셨습니다", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });
    }
}