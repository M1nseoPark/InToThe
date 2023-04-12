package com.example.intothe.controller.ChangeFace2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.controller.MainActivity;
import com.example.intothe.R;
import com.example.intothe.controller.TestPick;
import com.example.intothe.databinding.ChangeFace23Binding;

public class ChangeFace23 extends AppCompatActivity {

    private ChangeFace23Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ChangeFace23Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 정답 피드백
        if (ChangeFace22.choose.equals(ChangeFace22.questions.get(ChangeFace21.pick.get(ChangeFace21.number)).getAnswer())) {
            binding.tvFeedback.setText("잘했어! 이렇게 하면 돼\n역시 "+ LoginActivity.userName.substring(1,3) + "는 최고야");
            TestPick.right += 1;
        }
        else {
            binding.gom.setImageResource(R.drawable.gom_sad);
            binding.tvFeedback.setText("땡! 정답은 " + ChangeFace22.questions.get(ChangeFace21.pick.get(ChangeFace21.number)).getAnswer() + "이야.\n다음에는 꼭 맞추자! 화이팅~!");
            TestPick.wrong += 1;
        }

        // 버튼 누르면 다음 화면으로 이동
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ChangeFace21.number < 2) {
                    ChangeFace21.number += 1;
                    Intent intent = new Intent(getApplicationContext(), ChangeFace22.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
