package com.example.intothe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.MyPage.MyPage;
import com.example.intothe.SettingGreet.Cheek;
import com.example.intothe.SettingGreet.Hi;
import com.example.intothe.SettingGreet.HighFive;
import com.example.intothe.SettingGreet.Salute;
import com.example.intothe.SettingGreet.StartGreet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM");

    String testDate;
    String settingDate;
    String gesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button trainButton = (Button) findViewById(R.id.trainButton);
        Button testButton = (Button) findViewById(R.id.testButton);
        Button myPageButton = (Button) findViewById(R.id.myPage);


        // 현재 날짜 가져오기
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        testDate = mFormat.format(mDate);
        ArrayList<String> dateList = new ArrayList<String>();   // 테스트를 한 날짜 리스트

        // db start
        UserDBHelper myDb = new UserDBHelper(MainActivity.this);
        SQLiteDatabase db = myDb.getReadableDatabase();

        String sql = "select * from user where _id=" + LoginActivity.userId;
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            gesture = cursor.getString(5);
            settingDate = cursor.getString(6);
        }

        myDb.close();
        db.close();
        cursor.close();


        // 훈련하기 버튼 (한달에 한번 인사 설정하도록 했음)
        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFormat.format(mDate).equals(settingDate)) {
                    if (gesture.equals("highfive")) {
                        Intent intent = new Intent(getApplicationContext(), HighFive.class);
                        startActivity(intent);
                    }
                    else if (gesture.equals("salute")) {
                        Intent intent = new Intent(getApplicationContext(), Salute.class);
                        startActivity(intent);
                    }
                    else if (gesture.equals("hi")) {
                        Intent intent = new Intent(getApplicationContext(), Hi.class);
                        startActivity(intent);
                    }
                    else if (gesture.equals("cheek")) {
                        Intent intent = new Intent(getApplicationContext(), Cheek.class);
                        startActivity(intent);
                    }
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), StartGreet.class);
                    startActivity(intent);
                }
            }
        });

        // 진단하기 버튼
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TestPick.class);
                startActivity(intent);
            }
        });

        // 마이페이지 버튼
        myPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });

    }
}