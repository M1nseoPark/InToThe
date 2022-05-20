package com.example.intothe.MyPage;

import static com.example.intothe.MyPage.TrainReport1.dayR;
import static com.example.intothe.MyPage.TrainReport1.monthR;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.R;

public class TrainReport2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_report_2);

        TextView tvDate = (TextView) findViewById(R.id.tvDate);
        Button btFinish = (Button) findViewById(R.id.btFinish);

        tvDate.setText(String.format("%d월 %d일\n훈련 보고서", monthR, dayR));

        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TrainReport1.class);
                startActivity(intent);
            }
        });
    }
}
