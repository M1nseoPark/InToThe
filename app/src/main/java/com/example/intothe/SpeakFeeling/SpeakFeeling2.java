package com.example.intothe.SpeakFeeling;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.R;
import com.example.intothe.SocialScale.SocialScale2;

public class SpeakFeeling2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speak_feeling_2);

        TextView talk = (TextView) findViewById(R.id.talk);
        talk.setText(Roulette.stResult + "가(이) 나왔네!\n너는 언제 " + Roulette.stResult + "을(를) 느껴봤어?");

//        Button button = (Button) findViewById(R.id.next);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), SocialScale2.class);
//                startActivity(intent);
//            }
//        });
    }
}
