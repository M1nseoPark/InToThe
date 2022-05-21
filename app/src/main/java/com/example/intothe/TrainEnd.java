package com.example.intothe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
