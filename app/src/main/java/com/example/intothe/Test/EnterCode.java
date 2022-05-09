package com.example.intothe.Test;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.R;

public class EnterCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_code);

        String userPassword;


        // db start
        ResultDBHelper myDb = new ResultDBHelper(EnterCode.this);
        SQLiteDatabase db = myDb.getReadableDatabase();

        String sql = "select * from user where id=" + LoginActivity.userId;
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            userPassword = cursor.getString(7);
        }

        myDb.close();
        db.close();
        cursor.close();


        // 비밀번호 일치 여부 확인

    }
}
