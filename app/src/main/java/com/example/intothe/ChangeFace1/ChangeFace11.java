package com.example.intothe.ChangeFace1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.FaceExpand.PhotoActivity;
import com.example.intothe.R;

import java.util.Random;

public class ChangeFace11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_face_11);

        TextView feeling = (TextView) findViewById(R.id.feeling);

        String[] FeelList = {"분노", "혐오", "두려움", "기쁨", "슬픔", "놀람"};
        Random random = new Random();
        int pick = random.nextInt(FeelList.length - 1);

        feeling.setText(FeelList[pick]);

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
