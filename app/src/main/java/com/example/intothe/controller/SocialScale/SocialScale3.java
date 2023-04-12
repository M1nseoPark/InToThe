package com.example.intothe.controller.SocialScale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.databinding.SocialScale3Binding;

public class SocialScale3 extends AppCompatActivity {

    public static int value1;
    public static int value2;

    private SocialScale3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SocialScale3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        value1 = 0;
        value2 = 100;

        binding.tvExam1.setText(SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getExam1());
        binding.tvExam2.setText(SocialScale2.array.get(SocialScale1.pick.get(SocialScale1.number)).getExam2());

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SocialScale4.class);
                startActivity(intent);
            }
        });
    }

    public void onClick1(View v) {
        value1 = value1 + 20;
        value2 = value2 - 20;
        binding.progressExam1.setProgress(value1);
        binding.progressExam2.setProgress(value2);
    }
    public void onClick2(View v) {
        value1 = value1 - 20;
        value2 = value2 + 20;
        binding.progressExam1.setProgress(value1);
        binding.progressExam2.setProgress(value2);
    }
}
