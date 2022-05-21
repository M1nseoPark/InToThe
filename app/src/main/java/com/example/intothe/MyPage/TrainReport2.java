package com.example.intothe.MyPage;

import static com.example.intothe.MyPage.TrainReport1.dayR;
import static com.example.intothe.MyPage.TrainReport1.monthR;
import static com.example.intothe.MyPage.TrainReport1.trainContent1;
import static com.example.intothe.MyPage.TrainReport1.trainContent2;
import static com.example.intothe.MyPage.TrainReport1.trainContent3;
import static com.example.intothe.MyPage.TrainReport1.trainDate;
import static com.example.intothe.MyPage.TrainReport1.trainName1;
import static com.example.intothe.MyPage.TrainReport1.trainName2;
import static com.example.intothe.MyPage.TrainReport1.trainName3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.R;
import com.example.intothe.ReportDBHelper;

public class TrainReport2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_report_2);

        TextView tvDate = (TextView) findViewById(R.id.tvDate);
        TextView tvTrainName1 = (TextView) findViewById(R.id.tvTrainName1);
        TextView tvTrainDetail1 = (TextView) findViewById(R.id.tvTrainDetail1);
        TextView tvTrainName2 = (TextView) findViewById(R.id.tvTrainName2);
        TextView tvTrainDetail2 = (TextView) findViewById(R.id.tvTrainDetail2);
        TextView tvTrainName3 = (TextView) findViewById(R.id.tvTrainName3);
        TextView tvTrainDetail3 = (TextView) findViewById(R.id.tvTrainDetail3);
        Button btFinish = (Button) findViewById(R.id.btFinish);


        // 제목 설정
        tvDate.setText(String.format("%d월 %d일\n훈련 보고서", monthR, dayR));
        tvTrainName1.setText(trainName1);
//        tvTrainDetail1.setText(trainContent1);
        tvTrainName2.setText(trainName2);
//        tvTrainDetail2.setText(trainContent2);
        tvTrainName3.setText(trainName3);
//        tvTrainDetail3.setText(trainContent3);


        // 확인 버튼
        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TrainReport1.class);
                startActivity(intent);
            }
        });
    }
}
