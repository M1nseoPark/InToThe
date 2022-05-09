package com.example.intothe.MyPage;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.R;
import com.example.intothe.UserDBHelper;

import online.devliving.passcodeview.PasscodeView;

public class SettingCode extends AppCompatActivity {

    public static String code = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_code);

        ImageView back = (ImageView) findViewById(R.id.back);
        Button save = (Button) findViewById(R.id.save);
        PasscodeView passcodeView = (PasscodeView) findViewById(R.id.passcode_view);


        // db start
        UserDBHelper myDb = new UserDBHelper(SettingCode.this);
        SQLiteDatabase db = myDb.getWritableDatabase();


        // 뒤로 가기
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });

        passcodeView.setPasscodeEntryListener(new PasscodeView.PasscodeEntryListener() {
            @Override
            public void onPasscodeEntered(String passcode) {
                code = passcode;
//                Toast.makeText(SettingCode.this, "Passcode entered: " + passcode, Toast.LENGTH_SHORT).show();
            }
        });


        // 저장하기 버튼 누르면
        save.setOnClickListener(new View.OnClickListener() {
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
