package com.example.intothe.Test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.intothe.MainActivity;
import com.example.intothe.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestResult extends AppCompatActivity {

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_result);

        Button btScore = (Button) findViewById(R.id.btScore);
        TextView tvResult1 = (TextView) findViewById(R.id.tvResult1);
        TextView tvResult2 = (TextView) findViewById(R.id.tvResult2);
        ImageView btCancel = (ImageView) findViewById(R.id.cancel);


        // 테스트 날짜 가져오기
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);

        // 버튼 누르면 홈으로
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        // 테스트 결과 보여주기
        String stScore = Integer.toString(TestListView.score);
        btScore.setText("총점\n" + stScore + "점");

        if (TestListView.score <= 90) {
            tvResult1.setText("정상 수준");
            tvResult2.setText("자폐적 특성이 전혀 없거나 거의 없습니다.");
        }
        else {
            tvResult1.setText("가능성이 있습니다");
            tvResult2.setText("아동 자폐증이나 사회적 의사소통\n어려움의 가능성이 있습니다.\n본 검사는 진단이 아닌 선별검사일 뿐\n정확한 진단은 전문의를 통해\n상담하셔야 합니다.");
        }

//        ResultDBHelper myDb = new ResultDBHelper(TestResult.this);
//        myDb.addBook(mFormat.format(mDate), TestListView.score);
    }
}
