package com.example.intothe.FaceExpand;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.MainActivity;
import com.example.intothe.PhotoActivity;
import com.example.intothe.R;


public class FaceExpand1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.face_expand_1);

        ImageView btn_photo = (ImageView) findViewById(R.id.btn_photo);
        TextView talk = (TextView) findViewById(R.id.talk);

        MainActivity.photoMode = "FaceExpand";   // PhotoActivity에서 화면 이동을 위해 기록

//        talk.setText(LoginActivity.userName.substring(1,3) + "아(야) 얼굴 확대하기 시간이야.\n카메라 버튼을 누르고 이목구비를 확대해서\n찍어볼래?");
        talk.setText("얼굴 확대하기 시간이야.\n카메라 버튼을 누르고 이목구비를 확대해서\n찍어볼래?");

        btn_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PhotoActivity.class);
                startActivity(intent);
            }
        });
    }


}
