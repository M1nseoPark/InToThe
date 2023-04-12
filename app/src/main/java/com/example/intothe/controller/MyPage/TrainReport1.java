package com.example.intothe.controller.MyPage;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.controller.Login.LoginActivity;
import com.example.intothe.R;
import com.example.intothe.model.ReportDBHelper;
import com.example.intothe.databinding.TrainReport1Binding;

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

    private TrainReport1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = TrainReport1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // db start
        ReportDBHelper myDb = new ReportDBHelper(TrainReport1.this);
        SQLiteDatabase db = myDb.getReadableDatabase();


        // 선택한 날짜로 텍스트뷰 바꾸기
        binding.calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                yearR = year;
                monthR = month + 1;
                dayR = day;

                binding.tvDate.setText(String.format("%d월 %d일", monthR, day));

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
                    binding.tvTrain1.setText(trainName1);
                    binding.tvTrain2.setText(trainName2);
                    binding.tvTrain3.setText(trainName3);

                    if (trainSpecial1.equals("false")) {
                        binding.ivTrain1.setImageResource(R.drawable.circle2);
                    }
                    else if (trainSpecial1.equals("true")) {
                        binding.ivTrain1.setImageResource(R.drawable.circle4);
                    }

                    if (trainSpecial2.equals("false")) {
                        binding.ivTrain2.setImageResource(R.drawable.circle2);
                    }
                    else if (trainSpecial2.equals("true")) {
                        binding.ivTrain2.setImageResource(R.drawable.circle4);
                    }

                    if (trainSpecial3.equals("false")) {
                        binding.ivTrain3.setImageResource(R.drawable.circle2);
                    }
                    else if (trainSpecial3.equals("true")) {
                        binding.ivTrain3.setImageResource(R.drawable.circle4);
                    }

                    // 자세한 보고서로 이동
                    binding.tvDetail.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), TrainReport2.class);
                            startActivity(intent);
                        }
                    });
                }

                // 날짜에 대한 훈련 기록이 없을 경우
                else {
                    binding.llTrain1.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    binding.llTrain2.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    binding.llTrain3.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    binding.tvDetail.setText("");
                    binding.ivTrain1.setImageResource(0);
                    binding.ivTrain2.setImageResource(0);
                    binding.ivTrain3.setImageResource(0);
                    binding.tvTrain1.setText("");
                    binding.tvTrain2.setText("");
                    binding.tvTrain3.setText("");
                }
            }
        });
    }
}
