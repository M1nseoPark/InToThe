package com.example.intothe.SocialScale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.R;

import java.util.ArrayList;
import java.util.Random;


public class SocialScale1 extends AppCompatActivity {

    public static ArrayList<Integer> pick = new ArrayList<Integer>();
    public static int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_scale_1);

        Button button = (Button) findViewById(R.id.next);
        TextView talk = (TextView) findViewById(R.id.talk);

        talk.setText(LoginActivity.userName.substring(1,3) + "아(야) 내가 몇 가지 이야기를 해줄게.\n너는 내 이야기를 듣고 두 가지 단어 중\n어느 쪽에 얼마나 가깝다고 생각하는지\n표시해줘!");

        // 문제 랜덤 선택
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            pick.add(rand.nextInt(10));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SocialScale2.class);
                startActivity(intent);
            }
        });
    }
}
