package com.example.intothe.SocialScale;

import static com.example.intothe.SocialScale.SocialScale1.report;
import static com.example.intothe.SocialScale.SocialScale1.special;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.FaceExpand.FaceExpand2;
import com.example.intothe.Login.LoginActivity;
import com.example.intothe.MainActivity;
import com.example.intothe.R;
import com.example.intothe.ReportDBHelper;
import com.example.intothe.SpeakFeeling.Roulette;
import com.example.intothe.TrainEnd;

public class SocialScale4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_scale_4);

        TextView tvFeedback = (TextView)findViewById(R.id.tvFeedback);
        Button next = (Button) findViewById(R.id.next);
        ImageView gom = (ImageView) findViewById(R.id.gom);

        // db start
        ReportDBHelper myDb = new ReportDBHelper(SocialScale4.this);
        SQLiteDatabase db = myDb.getWritableDatabase();


        // 사용자의 답변에 대한 피드백
        if (SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getAnswer() == 1) {
            if (SocialScale3.value1 >= 80) {
                tvFeedback.setText("잘했어!"+ LoginActivity.userName.substring(1,3) + "아(야)!\n내 생각도 너랑 같아!");
                report += "\"" + SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getSituation() + "\"라는 상황에 대해 \""
                        + SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getExam1() + "\"라고 적절한 응답을 하셨습니다\n";
            }
            else {
                gom.setImageResource(R.drawable.gom_sad);
                tvFeedback.setText(SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getFeedback());

                special = "false";
                report += "\"" + SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getSituation() + "\"라는 상황에 대해 \""
                        + SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getExam2() + "\"라고 부적절한 응답을 하셨습니다\n";
            }
        }
        else {
            if (SocialScale3.value2 >= 80) {
                tvFeedback.setText("잘했어!"+ LoginActivity.userName.substring(1,3) + "아(야)!\n내 생각도 너랑 같아!");
                report += "\"" + SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getSituation() + "\"라는 상황에 대해 \""
                        + SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getExam2() + "\"라고 적절한 응답을 하셨습니다\n";
            }
            else {
                gom.setImageResource(R.drawable.gom_sad);
                tvFeedback.setText(SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getFeedback());

                special = "false";
                report += "\"" + SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getSituation() + "\"라는 상황에 대해 \""
                        + SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getExam1() + "\"라고 부적절한 응답을 하셨습니다\n";
            }
        }


        // 버튼 누르면 다음 화면으로 이동
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 아직 문제 3개를 다 안풀었을 경우
                if (SocialScale1.number < 2) {
                    SocialScale1.number += 1;
                    report += "\n";
                    Intent intent = new Intent(getApplicationContext(), SocialScale2.class);
                    startActivity(intent);
                }

                // 문제 3개를 다 풀었을 경우
                else {
                    Log.v("test", report);
                    if (!special.equals("false")) {
                        special = "true";
                    }

                    // 훈련보고서 db에 기록
                    if (MainActivity.mode == 0) {
                        db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial3='" + special + "' WHERE trainDate='" + MainActivity.trainDate + "';");
                        db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent3='" + report + "' WHERE trainDate='" + MainActivity.trainDate + "';");
                    }
                    else if (MainActivity.mode == 1) {
                        db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial2='" + special + "' WHERE trainDate='" + MainActivity.trainDate + "';");
                        db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent2='" + report + "' WHERE trainDate='" + MainActivity.trainDate + "';");
                    }
                    else if (MainActivity.mode == 2) {
                        db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial1='" + special + "' WHERE trainDate='" + MainActivity.trainDate + "';");
                        db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent1='" + report + "' WHERE trainDate='" + MainActivity.trainDate + "';");
                    }

                    // 다음 훈련으로 이동
                    if (MainActivity.mode == 0) {
                        Intent intent = new Intent(getApplicationContext(), TrainEnd.class);
                        startActivity(intent);
                    }
                    else if (MainActivity.mode == 1) {
                        Intent intent = new Intent(getApplicationContext(), Roulette.class);
                        startActivity(intent);
                    }
                    else if (MainActivity.mode == 2) {
                        Intent intent = new Intent(getApplicationContext(), Roulette.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
