package com.example.intothe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.MyPage.MyPage;
import com.example.intothe.SettingGreet.HighFive;
import com.example.intothe.SettingGreet.Salute;
import com.example.intothe.SettingGreet.StartGreet;
import com.example.intothe.Test.ResultDBHelper;
import com.example.intothe.Test.TestListView;

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
        ArrayList<String> dateList = new ArrayList<String>();

        // db start
        UserDBHelper myDb = new UserDBHelper(MainActivity.this);
        SQLiteDatabase db = myDb.getReadableDatabase();

        String sql = "select * from user where _id=" + LoginActivity.userId;
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            gesture = cursor.getString(5);
            settingDate = cursor.getString(6);
        }

//        ResultDBHelper myDb2 = new ResultDBHelper(MainActivity.this);
//        SQLiteDatabase db2 = myDb2.getReadableDatabase();
//
//        String sql2 = "select * from result" + LoginActivity.userId;
//        Cursor cursor2 = db2.rawQuery(sql2, null);
//        while(cursor.moveToNext()){
//            dateList.add(cursor.getString(1));
//        }

        myDb.close();
        db.close();
//        myDb2.close();
//        db2.close();
        cursor.close();
//        cursor2.close();


        // 훈련하기 버튼
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
                if (dateList.get(dateList.size() - 1).equals(testDate)) {
                    Toast.makeText(MainActivity.this, "테스트는 한 달에 한 번만 할 수 있습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), TestListView.class);
                    startActivity(intent);
                }
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