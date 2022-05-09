package com.example.intothe.Test;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.R;
import com.example.intothe.UserDBHelper;

import online.devliving.passcodeview.PasscodeView;

public class EnterCode extends AppCompatActivity {

    String userPassword;   // db에 저장된 비밀번호
    String enterPassword;   // 사용자가 입력한 비밀번호

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_code);

        PasscodeView passcodeView = (PasscodeView) findViewById(R.id.passcode_view2);
        Button finish = (Button) findViewById(R.id.finish);


        // db start
        UserDBHelper myDb = new UserDBHelper(EnterCode.this);
        SQLiteDatabase db = myDb.getReadableDatabase();

        String sql = "select * from user where _id=" + LoginActivity.userId;
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            userPassword = cursor.getString(7);
        }

        myDb.close();
        db.close();
        cursor.close();


        // 비밀번호 일치 여부 확인
        passcodeView.setPasscodeEntryListener(new PasscodeView.PasscodeEntryListener() {
            @Override
            public void onPasscodeEntered(String passcode) {
                enterPassword = passcode;
//                Toast.makeText(SettingCode.this, "Passcode entered: " + passcode, Toast.LENGTH_SHORT).show();
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userPassword.equals(enterPassword)) {
                    Intent intent = new Intent(getApplicationContext(), TestListView.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(EnterCode.this, "비밀번호를 잘못 입력하셨습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
