package com.example.intothe.MyPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.R;

public class TestReport1 extends AppCompatActivity {

    public static int yearR;
    public static int monthR;
    public static int dayR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_report_1);

        CalendarView calendarView = findViewById(R.id.calendarView);
        TextView tvDate = findViewById(R.id.tvDate);
        TextView tvDetail = (TextView) findViewById(R.id.tvDetail);

        // 선택한 날짜로 텍스트뷰 바꾸기
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                yearR = year;
                monthR = month + 1;
                dayR = day;

                month += 1;
                tvDate.setText(String.format("%d월 %d일", month, day));
            }
        });


        // 자세한 보고서로 이동
        tvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TestReport2.class);
                startActivity(intent);
            }
        });
    }


}
