package com.example.intothe.SocialScale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.MainActivity;
import com.example.intothe.R;
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


        // 사용자의 답변에 대한 피드백
        if (SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getAnswer() == 1) {
            if (SocialScale3.value1 >= 80) {
                tvFeedback.setText("잘했어!"+ LoginActivity.userName.substring(1,3) + "아(야). 내 생각도 너랑 같아");
            }
            else {
                gom.setImageResource(R.drawable.gom_sad);
                tvFeedback.setText(SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getFeedback());
            }
        }
        else {
            if (SocialScale3.value2 >= 80) {
                tvFeedback.setText("잘했어!"+ LoginActivity.userName.substring(1,3) + "아(야). 내 생각도 너랑 같아");
            }
            else {
                gom.setImageResource(R.drawable.gom_sad);
                tvFeedback.setText(SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getFeedback());
            }
        }


        // 버튼 누르면 다음 화면으로 이동
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SocialScale1.number < 3) {
                    SocialScale1.number += 1;
                    Intent intent = new Intent(getApplicationContext(), SocialScale2.class);
                    startActivity(intent);
                }
                else {
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
