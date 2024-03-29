package com.example.intothe.controller.ChangeFace2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.databinding.ChangeFace22Binding;
import com.example.intothe.model.ChangeFace2_Question;

import java.util.ArrayList;

public class ChangeFace22 extends AppCompatActivity {

    public static ArrayList<ChangeFace2_Question> questions = new ArrayList<ChangeFace2_Question>();
    public static String choose;
    private ChangeFace22Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ChangeFace22Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        choose = null;

        // 문제와 정답 데이터 추가
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1GLDIaMM5_lj8608NikQYlQrSwpONq4WA", "기쁨"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1dhuCtqkdPEyJWi20E43vpES_FIC2B5s5", "기쁨"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=18RFZFExcVjpdmqR7TFE2aK6NOZe93-9s", "기쁨"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1pAyo930AFnua5fwl8bupL2ELCoh_dxoI", "기쁨"));

        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1pGSr8FbBVI2ShuZZ7rQrlKQl_8eWNyx_", "슬픔"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1bVOoOb9FN1r3IJmCyt5PJjuGoDii2_8Z", "슬픔"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1JGaZYCO9h9SUy3Zitz2ceHw6OmSz-JPM", "슬픔"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1V9D7vfr1084fg4mrGAhc230SkiTQ3ju-", "슬픔"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1ObwWCV4SgTRHSTZTjkaGNPbOPee0xF8M", "슬픔"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=17s-ELOP3U7M90hiK74OKVOaI1bUpRn76", "슬픔"));

        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1TjdrsUFmpSuYsL804kKrJHhDZlYFnTpV", "놀람"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1kiJdhrDPmEJTCnN17O1qxvkPvMmEoIsm", "놀람"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1131-E2XITwLzQ8DNwzpw020ZFze1T6cP", "놀람"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1vOHSCjBsQkHuskJPEF0cMkdwiqimQQMD", "놀람"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1Xis-UIbRQVOS8AAHEUAyCyJ2psYrkDiG", "놀람"));

        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1Le436Z75HKTUpZxFfwGvJL3ys5HtsUYn", "분노"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1pfSI0LfakEmJf0OmzfpYkwowPTRBlVtK", "분노"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=14esgnKlgKREC6EBgADjGZVKlaO1_croK", "분노"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1xZEanHN3aAYV_Tp-BR9801LKq6WoYxqw", "분노"));
        questions.add(new ChangeFace2_Question("http://drive.google.com/uc?export=view&id=1TFps-3SCb0_LD0GJJIN9Gos62d4go97b", "분노"));


        // 문제 비디오 출력
        Uri videoUri = Uri.parse(questions.get(ChangeFace21.pick.get(ChangeFace21.number)).getUrl());
        binding.video.setVideoURI(videoUri);
        binding.video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                binding.video.start();
            }
        });


        // 버튼 선택
        binding.exam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.exam1.setSelected(true);
                binding.exam2.setSelected(false);
                binding.exam3.setSelected(false);
                binding.exam4.setSelected(false);

                choose = "기쁨";
            }
        });

        binding.exam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.exam1.setSelected(false);
                binding.exam2.setSelected(true);
                binding.exam3.setSelected(false);
                binding.exam4.setSelected(false);

                choose = "슬픔";
            }
        });

        binding.exam3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.exam1.setSelected(false);
                binding.exam2.setSelected(false);
                binding.exam3.setSelected(true);
                binding.exam4.setSelected(false);

                choose = "놀람";
            }
        });

        binding.exam4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.exam1.setSelected(false);
                binding.exam2.setSelected(false);
                binding.exam3.setSelected(false);
                binding.exam4.setSelected(true);

                choose = "분노";
            }
        });

        binding.finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 정답을 선택했을 경우
                if (choose != null) {
                    Intent intent = new Intent(getApplicationContext(), ChangeFace23.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "정답을 선택해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
