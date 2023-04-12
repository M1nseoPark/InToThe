package com.example.intothe.controller.MyPage;

import static com.example.intothe.controller.MyPage.TrainReport1.dayR;
import static com.example.intothe.controller.MyPage.TrainReport1.monthR;
import static com.example.intothe.controller.MyPage.TrainReport1.trainContent1;
import static com.example.intothe.controller.MyPage.TrainReport1.trainContent2;
import static com.example.intothe.controller.MyPage.TrainReport1.trainContent3;
import static com.example.intothe.controller.MyPage.TrainReport1.trainName1;
import static com.example.intothe.controller.MyPage.TrainReport1.trainName2;
import static com.example.intothe.controller.MyPage.TrainReport1.trainName3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.databinding.TrainReport2Binding;

public class TrainReport2 extends AppCompatActivity {

    private TrainReport2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = TrainReport2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 제목 설정
        binding.tvDate.setText(String.format("%d월 %d일\n훈련 보고서", monthR, dayR));
        binding.tvTrainName1.setText(trainName1);
        binding.tvTrainDetail1.setText(trainContent1);
        binding.tvTrainName2.setText(trainName2);
        binding.tvTrainDetail2.setText(trainContent2);
        binding.tvTrainName3.setText(trainName3);
        binding.tvTrainDetail3.setText(trainContent3);

        // 확인 버튼
        binding.btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TrainReport1.class);
                startActivity(intent);
            }
        });
    }
}
