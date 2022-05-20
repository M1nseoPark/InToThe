package com.example.intothe.MyPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.R;

public class MyPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        Button btSetting = (Button) findViewById(R.id.btSetting);
        TextView name = (TextView) findViewById(R.id.name);
        Button btTrainReport = (Button) findViewById(R.id.btTrainReport);
        Button btTestReport = (Button) findViewById(R.id.btTestReport);

        name.setText(LoginActivity.userName);

        btSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingCode.class);
                startActivity(intent);
            }
        });

        btTrainReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TrainReport1.class);
                startActivity(intent);
            }
        });

        btTestReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TestReport.class);
                startActivity(intent);
            }
        });
    }
}
