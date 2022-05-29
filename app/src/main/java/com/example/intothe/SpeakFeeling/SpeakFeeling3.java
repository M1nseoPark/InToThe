package com.example.intothe.SpeakFeeling;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.FaceExpand.FaceExpand1;
import com.example.intothe.Login.LoginActivity;
import com.example.intothe.MainActivity;
import com.example.intothe.R;
import com.example.intothe.ReportDBHelper;
import com.example.intothe.SocialScale.SocialScale4;
import com.example.intothe.TrainEnd;

public class SpeakFeeling3 extends AppCompatActivity {

    boolean move;   // 이동할 페이지 (true은 다음 훈련, false은 입력필드)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speak_feeling_3);

        ImageView gom = (ImageView) findViewById(R.id.gom);
        TextView tvFeedback = (TextView) findViewById(R.id.tvFeedback);
        Button next = (Button) findViewById(R.id.next);


        // db start
        ReportDBHelper myDb = new ReportDBHelper(SpeakFeeling3.this);
        SQLiteDatabase db = myDb.getWritableDatabase();

//        Log.v("test", SpeakFeeling2.rcResult);


        // 슬픔
        if (Roulette.stResult.equals("슬픔")) {
            if (Roulette.stResult.equals(SpeakFeeling2.rcResult)) {
                gom.setImageResource(R.drawable.gom_sad);
                tvFeedback.setText("맞아 정말 슬펐겠다ㅠㅠ");

                move = true;
            }
            else {
                if (Roulette.time == 0) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '슬픔'이 아니라 '" + SpeakFeeling2.rcResult + "'야!\n슬픔은 마음이 아프고 괴로워 눈물이 나는 감정이야. 다시 한 번 슬픔을 느낀 경험을 말해줄래?");

                    Roulette.time += 1;
                    move = false;
                }
                else if (Roulette.time == 1) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '슬픔'이 아니라 '" + SpeakFeeling2.rcResult + "'야!\n어제 내가 주인공이 키우던 강아지가 죽는 영화를 봤는데 너무 슬퍼서 울었어. 다시 한 번 슬픔을 느낀 경험을 말해줄래?");

                    Roulette.time += 1;
                    move = false;
                }
                else if (Roulette.time == 2) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '슬픔'이 아니라 '" + SpeakFeeling2.rcResult + "'야!\n오늘 부모님과 함께 슬픔에 대해서 이야기 해보면 좋을 것 같아!");

                    move = true;
                    Roulette.special = "false";
                }
            }
        }

        // 당황
        else if (Roulette.stResult.equals("당황")) {
            String stResult2 = "불안";
            if (Roulette.stResult.equals(SpeakFeeling2.rcResult) || stResult2.equals(SpeakFeeling2.rcResult)) {
                gom.setImageResource(R.drawable.gom_happy);
                tvFeedback.setText("정말 당황스럽다" + LoginActivity.userName.substring(1,3) + "야 어떻게 그런 일이!!");

                move = true;
            }
            else {
                if (Roulette.time == 0) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '당황'이 아니라 '" + SpeakFeeling2.rcResult + "'야!\n당황은 놀라거나 예상치 못한 일이 생겨서 어찌할 바를 모르는 걸 말해. 다시 한 번 당황했던 경험을 말해줄래?");

                    Roulette.time += 1;
                    move = false;
                }
                else if (Roulette.time == 1) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '당황'이 아니라 '" + SpeakFeeling2.rcResult + "'야!\n난 어제 식당에서 밥 먹다가 돌이 씹혀서 당황했었어. 다시 한 번 당황했던 경험을 말해줄래?");

                    Roulette.time += 1;
                    move = false;
                }
                else if (Roulette.time == 2) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '당황'이 아니라 '" + SpeakFeeling2.rcResult + "'야!\n오늘 부모님과 함께 당황에 대해서 이야기 해보면 좋을 것 같아!");

                    move = true;
                    Roulette.special = "false";
                }
            }
        }

        // 분노
        else if (Roulette.stResult.equals("분노")) {
            String stResult2 = "상처";
            if (Roulette.stResult.equals(SpeakFeeling2.rcResult) || stResult2.equals(SpeakFeeling2.rcResult)) {
                gom.setImageResource(R.drawable.gom_angry);
                tvFeedback.setText("정말 나까지 화가 난다!");

                move = true;
            }
            else {
                if (Roulette.time == 0) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '분노'가 아니라 '" + SpeakFeeling2.rcResult + "'야!\n분노는 화나고 섭섭해서 답답한 감정이 생기는 걸 말해. 다시 한 번 화났던 경험을 말해줄래?");

                    Roulette.time += 1;
                    move = false;
                }
                else if (Roulette.time == 1) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '분노'가 아니라 '" + SpeakFeeling2.rcResult + "'야!\n친구가 내가 아끼는 볼펜을 빌려갔는데 돌려주지 않아서 화가 났어. 다시 한 번 화났던 경험을 말해줄래?");

                    Roulette.time += 1;
                    move = false;
                }
                else if (Roulette.time == 2) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '분노'가 아니라 '" + SpeakFeeling2.rcResult + "'야!\n오늘 부모님과 함께 분노에 대해서 이야기 해보면 좋을 것 같아!");

                    move = true;
                    Roulette.special = "false";
                }
            }
        }

        // 기쁨
        else if (Roulette.stResult.equals("기쁨")) {
            if (Roulette.stResult.equals(SpeakFeeling2.rcResult)) {
                gom.setImageResource(R.drawable.gom_front);
                tvFeedback.setText("너한테 기쁜 일이 생기니까 나까지 기분이 좋아지는걸?");

                move = true;
            }
            else {
                if (Roulette.time == 0) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '기쁨'이 아니라 '" + SpeakFeeling2.rcResult + "'야!\n기쁨은 마음이 흐뭇하고 행복한 감정을 말해. 다시 한 번 기쁨을 느꼈던 경험을 말해줄래?");

                    Roulette.time += 1;
                    move = false;
                }
                else if (Roulette.time == 1) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '기쁨'이 아니라 '" + SpeakFeeling2.rcResult + "'야!\n나는 오늘 수학 시험에서 100점을 받아서 너무 기뻤어. 다시 한 번 기쁨을 느꼈던 경험을 말해줄래?");

                    Roulette.time += 1;
                    move = false;
                }
                else if (Roulette.time == 2) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '기쁨'이 아니라 '" + SpeakFeeling2.rcResult + "'야!\n오늘 부모님과 함께 기쁨에 대해서 이야기 해보면 좋을 것 같아!");

                    move = true;
                    Roulette.special = "false";
                }
            }
        }

        // 상처
        else if (Roulette.stResult.equals("상처")) {
            String stResult2 = "분노";
            if (Roulette.stResult.equals(SpeakFeeling2.rcResult) || stResult2.equals(SpeakFeeling2.rcResult)) {
                gom.setImageResource(R.drawable.gom_angry);
                tvFeedback.setText("그런 일이 있었다니 내가 다 가슴이 아프다ㅠㅠ 그런 기억은 빨리 잊고 훌훌 털어버리자");

                move = true;
            }
            else {
                if (Roulette.time == 0) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '상처'가 아니라 '" + SpeakFeeling2.rcResult + "'야!\n상처는 몸이나 마음이 다친 흔적이 없어지지 않고 남아있는 거야. 다시 한 번 상처 받았던 경험을 말해줄래?");

                    Roulette.time += 1;
                    move = false;
                }
                else if (Roulette.time == 1) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '상처'가 아니라 '" + SpeakFeeling2.rcResult + "'야!\n친구랑 심한 말을 하면서 다투다보면 서로 상처받곤 하지. 다시 한 번 상처 받았던 경험을 말해줄래?");

                    Roulette.time += 1;
                    move = false;
                }
                else if (Roulette.time == 2) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '상처'가 아니라 '" + SpeakFeeling2.rcResult + "'야!\n오늘 부모님과 함께 상처에 대해서 이야기 해보면 좋을 것 같아!");

                    move = true;
                    Roulette.special = "false";
                }
            }
        }

        // 불안
        else if (Roulette.stResult.equals("불안")) {
            String stResult2 = "당황";
            if (Roulette.stResult.equals(SpeakFeeling2.rcResult) || stResult2.equals(SpeakFeeling2.rcResult)) {
                gom.setImageResource(R.drawable.gom_surprise);
                tvFeedback.setText("후하후하 난 불안할 땐 심호흡을 크게 하면 낫더라\n잘될거야 너무 불안해하지마");

                move = true;
            }
            else {
                if (Roulette.time == 0) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '불안'이 아니라 '" + SpeakFeeling2.rcResult + "'야!\n불안은 마음이 편하지 않고 조마조마한 걸 말해. 다시 한 번 불안을 느꼈던 경험을 말해줄래?");

                    Roulette.time += 1;
                    move = false;
                }
                else if (Roulette.time == 1) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '불안'이 아니라 '" + SpeakFeeling2.rcResult + "'야!\n나는 시험 전날만 되면 너무 걱정되고 불안하더라ㅠㅠ 다시 한 번 불안을 느꼈던 경험을 말해줄래?");

                    Roulette.time += 1;
                    move = false;
                }
                else if (Roulette.time == 2) {
                    gom.setImageResource(R.drawable.gom_sad);
                    tvFeedback.setText("너가 말한 감정은 '불안'이 아니라 '" + SpeakFeeling2.rcResult + "'야!\n오늘 부모님과 함께 불안에 대해서 이야기 해보면 좋을 것 같아!");

                    move = true;
                    Roulette.special = "false";
                }
            }
        }


        // 다음 페이지로 이동
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (move) {
                    Roulette.report += "위와 같이 " + LoginActivity.userId + "님은 " + Roulette.time + "번의 시도를 하셨습니다";
                    if (!Roulette.special.equals("false")) {
                        Roulette.special = "true";
                    }

                    // 훈련보고서 db에 기록
                    if (MainActivity.mode == 0) {
                        db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial1='" + Roulette.special + "' WHERE trainDate='" + MainActivity.trainDate + "';");
                        db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent1='" + Roulette.report + "' WHERE trainDate='" + MainActivity.trainDate + "';");
                    }
                    else if (MainActivity.mode == 1) {
                        db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial3='" + Roulette.special + "' WHERE trainDate='" + MainActivity.trainDate + "';");
                        db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent3='" + Roulette.report + "' WHERE trainDate='" + MainActivity.trainDate + "';");
                    }
                    else if (MainActivity.mode == 2) {
                        db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial2='" + Roulette.special + "' WHERE trainDate='" + MainActivity.trainDate + "';");
                        db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent2='" + Roulette.report + "' WHERE trainDate='" + MainActivity.trainDate + "';");
                    }

                    // 다음 훈련으로 이동
                    if (MainActivity.mode == 0) {
                        Intent intent = new Intent(getApplicationContext(), FaceExpand1.class);
                        startActivity(intent);
                    }
                    else if (MainActivity.mode == 1) {
                        Intent intent = new Intent(getApplicationContext(), TrainEnd.class);
                        startActivity(intent);
                    }
                    else if (MainActivity.mode == 2) {
                        Intent intent = new Intent(getApplicationContext(), FaceExpand1.class);
                        startActivity(intent);
                    }
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), SpeakFeeling2.class);
                    startActivity(intent);
                }
            }
        });
    }
}
