package com.example.intothe.SettingGreet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.Login.RegisterActivity;
import com.example.intothe.R;

public class SettingGreet extends AppCompatActivity {

    public static String greeting = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_greet);

        EditText editText = (EditText) findViewById(R.id.greeting);

        greeting = editText.getText().toString();
        if (greeting.length() == 0) {
            Toast.makeText(SettingGreet.this, "인사말을 입력해주세요", Toast.LENGTH_SHORT).show();
        }

    }
}
