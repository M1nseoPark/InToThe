package com.example.intothe.controller.FaceExpand;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.controller.MainActivity;
import com.example.intothe.model.ReportDBHelper;
import com.example.intothe.controller.SocialScale.SocialScale1;
import com.example.intothe.controller.TrainEnd;
import com.example.intothe.databinding.FaceExpand2Binding;

public class FaceExpand2 extends AppCompatActivity {

    public static String rcResult3 = FaceExpand1.rcResult;   // 모델 인식 결과
    private FaceExpand2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FaceExpand2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // db start
        ReportDBHelper myDb = new ReportDBHelper(FaceExpand2.this);
        SQLiteDatabase db = myDb.getWritableDatabase();


        if (rcResult3.equals("Face")) {
            binding.tvFeedback.setText("사과 같은 " + LoginActivity.userName.substring(1,3) + "(이)의 얼굴 예쁘기도 하지요~~ 눈도 반짝 코도 반짝 입도 반짝반짝~~");
            if (MainActivity.mode == 0) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial2='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent2='" + LoginActivity.userName + "님의 얼굴을 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
            else if (MainActivity.mode == 1) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial1='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent1='" + LoginActivity.userName + "님의 얼굴을 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
            else if (MainActivity.mode == 2) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial3='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent3='" + LoginActivity.userName + "님의 얼굴을 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
        }
        else if (rcResult3.equals("Eye")) {
            binding.tvFeedback.setText(LoginActivity.userName.substring(1,3) + "(이)의 예쁜 두 눈을 찍었구나! 호기심 가득한 빛나는 눈을 보니 나까지 행복해졌어~!");
            if (MainActivity.mode == 0) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial2='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent2='" + LoginActivity.userName + "님의 눈을 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
            else if (MainActivity.mode == 1) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial1='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent1='" + LoginActivity.userName + "님의 눈을 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
            else if (MainActivity.mode == 2) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial3='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent3='" + LoginActivity.userName + "님의 눈을 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
        }
        else if (rcResult3.equals("Nose")) {
            binding.tvFeedback.setText("우와 " + LoginActivity.userName.substring(1,3) + "(이)의 코는 정말 곧게 뻗었다! 꺅, 너의 날카로운 콧날에 베일 것만 같아~");
            if (MainActivity.mode == 0) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial2='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent2='" + LoginActivity.userName + "님의 코를 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
            else if (MainActivity.mode == 1) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial1='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent1='" + LoginActivity.userName + "님의 코를 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
            else if (MainActivity.mode == 2) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial3='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent3='" + LoginActivity.userName + "님의 코를 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
        }
        else if (rcResult3.equals("Mouth")) {
            binding.tvFeedback.setText("이건 " + LoginActivity.userName.substring(1,3) + "(이)의 앵두 같은 입술이네? " + LoginActivity.userName.substring(1,3) + "(아)야 나를 위해 미소 한번 지어줘!!");
            if (MainActivity.mode == 0) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial2='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent2='" + LoginActivity.userName + "님의 입을 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
            else if (MainActivity.mode == 1) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial1='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent1='" + LoginActivity.userName + "님의 입을 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
            else if (MainActivity.mode == 2) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial3='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent3='" + LoginActivity.userName + "님의 입을 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
        }
        else if (rcResult3.equals("Ear")) {
            binding.tvFeedback.setText(LoginActivity.userName.substring(1,3) + "(이)의 귀는 이렇게 생겼구나! 부럽다... 내 귀는 너무 뭉툭한데...ㅠㅠ");
            if (MainActivity.mode == 0) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial2='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent2='" + LoginActivity.userName + "님의 귀를 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
            else if (MainActivity.mode == 1) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial1='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent1='" + LoginActivity.userName + "님의 귀를 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
            else if (MainActivity.mode == 2) {
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainSpecial3='true' WHERE trainDate='" + MainActivity.trainDate + "';");
                db.execSQL("UPDATE report" + LoginActivity.userId + " SET trainContent3='" + LoginActivity.userName + "님의 귀를 칭찬해주었습니다' WHERE trainDate='" + MainActivity.trainDate + "';");
            }
        }

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.mode == 0) {
                    Intent intent = new Intent(getApplicationContext(), SocialScale1.class);
                    startActivity(intent);
                }
                else if (MainActivity.mode == 1) {
                    Intent intent = new Intent(getApplicationContext(), SocialScale1.class);
                    startActivity(intent);
                }
                else if (MainActivity.mode == 2) {
                    Intent intent = new Intent(getApplicationContext(), TrainEnd.class);
                    startActivity(intent);
                }
            }
        });
    }
}
