package com.example.intothe.FaceExpand;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.R;

public class FaceExpand2 extends AppCompatActivity {

    public static String rcResult3;   // 모델 인식 결과

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.face_expand_2);

        TextView tvFeedback = (TextView) findViewById(R.id.tvFeedback);


        if (rcResult3.equals("Face")) {
            tvFeedback.setText("사과 같은 (이름)이의 얼굴 예쁘기도 하지요~~ 눈도 반짝 코도 반짝 입도 반짝반짝");
        }
        else if (rcResult3.equals("Eye")) {
            tvFeedback.setText("(이름)이의 예쁜 두 눈을 찍었구나! 호기심 가득한 빛나는 눈을 보니 나까지 행복해졌어");
        }
        else if (rcResult3.equals("Nose")) {
            tvFeedback.setText("우와 (이름)이의 코는 정말 곧게 뻗었다! 너의 날카로운 콧날에 베일 것만 같아");
        }
        else if (rcResult3.equals("Mouth")) {
            tvFeedback.setText("이건 (이름)이의 앵두 같은 입술이네? (이름)아 나를 위해 미소 한 번 지어줘!!");
        }
        else if (rcResult3.equals("Ear")) {
            tvFeedback.setText("(이름)이의 귀는 이렇게 생겼구나! 부럽다 내 귀는 너무 뭉툭한데 ㅠㅠ");
        }
    }
}
