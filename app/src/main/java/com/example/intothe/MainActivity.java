package com.example.intothe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.amitshekhar.DebugDB;
import com.example.intothe.SocialScale.SocialScale2;
import com.example.intothe.Test.TestList;
import com.example.intothe.Test.TestListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 사회성 척도 기록
//    public static int[] finish = {100, 100, 100};
//    public static int time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DebugDB.getAddressLog();

        Button testButton = (Button) findViewById(R.id.testButton);
        Button myPage = (Button) findViewById(R.id.myPage);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TestListView.class);
                startActivity(intent);
            }
        });

    }
}