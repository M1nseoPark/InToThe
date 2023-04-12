package com.example.intothe.controller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.R;
import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.controller.MainActivity;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class TrainEnd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_end);

        final KonfettiView konfettiView = findViewById(R.id.viewKonfetti);
        Button next = (Button) findViewById(R.id.next);
        TextView talk = (TextView) findViewById(R.id.talk);

        talk.setText(LoginActivity.userName.substring(1,3) + "(아)야 오늘 훈련을 모두 끝냈어!\n수고 많았어 정말\n내가 축하해줄게! 화면을 한번 클릭해봐");

        // 꽃가루
        konfettiView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                konfettiView.build()
                        .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                        .setDirection(0.0, 359.0)
                        .setSpeed(1f, 3f)
                        .setFadeOutEnabled(true)
                        .setTimeToLive(1500L)
                        .addShapes(Shape.RECT, Shape.CIRCLE)
                        .addSizes(new Size(11, 5))
                        .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
                        .streamFor(250, 5000L);

                talk.setText("내일 또 보자~~");
            }
        });


        // 메인 화면으로 이동
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
