package com.example.intothe.controller.ChangeFace2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.databinding.ChangeFace21Binding;

import java.util.ArrayList;
import java.util.Random;

public class ChangeFace21 extends AppCompatActivity {

    public static ArrayList<Integer> pick = new ArrayList<Integer>();
    public static int number = 0;

    private ChangeFace21Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ChangeFace21Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.talk.setText("이번엔 내가 " + LoginActivity.userName.substring(1,3) + "(이)에게 영상 3개를 보여줄게!\n이게 어떤 감정 상황인지 맞혀 줄래?");

        // 문제 랜덤 선택
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            pick.add(rand.nextInt(20));
        }

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChangeFace22.class);
                startActivity(intent);
            }
        });
    }
}
