package com.example.intothe.controller.SocialScale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.databinding.SocialScale1Binding;

import java.util.ArrayList;
import java.util.Random;


public class SocialScale1 extends AppCompatActivity {

    public static ArrayList<Integer> pick = new ArrayList<Integer>();
    public static int number = 0;
    public static String report;   // 훈련 보고서에 들어갈 내용
    public static String special;   // 훈련 보고서에 들어갈 내용

    private SocialScale1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SocialScale1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        report = "";
        special = "";

        binding.talk.setText(LoginActivity.userName.substring(1,3) + "아(야)! 내가 몇 가지 이야기를 해줄게.\n너는 내 이야기를 듣고 두 가지 단어 중\n어느 쪽에 얼마나 가깝다고 생각하는지\n표시해줘!");

        // 문제 랜덤 선택
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            pick.add(rand.nextInt(10));
        }

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SocialScale2.class);
                startActivity(intent);
            }
        });
    }
}
