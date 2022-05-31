package com.example.intothe.SettingGreet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.R;

public class StartGreet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_greet);

        Button next = (Button) findViewById(R.id.next);
        TextView talk = (TextView) findViewById(R.id.talk);

        talk.setText(LoginActivity.userName.substring(1,3) + "아(야)! 나랑 한달 동안 할 특별한\n인사를 정할 시간이야!");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingGreet.class);
                startActivity(intent);
            }
        });
    }
}
