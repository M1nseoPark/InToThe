package com.example.intothe.SettingGreet;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.R;
import com.example.intothe.UserDBHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SettingGreet extends AppCompatActivity {

    public static String greeting;
    public static String gesture;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_greet);

        EditText etGreeting = (EditText) findViewById(R.id.etGreeting);
        ImageButton highfive = (ImageButton) findViewById(R.id.highfive);
        ImageButton salute = (ImageButton) findViewById(R.id.salute);
        ImageButton hi = (ImageButton) findViewById(R.id.hi);
        ImageButton cheek = (ImageButton) findViewById(R.id.cheek);
        Button highfiveHeart = (Button) findViewById(R.id.highfiveHeart);
        Button saluteHeart = (Button) findViewById(R.id.saluteHeart);
        Button hiHeart = (Button) findViewById(R.id.hiHeart);
        Button cheekHeart = (Button) findViewById(R.id.cheekHeart);
        Button finish = (Button) findViewById(R.id.finish);

        // db start
        UserDBHelper myDb = new UserDBHelper(SettingGreet.this);
        SQLiteDatabase db = myDb.getWritableDatabase();

        highfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                highfiveHeart.setSelected(true);
                saluteHeart.setSelected(false);
                hiHeart.setSelected(false);
                cheekHeart.setSelected(false);

                gesture = "highfive";
            }
        });

        salute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                highfiveHeart.setSelected(false);
                saluteHeart.setSelected(true);
                hiHeart.setSelected(false);
                cheekHeart.setSelected(false);

                gesture = "salute";
            }
        });

        hi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                highfiveHeart.setSelected(false);
                saluteHeart.setSelected(false);
                hiHeart.setSelected(true);
                cheekHeart.setSelected(false);

                gesture = "hi";
            }
        });

        cheek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                highfiveHeart.setSelected(false);
                saluteHeart.setSelected(false);
                hiHeart.setSelected(false);
                cheekHeart.setSelected(true);

                gesture = "cheek";
            }
        });


        // ?????? ?????? ?????????
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                greeting = etGreeting.getText().toString().trim();

                if (greeting.length() == 0) {
                    Toast.makeText(SettingGreet.this, "???????????? ??????????????????", Toast.LENGTH_SHORT).show();
                }
                else {
                    // ?????? ?????? ????????????
                    mNow = System.currentTimeMillis();
                    mDate = new Date(mNow);


                    // db??? ?????? ????????? ?????? ??????
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
