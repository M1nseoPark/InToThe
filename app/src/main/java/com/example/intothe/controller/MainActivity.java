package com.example.intothe.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.controller.MyPage.MyPage;
import com.example.intothe.controller.SettingGreet.GreetCheek;
import com.example.intothe.controller.SettingGreet.GreetHi;
import com.example.intothe.controller.SettingGreet.GreetHighFive;
import com.example.intothe.controller.SettingGreet.GreetSalute;
import com.example.intothe.controller.SettingGreet.StartGreet;
import com.example.intothe.model.UserDBHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM");
    SimpleDateFormat mFormat2 = new SimpleDateFormat("yyyy-MM-dd");

    public static int mode;   // 훈련 순서
    public static String trainDate;   // 훈련 날짜
    public static String photoMode;
    String testDate;
    String settingDate;
    String gesture;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 현재 날짜 가져오기
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        testDate = mFormat.format(mDate);
        trainDate = mFormat2.format(mDate);
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
        binding.trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFormat.format(mDate).equals(settingDate)) {
                    if (gesture.equals("highfive")) {
                        Intent intent = new Intent(getApplicationContext(), GreetHighFive.class);
                        startActivity(intent);
                    }
                    else if (gesture.equals("salute")) {
                        Intent intent = new Intent(getApplicationContext(), GreetSalute.class);
                        startActivity(intent);
                    }
                    else if (gesture.equals("hi")) {
                        Intent intent = new Intent(getApplicationContext(), GreetHi.class);
                        startActivity(intent);
                    }
                    else if (gesture.equals("cheek")) {
                        Intent intent = new Intent(getApplicationContext(), GreetCheek.class);
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
        binding.testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TestPick.class);
                startActivity(intent);
            }
        });

        // 마이페이지 버튼
        binding.myPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });

    }
}