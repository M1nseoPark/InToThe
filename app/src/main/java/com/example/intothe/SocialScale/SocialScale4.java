package com.example.intothe.SocialScale;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.R;

public class SocialScale4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_scale_4);

        TextView tvFeedback = (TextView)findViewById(R.id.tvFeedback);

        if (SocialScale2.array.get(SocialScale2.pick).getAnswer() == 1) {
            if (SocialScale3.value1 >= 80) {
                tvFeedback.setText("잘했어! (이름)아. 내 생각도 너랑 같아");
            }
            else {
                tvFeedback.setText("다시 한번 생각해볼래? 엄마 아빠랑 같이\n어느 쪽이 정답일지 이야기해보는 것도\n좋을 것 같아");
            }
        }
        else {
            if (SocialScale3.value2 >= 80) {
                tvFeedback.setText("잘했어! (이름)아. 내 생각도 너랑 같아");
            }
            else {
                tvFeedback.setText("다시 한번 생각해볼래? 엄마 아빠랑 같이\n어느 쪽이 정답일지 이야기해보는 것도\n좋을 것 같아");
            }
        }


//        // 다음 버튼
//        Button button = (Button) findViewById(R.id.next);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), SocialScale4.class);
//                startActivity(intent);
//            }
//        });
    }
}
