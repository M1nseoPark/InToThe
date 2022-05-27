package com.example.intothe.ChangeFace1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.MainActivity;
import com.example.intothe.PhotoActivity;
import com.example.intothe.R;

import java.util.Random;

public class ChangeFace11 extends AppCompatActivity {

    public static String stResult;   // 선택 결과

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_face_11);

        MainActivity.photoMode = "ChangeFace";   // PhotoActivity에서 화면 이동을 위해 기록
        TextView feeling = (TextView) findViewById(R.id.feeling);

        String[] FeelList = {"기쁨", "당황", "분노", "불안", "상처", "슬픔", "중립"};
        Random random = new Random();
        int pick = random.nextInt(FeelList.length - 1);

        stResult = FeelList[pick];
        feeling.setText(stResult);

        ImageView btn_photo = (ImageView) findViewById(R.id.btn_photo);
        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PhotoActivity.class);
                startActivity(intent);
            }
        });
    }
}
