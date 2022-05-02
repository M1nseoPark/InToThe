package com.example.intothe.SocialScale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.ChangeFace2.ChangeFace21;
import com.example.intothe.ChangeFace2.ChangeFace22;
import com.example.intothe.R;

public class SocialScale4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_scale_4);

        TextView tvFeedback = (TextView)findViewById(R.id.tvFeedback);
        Button next = (Button) findViewById(R.id.next);


        // 사용자의 답변에 대한 피드백
        if (SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getAnswer() == 1) {
            if (SocialScale3.value1 >= 80) {
                tvFeedback.setText("잘했어! (이름)아. 내 생각도 너랑 같아");
            }
            else {
                tvFeedback.setText(SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getFeedback());
            }
        }
        else {
            if (SocialScale3.value2 >= 80) {
                tvFeedback.setText("잘했어! (이름)아. 내 생각도 너랑 같아");
            }
            else {
                tvFeedback.setText(SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getFeedback());
            }
        }


        // 버튼 누르면 다음 화면으로 이동
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ChangeFace21.number < 3) {
                    ChangeFace21.number += 1;
                    Intent intent = new Intent(getApplicationContext(), SocialScale2.class);
                    startActivity(intent);
                }
            }
        });
    }
}
