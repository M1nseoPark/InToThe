package com.example.intothe.controller.ChangeFace1;

import static com.example.intothe.controller.ChangeFace1.ChangeFace11.stResult;
import static com.example.intothe.controller.ChangeFace1.ChangeFace11.rcResult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.controller.ChangeFace2.ChangeFace21;
import com.example.intothe.R;
import com.example.intothe.controller.TestPick;
import com.example.intothe.databinding.ChangeFace12Binding;

public class ChangeFace12 extends AppCompatActivity {

    public static String rcResult2 = rcResult;   // 모델 인식 결과
    private ChangeFace12Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ChangeFace12Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 맞았을 때
        if (rcResult2.equals(stResult)) {
            binding.gom.setImageResource(R.drawable.gom_happy);
            TestPick.right += 1;

            if (stResult.equals("분노") || stResult.equals("상처") || stResult.equals("불안") || stResult.equals("슬픔")) {
                binding.tvFeedback.setText("정답이야!" + stResult + "을(를) 표현할 수 있는 네가 너무 자랑스러워!\n그런데 혹시 나쁜 일이 있는 건 아니지?");
            }
            else if (stResult.equals("기쁨")) {
                binding.tvFeedback.setText("정답이야! 기쁨을 표현할 수 있는 네가 정말 자랑스러워!\n덕분에 나도 행복해지는걸?");
            }
            else if (stResult.equals("당황")) {
                binding.tvFeedback.setText("정답이야! 당황을 표현할 수 있는 네가 정말 자랑스러워!\n실감나는 네 표정을 보니 나까지 당황했지 뭐야!");
            }
            else if (stResult.equals("중립")) {
                binding.tvFeedback.setText("정답이야! 무표정을 잘 표현했구나!\n다양한 표정을 가진 네가 정말 자랑스러워!\n");
            }
        }
        // 틀렸을 때
        else {
            binding.gom.setImageResource(R.drawable.gom_sad);
            binding.tvFeedback.setText("으음... 지금 네 표정은 '" + rcResult2 + "'인 것 같아.\n다음에 다시 도전해보자!");
            TestPick.wrong += 1;
        }


        // 다음 화면으로 이동 (표정 맞히기)
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChangeFace21.class);
                startActivity(intent);
            }
        });
    }
}
