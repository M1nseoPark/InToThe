package com.example.intothe.controller.MyPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.databinding.MypageBinding;

public class MyPage extends AppCompatActivity {

    private MypageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MypageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.name.setText(LoginActivity.userName);

        binding.btSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingCode.class);
                startActivity(intent);
            }
        });

        binding.btTrainReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TrainReport1.class);
                startActivity(intent);
            }
        });

        binding.btTestReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TestReport.class);
                startActivity(intent);
            }
        });
    }
}
