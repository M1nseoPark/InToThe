package com.example.intothe.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.intothe.R;
import com.example.intothe.controller.ChangeFace1.ChangeFace11;
import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.controller.Test.EnterCode;
import com.example.intothe.model.ResultDBHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TestPick extends AppCompatActivity {

    public static int right;   // 표정 맞히기 맞은 개수
    public static int wrong;   // 표정 맞히기 틀린 개수

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM");

    String testDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_pick);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);


        // 현재 날짜 가져오기
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        testDate = mFormat.format(mDate);
        ArrayList<String> dateList = new ArrayList<String>();   // 테스트를 한 날짜 리스트

        right = 0;
        wrong = 0;


        ResultDBHelper myDb2 = new ResultDBHelper(TestPick.this);
        SQLiteDatabase db2 = myDb2.getReadableDatabase();
        String sql2 = "select * from result" + LoginActivity.userId;
        Cursor cursor2 = db2.rawQuery(sql2, null);

        if (cursor2.getCount() != 0) {
            while(cursor2.moveToNext()){
                dateList.add(cursor2.getString(1));
            }
        }

        myDb2.close();
        db2.close();
        cursor2.close();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dateList.size() == 0) {   // 테스트를 한번도 하지 않은 경우
                    Intent intent = new Intent(getApplicationContext(), EnterCode.class);
                    startActivity(intent);
                }
                else if (dateList.get(dateList.size() - 1).equals(testDate)) {   // 이번달에 테스트를 이미 한 경우
                    Toast.makeText(TestPick.this, "테스트는 한 달에 한 번만 할 수 있습니다.", Toast.LENGTH_SHORT).show();
                }
                else {   // 테스트하고 한달이 지난 경우
                    Intent intent = new Intent(getApplicationContext(), EnterCode.class);
                    startActivity(intent);
                }
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChangeFace11.class);
                startActivity(intent);
            }
        });
    }
}