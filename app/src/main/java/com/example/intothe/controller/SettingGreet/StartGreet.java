package com.example.intothe.controller.SettingGreet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.databinding.StartGreetBinding;

public class StartGreet extends AppCompatActivity {

    private StartGreetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = StartGreetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.talk.setText(LoginActivity.userName.substring(1,3) + "아(야)! 나랑 한달 동안 할 특별한\n인사를 정할 시간이야!");

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingGreet.class);
                startActivity(intent);
            }
        });
    }
}
