package com.example.intothe.controller.SettingGreet;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.model.UserDBHelper;
import com.example.intothe.databinding.SettingGreetBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SettingGreet extends AppCompatActivity {

    public static String greeting;
    public static String gesture;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM");

    private SettingGreetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SettingGreetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // db start
        UserDBHelper myDb = new UserDBHelper(SettingGreet.this);
        SQLiteDatabase db = myDb.getWritableDatabase();

        binding.highfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.highfiveHeart.setSelected(true);
                binding.saluteHeart.setSelected(false);
                binding.hiHeart.setSelected(false);
                binding.cheekHeart.setSelected(false);

                gesture = "highfive";
            }
        });

        binding.salute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.highfiveHeart.setSelected(false);
                binding.saluteHeart.setSelected(true);
                binding.hiHeart.setSelected(false);
                binding.cheekHeart.setSelected(false);

                gesture = "salute";
            }
        });

        binding.hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.highfiveHeart.setSelected(false);
                binding.saluteHeart.setSelected(false);
                binding.hiHeart.setSelected(true);
                binding.cheekHeart.setSelected(false);

                gesture = "hi";
            }
        });

        binding.cheek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.highfiveHeart.setSelected(false);
                binding.saluteHeart.setSelected(false);
                binding.hiHeart.setSelected(false);
                binding.cheekHeart.setSelected(true);

                gesture = "cheek";
            }
        });


        // 완료 버튼 누르면
        binding.finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                greeting = binding.etGreeting.getText().toString().trim();

                if (greeting.length() == 0) {
                    Toast.makeText(SettingGreet.this, "인사말을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    // 설정 날짜 가져오기
                    mNow = System.currentTimeMillis();
                    mDate = new Date(mNow);


                    // db에 새로 설정한 인사 저장
                    db.execSQL("UPDATE user SET word='" + greeting + "' WHERE _id='" + LoginActivity.userId + "';");

                    db.execSQL("UPDATE user SET gesture='" + gesture + "'WHERE _id='" + LoginActivity.userId + "';");

                    db.execSQL("UPDATE user SET settingDate='" + mFormat.format(mDate)  + "'WHERE _id='" + LoginActivity.userId +"';");

                    myDb.close();
                    db.close();


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
            }
        });
    }
}
