package com.example.intothe.Test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.intothe.MainActivity;
import com.example.intothe.R;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestListView extends AppCompatActivity {

    TestList testList;
    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_list_view);

        TextView testDate = (TextView) findViewById(R.id.testDate);

        testList = new TestList();

        // 테스트 날짜 가져오기
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        testDate.setText("시행날짜 " + mFormat.format(mDate));


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, testList).commit();

    }

//    // 뒤로가기 버튼 눌렀을때, 홈화면으로 이동하기
//    @Override
//    public void onBackPressed() {
//        Intent intent = new Intent(StoreRecommend.this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        startActivity(intent);
//        finish();
//    }
}
