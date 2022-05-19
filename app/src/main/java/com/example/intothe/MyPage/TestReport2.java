package com.example.intothe.MyPage;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.R;

public class TestReport2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_report_2);

        TextView tvDate = (TextView) findViewById(R.id.tvDate);
    }
}
