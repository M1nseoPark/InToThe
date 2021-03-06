package com.example.intothe.ChangeFace2;

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

public class ChangeFace21 extends AppCompatActivity {

    public static ArrayList<Integer> pick = new ArrayList<Integer>();
    public static int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_face_21);

        Button button = (Button) findViewById(R.id.next);
        TextView talk = (TextView) findViewById(R.id.talk);

        talk.setText("이번엔 내가 " + LoginActivity.userName.substring(1,3) + "(이)에게 영상 3개를 보여줄게!\n이게 어떤 감정 상황인지 맞혀 줄래?");

        // 문제 랜덤 선택
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            pick.add(rand.nextInt(20));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChangeFace22.class);
                startActivity(intent);
            }
        });
    }
}
