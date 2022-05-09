package com.example.intothe.MyPage;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.R;
import com.example.intothe.UserDBHelper;

public class SettingCode extends AppCompatActivity {

    public static String code = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_code);

        ImageView back = (ImageView) findViewById(R.id.back);
        EditText et1 = (EditText) findViewById(R.id.et_pwd1);
        EditText et2 = (EditText) findViewById(R.id.et_pwd2);
        EditText et3 = (EditText) findViewById(R.id.et_pwd3);
        EditText et4 = (EditText) findViewById(R.id.et_pwd4);
        Button save = (Button) findViewById(R.id.save);


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

        code += et1.getText();
        code += et2.getText();
        code += et3.getText();
        code += et4.getText();


        // 저장하기 버튼 누르면
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // db에 설정한 비밀번호 저장
                String sql = "UPDATE user" + "SET" + "password=" + code + "WHERE _id=" + LoginActivity.userId;
                db.execSQL(sql);

                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });
    }
}
