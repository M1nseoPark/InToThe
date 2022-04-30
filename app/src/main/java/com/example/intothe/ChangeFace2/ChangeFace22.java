package com.example.intothe.ChangeFace2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.R;
import com.example.intothe.SocialScale.SocialScale2;

public class ChangeFace22 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_face_22);

        Button exam1 = (Button) findViewById(R.id.exam1);
        Button exam2 = (Button) findViewById(R.id.exam2);
        Button exam3 = (Button) findViewById(R.id.exam3);
        Button exam4 = (Button) findViewById(R.id.exam4);

        exam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exam1.setSelected(true);
                exam2.setSelected(false);
                exam3.setSelected(false);
                exam4.setSelected(false);
            }
        });

        exam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exam1.setSelected(false);
                exam2.setSelected(true);
                exam3.setSelected(false);
                exam4.setSelected(false);
            }
        });

        exam3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exam1.setSelected(false);
                exam2.setSelected(false);
                exam3.setSelected(true);
                exam4.setSelected(false);
            }
        });

        exam4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exam1.setSelected(false);
                exam2.setSelected(false);
                exam3.setSelected(false);
                exam4.setSelected(true);
            }
        });
    }
}
