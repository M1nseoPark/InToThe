package com.example.intothe.ChangeFace2;

import static com.example.intothe.ChangeFace2.ChangeFace21.pick;
import static com.example.intothe.ChangeFace2.ChangeFace22.questions;

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
import com.example.intothe.TestPick;

public class ChangeFace23 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_face_23);

        TextView tvFeedback = (TextView) findViewById(R.id.tvFeedback);
        Button next = (Button) findViewById(R.id.next);
        ImageView gom = (ImageView) findViewById(R.id.gom);


        // 정답 피드백
        if (ChangeFace22.choose.equals(questions.get(pick.get(ChangeFace21.number)).getAnswer())) {
            tvFeedback.setText("잘했어! 이렇게 하면 돼\n역시 "+ LoginActivity.userName.substring(1,3) + "는 최고야");
            TestPick.right += 1;
        }
        else {
            gom.setImageResource(R.drawable.gom_sad);
            tvFeedback.setText("땡! 정답은 " + questions.get(pick.get(ChangeFace21.number)).getAnswer() + "이야.\n다음에는 꼭 맞추자! 화이팅~!");
            TestPick.wrong += 1;
        }


        // 버튼 누르면 다음 화면으로 이동
        next.setOnClickListener(new View.OnClickListener() {
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
