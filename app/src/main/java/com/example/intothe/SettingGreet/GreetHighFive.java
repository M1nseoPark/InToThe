package com.example.intothe.SettingGreet;

import static com.example.intothe.MainActivity.trainDate;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.FaceExpand.FaceExpand1;
import com.example.intothe.Login.LoginActivity;
import com.example.intothe.MainActivity;
import com.example.intothe.R;
import com.example.intothe.ReportDBHelper;
import com.example.intothe.SocialScale.SocialScale1;
import com.example.intothe.SpeakFeeling.Roulette;
import com.example.intothe.UserDBHelper;

import java.util.Random;

public class GreetHighFive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greet_highfive);

        TextView tvGreeting = (TextView) findViewById(R.id.tvGreeting);
        Button btHand1 = (Button) findViewById(R.id.btHand1);
        Button btHand2 = (Button) findViewById(R.id.btHand2);


        String stGreeting = "";

        // db start
        UserDBHelper myDb = new UserDBHelper(GreetHighFive.this);
        SQLiteDatabase db = myDb.getReadableDatabase();
        ReportDBHelper myDb2 = new ReportDBHelper(GreetHighFive.this);

        String sql = "select * from user where _id=" + LoginActivity.userId;
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            stGreeting = cursor.getString(4);
        }


        // 훈련 랜덤 선택
        Random random = new Random();
        MainActivity.mode = random.nextInt(2);
        if (MainActivity.mode == 0) {
            myDb2.addBook(trainDate, "감정 말하기", null, null, "얼굴 확대하기", null, null, "사회성 척도", null, null);
        }
        else if (MainActivity.mode == 1) {
            myDb2.addBook(trainDate, "얼굴 확대하기", null, null, "사회성 척도", null, null, "감정 말하기", null, null);
        }
        else if (MainActivity.mode == 2) {
            myDb2.addBook(trainDate, "사회성 척도", null, null, "감정 말하기", null, null, "얼굴 확대하기", null, null);
        }

//        myDb2.addBook("2022-05-05", "사회성 척도", "false", null, "감정 말하기", "true", null, "얼굴 확대하기", "true", null);

        myDb.close();
        myDb2.close();
        db.close();
        cursor.close();


        // 인사 진행
        tvGreeting.setText(stGreeting);

        btHand1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (MainActivity.mode == 0) {
//                    Intent intent = new Intent(getApplicationContext(), Roulette.class);
//                    startActivity(intent);
//                }
//                else if (MainActivity.mode == 1) {
//                    Intent intent = new Intent(getApplicationContext(), FaceExpand1.class);
//                    startActivity(intent);
//                }
//                else if (MainActivity.mode == 2) {
//                    Intent intent = new Intent(getApplicationContext(), SocialScale1.class);
//                    startActivity(intent);
//                }
                Intent intent = new Intent(getApplicationContext(), Roulette.class);
                startActivity(intent);
            }
        });

        btHand2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.mode == 0) {
                    Intent intent = new Intent(getApplicationContext(), Roulette.class);
                    startActivity(intent);
                }
                else if (MainActivity.mode == 1) {
                    Intent intent = new Intent(getApplicationContext(), FaceExpand1.class);
                    startActivity(intent);
                }
                else if (MainActivity.mode == 2) {
                    Intent intent = new Intent(getApplicationContext(), SocialScale1.class);
                    startActivity(intent);
                }
            }
        });
    }
}
