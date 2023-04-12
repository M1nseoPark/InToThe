package com.example.intothe.controller.SettingGreet;

import static com.example.intothe.controller.MainActivity.trainDate;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.controller.FaceExpand.FaceExpand1;
import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.controller.MainActivity;
import com.example.intothe.model.ReportDBHelper;
import com.example.intothe.controller.SocialScale.SocialScale1;
import com.example.intothe.controller.SpeakFeeling.Roulette;
import com.example.intothe.model.UserDBHelper;
import com.example.intothe.databinding.GreetSaluteBinding;

import java.util.Random;

public class GreetSalute extends AppCompatActivity {

    private GreetSaluteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = GreetSaluteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String stGreeting = "";

        // db start
        UserDBHelper myDb = new UserDBHelper(GreetSalute.this);
        SQLiteDatabase db = myDb.getReadableDatabase();
        ReportDBHelper myDb2 = new ReportDBHelper(GreetSalute.this);

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

        myDb.close();
        myDb2.close();
        db.close();
        cursor.close();


        // 인사 진행
        binding.tvGreeting.setText(stGreeting);

        binding.next.setOnClickListener(new View.OnClickListener() {
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
