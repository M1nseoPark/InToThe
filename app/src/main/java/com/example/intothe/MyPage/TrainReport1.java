package com.example.intothe.MyPage;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.Login.LoginActivity;
import com.example.intothe.R;
import com.example.intothe.ReportDBHelper;

import java.util.ArrayList;

public class TrainReport1 extends AppCompatActivity {

    public static int yearR;
    public static int monthR;
    public static int dayR;

    public static String trainDate;
    public static String trainName1;
    String trainSpecial1;
    public static String trainContent1;
    public static String trainName2;
    String trainSpecial2;
    public static String trainContent2;
    public static String trainName3;
    String trainSpecial3;
    public static String trainContent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_report_1);

        CalendarView calendarView = findViewById(R.id.calendarView);
        TextView tvDate = findViewById(R.id.tvDate);
        TextView tvDetail = (TextView) findViewById(R.id.tvDetail);
        ImageView ivTrain1 = (ImageView) findViewById(R.id.ivTrain1);
        TextView tvTrain1 = (TextView) findViewById(R.id.tvTrain1);
        ImageView ivTrain2 = (ImageView) findViewById(R.id.ivTrain2);
        TextView tvTrain2 = (TextView) findViewById(R.id.tvTrain2);
        ImageView ivTrain3 = (ImageView) findViewById(R.id.ivTrain3);
        TextView tvTrain3 = (TextView) findViewById(R.id.tvTrain3);
        LinearLayout llTrain1 = (LinearLayout) findViewById(R.id.llTrain1);
        LinearLayout llTrain2 = (LinearLayout) findViewById(R.id.llTrain2);
        LinearLayout llTrain3 = (LinearLayout) findViewById(R.id.llTrain3);


        // db start
        ReportDBHelper myDb = new ReportDBHelper(TrainReport1.this);
        SQLiteDatabase db = myDb.getReadableDatabase();


        // 선택한 날짜로 텍스트뷰 바꾸기
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                yearR = year;
                monthR = month + 1;
                dayR = day;

                tvDate.setText(String.format("%d월 %d일", monthR, day));

                if (monthR < 10 && dayR < 10) {
                    trainDate = yearR + "-0" + monthR + "-0" + dayR;
                }
                else if (monthR > 10 && dayR < 10) {
                    trainDate = yearR + "-" + monthR + "-0" + dayR;
                }
                else if (monthR < 10 && dayR > 10) {
                    trainDate = yearR + "-0" + monthR + "-" + dayR;
                }
                else {
                    trainDate = yearR + "-" + monthR + "-" + dayR;
                }

                String sql = "select * from report" + LoginActivity.userId + " where trainDate='" + trainDate + "'";
                Cursor cursor = db.rawQuery(sql, null);

                // 날짜에 대한 훈련 기록이 있을 경우
                if (cursor.getCount() != 0) {
                    Log.v("test", "access");
                    while(cursor.moveToNext()){
                        trainName1 = cursor.getString(2);
                        trainSpecial1 = cursor.getString(3);
                        trainContent1 = cursor.getString(4);
                        trainName2 = cursor.getString(5);
                        trainSpecial2 = cursor.getString(6);
                        trainContent2 = cursor.getString(7);
                        trainName3 = cursor.getString(8);
                        trainSpecial3 = cursor.getString(9);
                        trainContent3 = cursor.getString(10);
                    }

                    // DB 레이아웃에 반영
                    tvTrain1.setText(trainName1);
                    tvTrain2.setText(trainName2);
                    tvTrain3.setText(trainName3);

                    if (trainSpecial1.equals("false")) {
                        ivTrain1.setImageResource(R.drawable.circle2);
                    }
                    else if (trainSpecial1.equals("true")) {
                        ivTrain1.setImageResource(R.drawable.circle4);
                    }

                    if (trainSpecial2.equals("false")) {
                        ivTrain2.setImageResource(R.drawable.circle2);
                    }
                    else if (trainSpecial2.equals("true")) {
                        ivTrain2.setImageResource(R.drawable.circle4);
                    }

                    if (trainSpecial3.equals("false")) {
                        ivTrain3.setImageResource(R.drawable.circle2);
                    }
                    else if (trainSpecial3.equals("true")) {
                        ivTrain3.setImageResource(R.drawable.circle4);
                    }

                    // 자세한 보고서로 이동
                    tvDetail.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), TrainReport2.class);
                            startActivity(intent);
                        }
                    });
                }

                // 날짜에 대한 훈련 기록이 없을 경우
                else {
                    llTrain1.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    llTrain2.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    llTrain3.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    tvDetail.setText("");
                    ivTrain1.setImageResource(0);
                    ivTrain2.setImageResource(0);
                    ivTrain3.setImageResource(0);
                    tvTrain1.setText("");
                    tvTrain2.setText("");
                    tvTrain3.setText("");
                }
            }
        });
    }
}
