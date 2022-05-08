package com.example.intothe.Test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestListView extends AppCompatActivity {

    TestList testList;
    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static int score;

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

        findViewById(R.id.button5).setOnClickListener(v -> showResult());
    }

    private void showResult() {
        List<TestItem> items = testList.adapter.getItems();
        score = 0;

        for (TestItem item : items) {
            try {
                score += Integer.parseInt(item.getAnswer());

            } catch (Exception e) {
                Toast.makeText(this, "모든 질문에 대해 답변해 주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        Intent intent = new Intent(getApplicationContext(), TestResult.class);
        startActivity(intent);
//        Toast.makeText(this, "총 점수는 " + score + "점 입니다.", Toast.LENGTH_SHORT).show();
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
