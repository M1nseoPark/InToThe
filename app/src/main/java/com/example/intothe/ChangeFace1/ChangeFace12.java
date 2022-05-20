package com.example.intothe.ChangeFace1;

import static com.example.intothe.ChangeFace1.ChangeFace11.stResult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.ChangeFace2.ChangeFace21;
import com.example.intothe.R;

public class ChangeFace12 extends AppCompatActivity {

    public static String rcResult;   // 모델 인식 결과

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_face_12);

        ImageView gom = (ImageView) findViewById(R.id.gom);
        TextView tvFeedback = (TextView) findViewById(R.id.tvFeedback);
        Button next = (Button) findViewById(R.id.next);


        // 맞았을 때
        if (rcResult.equals(stResult)) {
            gom.setImageResource(R.drawable.gom_happy);

            if (stResult.equals("분노") || stResult.equals("혐오") || stResult.equals("두려움") || stResult.equals("슬픔")) {
                tvFeedback.setText("정답이야!" + stResult + "를 표현할 수 있는 너가 너무 자랑스러워!\n그런데 혹시 나쁜 일이 있는 건 아니지?");
            }
            else if (stResult.equals("기쁨")) {
                tvFeedback.setText("정답이야! 기쁨을 표현할 수 있는 너가 너무 자랑스러워!\n덕분에 나도 행복해지겠는걸?");
            }
            else if (stResult.equals("놀람")) {
                tvFeedback.setText("정답이야! 놀람을 표현할 수 있는 너가 너무 자랑스러워!\n너의 표정을 보고 나까지 깜짝 놀랐어!");
            }
        }
        // 틀렸을 때
        else {
            gom.setImageResource(R.drawable.gom_sad);
            tvFeedback.setText("땡! 너의 표정은 '" + rcResult + "'(이)야\n다음에 다시 도전해보자");
        }


        // 다음 화면으로 이동 (표정 맞히기)
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChangeFace21.class);
                startActivity(intent);
            }
        });
    }
}
