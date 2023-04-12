package com.example.intothe.controller.MyPage;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.model.UserDBHelper;
import com.example.intothe.databinding.SettingCodeBinding;

import online.devliving.passcodeview.PasscodeView;

public class SettingCode extends AppCompatActivity {

    public static String code = "";
    private SettingCodeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SettingCodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // db start
        UserDBHelper myDb = new UserDBHelper(SettingCode.this);
        SQLiteDatabase db = myDb.getWritableDatabase();


        // 뒤로 가기
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });

        binding.passcodeView.setPasscodeEntryListener(new PasscodeView.PasscodeEntryListener() {
            @Override
            public void onPasscodeEntered(String passcode) {
                code = passcode;
//                Toast.makeText(SettingCode.this, "Passcode entered: " + passcode, Toast.LENGTH_SHORT).show();
            }
        });


        // 저장하기 버튼 누르면
        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // db에 설정한 비밀번호 저장
                db.execSQL("UPDATE user SET password='" + code + "' WHERE _id='" + LoginActivity.userId + "';");

                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });
    }
}
