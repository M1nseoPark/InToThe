package com.example.intothe.controller.SpeakFeeling;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.R;
import com.example.intothe.databinding.ActivityRouletteBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class Roulette extends AppCompatActivity {
    private CircleManager circleManager;
    private RelativeLayout layoutRoulette;

    private Button btnRotate;
    public static TextView result;
    private int number;

    private ArrayList<String> STRINGS;
    private float initAngle = 0.0f;
    private int num_roulette;

    public static String stResult;   // 룰렛 결과
    public static int time = 0;   // 몇번 시도했는지
    public static String report;   // 훈련 보고서에 들어갈 내용
    public static String special;   // 훈련 보고서에 들어갈 내용

    private ActivityRouletteBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRouletteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        number = 6;
        result = findViewById(R.id.result);
        btnRotate = findViewById(R.id.btnRotate);
        layoutRoulette = findViewById(R.id.layoutRoulette);

        num_roulette = number;
        STRINGS = new ArrayList<>(Arrays.asList("분노", "상처", "당황", "기쁨", "슬픔", "불안"));
        circleManager = new CircleManager(Roulette.this, num_roulette);
        layoutRoulette.addView(circleManager);


        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotateLayout(layoutRoulette, num_roulette);
            }
        });

        // 다음 버튼
        Button button = (Button) findViewById(R.id.next);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stResult = binding.result.getText().toString();
                System.out.println(stResult);
                if (stResult.equals("선택된 감정은?")) {
                    Toast.makeText(getApplicationContext(), "룰렛을 먼저 돌려주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    Roulette.report = stResult + " 감정에 대해 이야기 하였습니다\n";

                    Intent intent = new Intent(getApplicationContext(), SpeakFeeling2.class);
                    startActivity(intent);
                }
            }
        });
    }

    // 뒤로가기 버튼 눌렀을때, 홈화면으로 이동하기
//    @Override
//    public void onBackPressed() {
//        Intent intent = new Intent(Roulette.this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
//        finish();
//    }


    /* Rotate roulette */
    public void rotateLayout(final RelativeLayout layout, final int num) {
        final float fromAngle = getRandom(360) + 3600 + initAngle;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getResult(fromAngle, num); // start when animation complete
            }
        }, 3000);

        RotateAnimation rotateAnimation = new RotateAnimation(initAngle, fromAngle,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.anim.accelerate_decelerate_interpolator));
        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillEnabled(true);
        rotateAnimation.setFillAfter(true);
        layout.startAnimation(rotateAnimation);
    }

    /* Set numbers on roulette to random */
    public ArrayList<String> setRandom(int maxNumber, int num) {
        ArrayList<String> strings = new ArrayList<>();

        double r = Math.random();

        for (int i = 0; i < num; i++) {
            int rand = (int) (r * maxNumber);
            strings.add(String.valueOf(rand));
            r = Math.random();
        }

        return strings;
    }

    // get Angle to random
    private int getRandom(int maxNumber) {
        double r = Math.random();
        return (int)(r * maxNumber);
    }


    /* Choose one out of the 2-6 sections */
    private void getResult(float angle, int num_roulette) {
        String text = "";
        angle = angle % 360;

        Log.d("roulette", "getResult : " + angle);

        if (num_roulette == 2) {
            if (angle > 270 || angle <= 90) {
                text = STRINGS.get(1);
//                buildAlert(text);
            } else if (angle > 90 && angle <= 270) {
                text = STRINGS.get(0);
//                buildAlert(text);
            }

        } else if (num_roulette == 3) {
            if (angle > 270 || angle <= 30) {
                text = STRINGS.get(2);
//                buildAlert(text);
            } else if (angle > 30 && angle <= 150) {
                text = STRINGS.get(1);
//                buildAlert(text);
            } else if (angle > 150 && angle <= 270) {
                text = STRINGS.get(0);
//                buildAlert(text);
            }

        } else if (num_roulette == 4) {
            if (angle > 360 || angle <= 90) {
                text = STRINGS.get(2);
//                buildAlert(text);
            } else if (angle > 90 && angle <= 180) {
                text = STRINGS.get(1);
//                buildAlert(text);
            } else if (angle > 180 && angle <= 270) {
                text = STRINGS.get(0);
//                buildAlert(text);
            } else if (angle > 270 && angle <= 360) {
                text = STRINGS.get(3);
//                buildAlert(text);
            }

        } else if (num_roulette == 5) {
            if (angle > 342 || angle <= 54) { // 11   2
                text = STRINGS.get(3);
//                buildAlert(text);
            } else if (angle > 54 && angle <= 126) { // 333   3
                text = STRINGS.get(2);
//                buildAlert(text);
            } else if (angle > 126 && angle <= 198) { // 222   4
                text = STRINGS.get(1);
//                buildAlert(text);
            } else if (angle > 198 && angle <= 270) { // 111    0
                text = STRINGS.get(0);
//                buildAlert(text);
            } else if (angle > 270 && angle <= 342) { // 22     1
                text = STRINGS.get(4);
//                buildAlert(text);
            }

        } else if (num_roulette == 6) {
            if (angle > 330 || angle <= 30) { // 22
                text = STRINGS.get(4);
//                buildAlert(text);
            } else if (angle > 30 && angle <= 90) { // 11
                text = STRINGS.get(3);
//                buildAlert(text);
            } else if (angle > 90 && angle <= 150) { // 333
                text = STRINGS.get(2);
//                buildAlert(text);
            } else if (angle > 150 && angle <= 210) { // 222
                text = STRINGS.get(1);
//                buildAlert(text);
            } else if (angle > 210 && angle <= 270) { // 111
                text = STRINGS.get(0);
//                buildAlert(text);
            } else if (angle > 270 && angle <= 330) { // 3
                text = STRINGS.get(5);
//                buildAlert(text);
            }
        }
        binding.result.setText(text);
    }

    // if you want use AlertDialog then use this
//    private void buildAlert(String text) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("메뉴 추천 결과!")
//                .setMessage(text)
//                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        layoutRoulette.setRotation(360 - initAngle);
//                        konfettiView.build()
//                                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
//                                .setDirection(0.0, 359.0)
//                                .setSpeed(1f, 3f)
//                                .setFadeOutEnabled(true)
//                                .setTimeToLive(1500L)
//                                .addShapes(Shape.RECT, Shape.CIRCLE)
//                                .addSizes(new Size(11, 5))
//                                .setPosition(-50f, konfettiView.getWidth() + 50f, -50f, -50f)
//                                .streamFor(250, 5000L);
//                    }
//
//                });
//
//
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//    }

    public class CircleManager extends View {
        private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        private int[] COLORS = {Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.GRAY};
        private int num;

        public CircleManager(Context context, int num) {
            super(context);
            this.num = num;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int width = layoutRoulette.getWidth();
            int height = layoutRoulette.getHeight();
            int sweepAngle = 360 / num;

            RectF rectF = new RectF(0, 0, width, height);
            Rect rect = new Rect(0, 0, width, height);

            int centerX = (rect.left + rect.right) / 2;
            int centerY = (rect.top + rect.bottom) / 2;
            int radius = (rect.right - rect.left) / 2;

            int temp = 0;

            for (int i = 0; i < num; i++) {
                paint.setColor(COLORS[i]);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setAntiAlias(true);
                paint.setTextAlign(Paint.Align.CENTER);
                canvas.drawArc(rectF, temp, sweepAngle, true, paint);

                float medianAngle = (temp + (sweepAngle / 2f)) * (float) Math.PI / 180f;

                paint.setColor(Color.BLACK);
                paint.setTextSize(64);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);

                float arcCenterX = (float) (centerX + (radius * Math.cos(medianAngle))); // Arc's center X
                float arcCenterY = (float) (centerY + (radius * Math.sin(medianAngle))); // Arc's center Y

                // put text at middle of Arc's center point and Circle's center point
                float textX = (centerX + arcCenterX) / 2;
                float textY = (centerY + arcCenterY) / 2;

                canvas.drawText(STRINGS.get(i), textX, textY, paint);
                temp += sweepAngle;
            }
        }
    }
}
